package com.alwo.dto;

import com.alwo.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoMapper {

    private DtoMapper(){}

    public List<ProductDto> mapToProductDtos(List<Product> products) {
        return products.stream()
                .map(product -> mapToProductDto(product)).collect(Collectors.toList());
    }

    public ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .author(product.getAuthor())
                .description(product.getDescription())
                .price(product.getPrice())
                .producer(product.getProducer().getName())
                .productType(product.getProductType().getProductType())
                .stock(product.getStock())
                .isActive(product.isActive())
                .url(product.getUrl())
                .categories(product.getCategories())
                .build();
    }

    public List<ContactDetail> mapToContactDetail(List<ContactDetailDto> contactDetailDto, User user, Order order) {
        List<ContactDetail> contactDetails = new ArrayList<>();
        for (ContactDetailDto detailDto : contactDetailDto) {
            contactDetails.add(
                    new ContactDetail(
                            user,
                            detailDto.getFirstName(),
                            detailDto.getLastName(),
                            detailDto.getStreet(),
                            detailDto.getApartmentNumber(),
                            detailDto.getZipCode(),
                            detailDto.getCity(),
                            detailDto.getDescription(),
                            new ContactType(detailDto.getContactType()),
                            order
                    )
            );
        }
        return contactDetails;
    }

    public Shipment mapToShipment(ShipmentStatus shipmentStatus, ShipmentMethod shipmentMethod ) {
        return new Shipment(shipmentStatus, shipmentMethod);
    }

    public Payment mapToPayment(PaymentStatus paymentStatus, PaymentMethod paymentMethod) {
        return new Payment(paymentStatus, paymentMethod);
    }

    public List<OrderResponseDto> mapToOrderResponseDtos(List<Order> orders){
        return orders.stream()
                .map(this::mapToOrderResponseDto).collect(Collectors.toList());
    }

    private OrderResponseDto mapToOrderResponseDto(Order order) {
        return OrderResponseDto.builder()
                .orderId(order.getId())
                .username(order.getUser().getUsername())
                .orderStatus(order.getOrderStatus().getOrderStatus())
                .shipmentMethod(order.getShipment().getShipmentMethod().getShipmentMethod())
                .shipmentStatus(order.getShipment().getShipmentStatus().getShipmentStatus())
                .paymentMethod(order.getPayment().getPaymentMethod().getPaymentMethod())
                .paymentStatus(order.getPayment().getPaymentStatus().getPaymentStatus())
                .purchaseDate(order.getPurchaseDate().toString())
                .totalCost(order.getTotalCost())
                .build();

    }

    public List<BasketProductDto> mapToBasketProductDtos(List<BasketProduct> userBasketProducts) {
        return userBasketProducts.stream()
                .map(this::mapToBasketProductDto).collect(Collectors.toList());
    }

    public BasketProductDto mapToBasketProductDto(BasketProduct basketProduct) {
        return BasketProductDto.builder()
                .id(basketProduct.getId())
                .productId(basketProduct.getProduct().getId())
                .quantity(basketProduct.getQuantity())
                .name(basketProduct.getProduct().getName())
                .author(basketProduct.getProduct().getAuthor())
                .description(basketProduct.getProduct().getDescription())
                .price(basketProduct.getProduct().getPrice())
                .producer(basketProduct.getProduct().getProducer().getName())
                .productType(basketProduct.getProduct().getProductType().getProductType())
                .stock(basketProduct.getProduct().getStock())
                .isActive(basketProduct.getProduct().isActive())
                .build();
    }
}
