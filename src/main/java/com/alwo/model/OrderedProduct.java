package com.alwo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;

@Data
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
    @Lob
    private String description;
    private String producerName;
    private double taxRate;
    private int quantity;
    private double orderedProductPrice;
    private double totalPrice;

    public OrderedProduct(Product product, String productName, String description, String producerName, double taxRate, int quantity, double orderedProductPrice, double totalPrice) {
        this.product = product;
        this.productName = productName;
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
