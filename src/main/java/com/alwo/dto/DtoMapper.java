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
                .description(product.getDescription())
                .price(product.getPrice())
                .producer(product.getProducer())
                .tax(product.getTax())
                .productType(product.getProductType())
                .stock(product.getStock())
                .isActive(product.isActive())
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
}
