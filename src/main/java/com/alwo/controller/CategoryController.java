package com.alwo.controller;

import com.alwo.dto.DtoMapper;
import com.alwo.model.Category;
import com.alwo.service.CategoryService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CategoryController {

    private CategoryService categoryService;
    private DtoMapper dtoMapper;

    public CategoryController(CategoryService categoryService, DtoMapper dtoMapper) {
        this.categoryService = categoryService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/alwo/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getCategories(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page>= 0 ? page:0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
//        return dtoMapper.mapToProductDtos(productService.getProducts(pageNumber, sortDirection));
        return categoryService.getCategories(pageNumber, sortDirection);
    }

    @GetMapping("/alwo/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
//    public ProductDto getProduct(@PathVariable long id){
    public Category getCategory(@PathVariable long id){
//        return dtoMapper.mapToProductDto(productService.getProduct(id));
        return categoryService.getCategory(id);
    }

    @GetMapping("/alwo/categories/selected")   // http://localhost:8080/alwo/categories/selected?categories=category1,category2,category3
    @ResponseStatus(HttpStatus.OK)
    public Set<Category> getSelectedCategories(@RequestParam(required = false) List<String> categories) {
        return categoryService.getCategoriesBYNames(categories);
    }

    // ONLY ADMIN
//    @PutMapping("/admin/categories")
//    public Category editCategory(@RequestBody Category category){
//        return categoryService.editCategory(category);
//    }
}
