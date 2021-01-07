package com.alwo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;

    private int quantity;
    private double orderedProductPrice;

    public OrderedProduct(Product product, int quantity, double orderedProductPrice) {
        this.product = product;
        this.quantity = quantity;
        this.orderedProductPrice = orderedProductPrice;
    }

    public OrderedProduct() {
    }
}
