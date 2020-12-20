package com.alwo.dto;

import com.alwo.model.Producer;
import com.alwo.model.ProductType;
import com.alwo.model.Tax;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private double price;
    private Producer producer;
    private Tax tax;
    private ProductType productType;
    private int stock;
    private boolean isActive;


}
