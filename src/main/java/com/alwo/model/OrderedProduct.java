package com.alwo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "ordered_products")
public class OrderedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;
    private String productName;
    private String author;
    private String description;
    private String producerName;
    private double taxRate;
    private int quantity;
    private BigDecimal orderedProductPrice;
    private BigDecimal totalPrice;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderedProduct(Product product,
                          String productName,
                          String description,
                          String author,
                          String producerName,
                          double taxRate,
                          int quantity,
                          BigDecimal orderedProductPrice,
                          BigDecimal totalPrice) {
        this.product = product;
        this.productName = productName;
        this.author = author;
        this.description = description;
        this.producerName = producerName;
        this.taxRate = taxRate;
        this.quantity = quantity;
        this.orderedProductPrice = orderedProductPrice;
        this.totalPrice = totalPrice;
    }

    public OrderedProduct() {
    }
}
