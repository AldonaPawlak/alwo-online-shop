package com.alwo.dto;

import com.alwo.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoMapper {

    private DtoMapper(){}

    public List<ProductDto> mapToProductDtos(List<Product> products) {
        return products.stream()
                .map(product -> mapToProductDto(product)).collect(Collectors.toList());
    }

    public ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .producer(product.getProducer())
                .tax(product.getTax())
                .productType(product.getProductType())
                .stock(product.getStock())
                .isActive(product.isActive())
                .build();
    }
}
