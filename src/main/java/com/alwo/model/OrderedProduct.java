package com.alwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ordered_products")
public class OrderedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Order order;
    private int quantity;
    private double orderedProductPrice;

    public OrderedProduct(Product product, Order order, int quantity, double orderedProductPrice) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.orderedProductPrice = orderedProductPrice;
    }

    public OrderedProduct() {
    }
}
