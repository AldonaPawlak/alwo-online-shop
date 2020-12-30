package com.alwo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "basket_products")
public class BasketProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    Product product;
    private int quantity;

    private double totalPrice;

    public BasketProduct() {
    }

    public BasketProduct(User user, Product product, int quantity, double totalPrice) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}

