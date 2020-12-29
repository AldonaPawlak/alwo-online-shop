package com.alwo.controller;

import com.alwo.dto.DtoMapper;
import com.alwo.dto.ProductDto;
import com.alwo.model.Category;
import com.alwo.model.Product;
import com.alwo.service.CategoryService;
import com.alwo.service.ProductService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;
    private DtoMapper dtoMapper;

    public CategoryController(CategoryService categoryService, DtoMapper dtoMapper) {
        this.categoryService = categoryService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/categories")
    public List<Category> getProducts(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page>= 0 ? page:0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
//        return dtoMapper.mapToProductDtos(productService.getProducts(pageNumber, sortDirection));
        return categoryService.getCategories(pageNumber, sortDirection);
    }

    @GetMapping("/categories/{id}")
//    public ProductDto getProduct(@PathVariable long id){
    public Category getCategory(@PathVariable long id){
//        return dtoMapper.mapToProductDto(productService.getProduct(id));
        return categoryService.getCategory(id);
    }

    // ONLY ADMIN
//    @PutMapping("/admin/categories")
//    public Category editCategory(@RequestBody Category category){
//        return categoryService.editCategory(category);
//    }
}