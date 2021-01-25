package com.alwo.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class OrderResponseDto {

    Long orderId;
    String username;
    String orderStatus;
    String shipmentMethod;
    String shipmentStatus;
    String paymentMethod;
    String paymentStatus;
    String purchaseDate;
    BigDecimal totalCost;

    public OrderResponseDto(Long orderId,
                            String username,
                            String orderStatus,
                            String shipmentMethod,
                            String shipmentStatus,
                            String paymentMethod,
                            String paymentStatus,
                            String purchaseDate,
                            BigDecimal totalCost) {
        this.orderId = orderId;
        this.username = username;
        this.orderStatus = orderStatus;
        this.shipmentMethod = shipmentMethod;
        this.shipmentStatus = shipmentStatus;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.purchaseDate = purchaseDate;
        this.totalCost = totalCost;
    }

    public OrderResponseDto() {
    }
}
