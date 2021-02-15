package com.alwo.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class BasketProductDto {

    private Long id;
    private Long productId;
    private int quantity;
    private String name;
    private String author;
    private String description;
    private BigDecimal price;
    private String producer;
    private String productType;
    private int stock;
    private boolean isActive;
    private String url;

    public BasketProductDto() {
    }

    public BasketProductDto(Long id,
                            Long productId,
                            int quantity,
                            String name,
                            String author,
                            String description,
                            BigDecimal price,
                            String producer,
                            String productType,
                            int stock,
                            boolean isActive,
                            String url) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
        this.producer = producer;
        this.productType = productType;
        this.stock = stock;
        this.isActive = isActive;
        this.url = url;
    }
}
