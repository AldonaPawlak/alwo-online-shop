package com.alwo.service.impl;

import com.alwo.dto.DtoMapper;
import com.alwo.dto.OrderDataDto;
import com.alwo.dto.OrderResponseDto;
import com.alwo.dto.OrderedProductResponse;
import com.alwo.enums.*;
import com.alwo.exception.SpringAlwoException;
import com.alwo.model.*;
import com.alwo.repository.*;
import com.alwo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ShipmentService shipmentService;
    private PaymentService paymentService;
    private DtoMapper dtoMapper;
    private OrderStatusService orderStatusService;
    private OrderedProductRepository orderedProductRepository;
    private ContactDetailRepository contactDetailRepository;
    private AuthServiceImpl authServiceImpl;
    private ProductRepository productRepository;
    private static final int PAGE_SIZE = 10;

    private final EmailService emailSender;
    private final TemplateService templateService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ShipmentService shipmentService,
                            PaymentService paymentService,
                            DtoMapper dtoMapper,
                            OrderStatusService orderStatusService,
                            OrderedProductRepository orderedProductRepository,
                            ContactDetailRepository contactDetailRepository,
                            AuthServiceImpl authServiceImpl,
                            ProductRepository productRepository,
                            EmailService emailSender,
                            TemplateService templateService
                            ) {
        this.orderRepository = orderRepository;
        this.shipmentService = shipmentService;
        this.paymentService = paymentService;
        this.dtoMapper = dtoMapper;
        this.orderStatusService = orderStatusService;
        this.orderedProductRepository = orderedProductRepository;
        this.contactDetailRepository = contactDetailRepository;
        this.authServiceImpl = authServiceImpl;
        this.productRepository = productRepository;
        this.emailSender= emailSender;
        this.templateService = templateService;
    }

    public List<Order> getOrders(int page, Sort.Direction sort) {
        return orderRepository.findAllOrders(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    public Order getOrder(long id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Order " + id + " does not exist"));
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order editOrder(Order order) {
        return null;
    }

    @Override
    public void finishOrder(long orderId) {

    }

    @Override
    public void cancelOrder(long orderId) {

    }

    @Override
    @Cacheable(cacheNames = "UserOrders")
    public List<OrderResponseDto> getUserOrders() {
        User user = authServiceImpl.getCurrentUser();
        return dtoMapper.mapToOrderResponseDtos(orderRepository.findAllByUser(user));
    }

    @Override
    public void cancel(long orderId) {

    }

    @Override
    public Order createNewOrder(OrderDataDto orderDataDto) {
        User user = getUser();
        Order order = orderRepository.save(new Order());

        OrderStatus orderStatus = orderStatusService.getOrderStatus(OrderStatuses.INCOMPLETE.getValue());
        List<OrderedProduct> orderedProducts = createOrderedProducts(orderDataDto, order);
        List<ContactDetail> contactDetails = contactDetailRepository.saveAll(dtoMapper.mapToContactDetail(orderDataDto.getAddresses(), user, order));
        Shipment shipment = getShipmentFromData(orderDataDto);
        Payment payment = getPaymentFromData(orderDataDto);

        order.setOrderStatus(orderStatus);
        order.setOrderedProducts(orderedProducts);
        order.setUser(user);
        order.setAddresses(contactDetails);
        order.setShipment(shipment);
        order.setPayment(payment);
        order.setPurchaseDate(new Date());
        BigDecimal totalPrice = new BigDecimal(0);
        for (OrderedProduct orderedProduct : orderedProducts) {
            totalPrice =  totalPrice.add(orderedProduct.getTotalPrice());
        }
        order.setOrderedProductsCost(totalPrice);
        totalPrice = totalPrice.add(shipment.getShipmentMethod().getShipmentCost());
        order.setTotalCost(totalPrice);

        sendEmailWithOrder(orderedProducts, orderDataDto);
        return orderRepository.save(order);
    }

    private void sendEmailWithOrder(List<OrderedProduct> orderedProducts, OrderDataDto orderDataDto) {
        String email = "";
        for (int i = 0; i < orderDataDto.getAddresses().size(); i++){
            if (orderDataDto.getAddresses().get(i).getContactType().equals(ContactTypeEnum.INVOICE.name())) {
                email = orderDataDto.getAddresses().get(i).getEmail();
            }
        }
        emailSender.sendEmail(email, "Your order", templateService.orderEmail(orderedProducts));

    }

    private Payment getPaymentFromData(OrderDataDto orderDataDto) {
        PaymentMethod paymentMethod = paymentService.getPaymentMethodById(orderDataDto.getPaymentId());
        PaymentStatus paymentStatus = paymentService.getPaymentStatusById(PaymentStatuses.WAITING.getValue());
        return dtoMapper.mapToPayment(paymentStatus ,paymentMethod);
    }

    private Shipment getShipmentFromData(OrderDataDto orderDataDto) {
        ShipmentMethod shipmentMethod = shipmentService.getShipmentMethodById(orderDataDto.getShipmentId());
        ShipmentStatus shipmentStatus = shipmentService.getShipmentStatusById(ShipmentStatuses.INITIAL.getValue());
        return dtoMapper.mapToShipment(shipmentStatus, shipmentMethod);
    }

    private User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authServiceImpl.getCurrentUser();
        } else {
            return null;
        }
    }

    @Override
    public Order getUserOrder(long id) {
        User user = authServiceImpl.getCurrentUser();
        List<Order> userOrders = orderRepository.findAllByUser(user);
        List<Long> ids = userOrders.stream()
                .map(Order::getId)
                .collect(Collectors.toList());
        if (ids.contains(id)){
            return orderRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("Order " + id + " does not exist"));
        }
        throw  new SpringAlwoException("Invalid order id");
    }

    @Override
    public List<OrderedProduct> createOrderedProducts(OrderDataDto orderDataDto,  Order order) {
        List<Long> ids = orderDataDto.getOrderedProducts().stream()
                .map(OrderedProductResponse::getProductId)
                .collect(Collectors.toList());
        List<Product> products = productRepository.findAllByIdIn(ids);
        List<OrderedProduct> orderedProducts = new ArrayList<>();
        for (Product product : products) {
            for (OrderedProductResponse responseProduct : orderDataDto.getOrderedProducts()){
                if (product.getId().equals(responseProduct.getProductId())) {
                    OrderedProduct orderedProduct = getOrderedProduct(order, product, responseProduct);
                    orderedProducts.add(orderedProduct);
                }
            }
        }
        return orderedProductRepository.saveAll(orderedProducts);
    }

    private OrderedProduct getOrderedProduct(Order order, Product product, OrderedProductResponse responseProduct) {
        OrderedProduct orderedProduct = new OrderedProduct();
        orderedProduct.setProduct(product);
        orderedProduct.setProductName(product.getName());
        orderedProduct.setDescription(product.getDescription());
        orderedProduct.setAuthor(product.getAuthor());
        orderedProduct.setProducerName(product.getProducer().getName());
        orderedProduct.setTaxRate(product.getTax().getTaxRate());
        orderedProduct.setQuantity(responseProduct.getQuantity());
        orderedProduct.setTotalPrice(getTotalPrice(product, responseProduct.getQuantity()));
        orderedProduct.setOrder(order);
        return orderedProduct;
    }

    public BigDecimal getTotalPrice(Product product, int quantity) {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }

}
