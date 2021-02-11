package com.alwo.dto;

import com.alwo.model.Producer;
import com.alwo.model.ProductType;
import com.alwo.model.Tax;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;


@Getter
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private String author;
    private String description;
    private BigDecimal price;
    private String producer;
    private String productType;
    private int stock;
    private boolean isActive;

    public ProductDto(Long id,
                      String name,
                      String author,
                      String description,
                      BigDecimal price,
                      String producer,
                      String productType,
                      int stock,
                      boolean isActive) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
        this.producer = producer;
        this.productType = productType;
        this.stock = stock;
        this.isActive = isActive;
    }
}
