package com.alwo.dto;

import com.alwo.model.Category;
import com.alwo.model.Producer;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;


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
    private String url;
    private List<Category> categories;

    public ProductDto(Long id,
                      String name,
                      String author,
                      String description,
                      BigDecimal price,
                      String producer,
                      String productType,
                      int stock,
                      boolean isActive,
                      String url,
                      List<Category> categories) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
        this.producer = producer;
        this.productType = productType;
        this.stock = stock;
        this.isActive = isActive;
        this.url = url;
        this.categories = categories;
    }
}
