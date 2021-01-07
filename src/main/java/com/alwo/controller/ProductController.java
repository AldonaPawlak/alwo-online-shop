package com.alwo.controller;

import com.alwo.dto.DtoMapper;
import com.alwo.dto.ProductDto;
import com.alwo.model.Category;
import com.alwo.model.Product;
import com.alwo.service.ProductService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    private DtoMapper dtoMapper;

    public ProductController(ProductService productService, DtoMapper dtoMapper) {
        this.productService = productService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/alwo/products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getProducts(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page>= 0 ? page:0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return dtoMapper.mapToProductDtos(productService.getProducts(pageNumber, sortDirection));
    }

    @GetMapping("/alwo/products/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProductsByCategory(@RequestParam List<String> categories) {
        return productService.getProductsByCategories(categories);
    }


    @GetMapping("/alwo/products/{id}")
    @ResponseStatus(HttpStatus.OK)
//    public ProductDto getProduct(@PathVariable long id){
    public Product getProduct(@PathVariable long id){
//        return dtoMapper.mapToProductDto(productService.getProduct(id));
        return productService.getProduct(id);
    }



    // ONLY ADMIN
    @PutMapping("/admin/alwo/products")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Product editProduct(@RequestBody Product product){
        return productService.editProduct(product);
    }

    @PostMapping("/admin/alwo/products")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/admin/alwo/products/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
    }
}
