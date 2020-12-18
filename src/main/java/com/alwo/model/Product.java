package com.alwo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Supplier supplier;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Tax tax;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ProductType productType;
    private int stock;
    private boolean isActive;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "product_categories",
            joinColumns = { @JoinColumn(name = "product_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id", referencedColumnName = "id") })
    private List<Category> categories = new ArrayList<>();

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