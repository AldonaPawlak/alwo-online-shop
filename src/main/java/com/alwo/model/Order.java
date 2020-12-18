package com.alwo.model;

import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long orderStatusId;
    private Long shipmentId;
    private Long paymentId;
    private Date purchaseDate;
    private Double orderedProductsCost;
    private Double shipmentCost;
    private Double totalCost;

    public Order(Long userId, Long orderStatusId, Long shipmentId, Long paymentId, Date purchaseDate, Double orderedProductsCost, Double shipmentCost, Double totalCost) {
        this.userId = userId;
        this.orderStatusId = orderStatusId;
        this.shipmentId = shipmentId;
        this.paymentId = paymentId;
        this.purchaseDate = purchaseDate;
        this.orderedProductsCost = orderedProductsCost;
        this.shipmentCost = shipmentCost;
        this.totalCost = totalCost;
    }

    public Order() {}
}