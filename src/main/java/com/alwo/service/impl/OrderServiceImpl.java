package com.alwo.service.impl;

import com.alwo.dto.DtoMapper;
import com.alwo.dto.OrderDataDto;
import com.alwo.dto.OrderResponseDto;
import com.alwo.enums.OrderStatuses;
import com.alwo.enums.PaymentStatuses;
import com.alwo.enums.ShipmentStatuses;
import com.alwo.exception.SpringAlwoException;
import com.alwo.model.*;
import com.alwo.repository.*;
import com.alwo.service.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    private OrderStatusRepository orderStatusRepository;
    private UserRepository userRepository;
    private BasketService basketService;
    private ShipmentService shipmentService;
    private PaymentService paymentService;
    private DtoMapper dtoMapper;
    private OrderStatusService orderStatusService;
    private OrderedProductRepository orderedProductRepository;
    private ContactDetailRepository contactDetailRepository;
    private AuthServiceImpl authServiceImpl;
    private static final int PAGE_SIZE = 10;

    public OrderServiceImpl(OrderRepository orderRepository, OrderStatusRepository orderStatusRepository, UserRepository userRepository, BasketService basketService, ShipmentService shipmentService, PaymentService paymentService, DtoMapper dtoMapper, OrderStatusService orderStatusService, OrderedProductRepository orderedProductRepository, ContactDetailRepository contactDetailRepository, AuthServiceImpl authServiceImpl) {
        this.orderRepository = orderRepository;
        this.orderStatusRepository = orderStatusRepository;
        this.userRepository = userRepository;
        this.basketService = basketService;
        this.shipmentService = shipmentService;
        this.paymentService = paymentService;
        this.dtoMapper = dtoMapper;
        this.orderStatusService = orderStatusService;
        this.orderedProductRepository = orderedProductRepository;
        this.contactDetailRepository = contactDetailRepository;
        this.authServiceImpl = authServiceImpl;
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
    public List<OrderResponseDto> getUserOrders() {
        User user = authServiceImpl.getCurrentUser();
        return dtoMapper.mapToOrderResponseDtos(orderRepository.findAllByUser(user));
    }

    @Override
    public void cancel(long orderId) {

    }

    @Override
    public Order createNewOrder(OrderDataDto orderDataDto) {
        Order order = orderRepository.save(new Order());
        User user = authServiceImpl.getCurrentUser();
        OrderStatus orderStatus = orderStatusService.getOrderStatus(OrderStatuses.INCOMPLETE.getValue());

        List<OrderedProduct> orderedProducts = getUserOrderedProducts(user, order);
        List<ContactDetail> contactDetails = contactDetailRepository.saveAll(dtoMapper.mapToContactDetail(orderDataDto.getAddresses(), user, order));

        ShipmentMethod shipmentMethod = shipmentService.getShipmentMethodById(orderDataDto.getShipmentMethod());
        ShipmentStatus shipmentStatus = shipmentService.getShipmentStatusById(ShipmentStatuses.INITIAL.getValue());
        System.out.println(shipmentStatus.toString());
        Shipment shipment = dtoMapper.mapToShipment(shipmentStatus, shipmentMethod);
        PaymentMethod paymentMethod = paymentService.getPaymentMethodById(orderDataDto.getPaymentMethod());
        PaymentStatus paymentStatus = paymentService.getPaymentStatusById(PaymentStatuses.WAITING.getValue());
        Payment payment = dtoMapper.mapToPayment(paymentStatus ,paymentMethod);
        order.setOrderStatus(orderStatus);
        order.setOrderedProducts(orderedProducts);
        order.setUser(user);
        order.setAddresses(contactDetails);
        order.setShipment(shipment);
        order.setPayment(payment);
        Date date = new Date();
        order.setPurchaseDate(date);
        BigDecimal totalPrice = new BigDecimal(0);
        for (OrderedProduct orderedProduct : orderedProducts) {
            totalPrice =  totalPrice.add(orderedProduct.getTotalPrice());
        }
        order.setOrderedProductsCost(totalPrice);
        totalPrice = totalPrice.add(shipment.getShipmentMethod().getShipmentCost());
        order.setTotalCost(totalPrice);

        return orderRepository.save(order);
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
    public List<OrderedProduct> getUserOrderedProducts(User user, Order order) {
        List<BasketProduct> basketProducts = basketService.getUserBasketProducts();
        List<OrderedProduct> orderedProducts = new ArrayList<>();
        basketService.deleteUserBasket();
        for (BasketProduct basketProduct : basketProducts) {
            OrderedProduct orderedProduct = new OrderedProduct();
            orderedProduct.setProduct(basketProduct.getProduct());
            orderedProduct.setProductName(basketProduct.getProduct().getName());
            orderedProduct.setDescription(basketProduct.getProduct().getDescription());
            orderedProduct.setProducerName(basketProduct.getProduct().getProducer().getName());
            orderedProduct.setTaxRate(basketProduct.getProduct().getTax().getTaxRate());
            orderedProduct.setQuantity(basketProduct.getQuantity());
            orderedProduct.setOrderedProductPrice(basketProduct.getProduct().getPrice());
            orderedProduct.setTotalPrice(basketProduct.getTotalPrice());
            orderedProduct.setOrder(order);
            orderedProducts.add(orderedProduct);
        }
        return orderedProductRepository.saveAll(orderedProducts);
    }
}
