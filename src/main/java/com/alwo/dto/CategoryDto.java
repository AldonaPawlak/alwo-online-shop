package com.alwo.dto;

import com.alwo.model.Product;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class CategoryDto {
    private Long id;
    private String categoryName;
    private String description;
    private List<Product> products = new ArrayList<>();


}
