package com.alwo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private OrderStatus orderStatus;
    @OneToMany(mappedBy = "order")
//    @JoinColumn(name = "id", updatable = false, insertable = false)
    private List<ContactDetail> addresses = new ArrayList<>();
    @OneToMany(mappedBy = "order")
//    @JoinColumn(name = "id", updatable = false, insertable = false)
    private List<OrderedProduct> orderedProducts = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Shipment shipment;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Payment payment;

    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    private BigDecimal orderedProductsCost;
    private BigDecimal totalCost;

    public Order(User user, OrderStatus orderStatus, Shipment shipment, Payment payment, Date purchaseDate, BigDecimal orderedProductsCost, BigDecimal totalCost) {
        this.user = user;
        this.orderStatus = orderStatus;
        this.shipment = shipment;
        this.payment = payment;
        this.purchaseDate = purchaseDate;
        this.orderedProductsCost = orderedProductsCost;
        this.totalCost = totalCost;
    }

    public Order() {}

}
