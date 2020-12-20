package com.alwo.controller;

import com.alwo.dto.DtoMapper;
import com.alwo.dto.ProductDto;
import com.alwo.model.Product;
import com.alwo.service.ProductService;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    private DtoMapper dtoMapper;

    public ProductController(ProductService productService, DtoMapper dtoMapper) {
        this.productService = productService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/products")
    public List<ProductDto> getProducts(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page>= 0 ? page:0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return dtoMapper.mapToProductDtos(productService.getProducts(pageNumber, sortDirection));
    }

    @GetMapping("/products/{id}")
    public ProductDto getProduct(@PathVariable long id){
        return dtoMapper.mapToProductDto(productService.getProduct(id));
    }
}
