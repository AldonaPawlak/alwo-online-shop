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
    private Producer producer;
    private String url;
    private List<Category> categories;
}
