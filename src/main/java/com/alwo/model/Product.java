package com.alwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
//    private Long supplierId;
//    private Long taxId;
//    private Long productTypeId;
    private int stock;
    private boolean isActive;

    public Product(String name, String description, double price, int stock, boolean isActive) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.isActive = isActive;
    }

    public Product() {
    }

}