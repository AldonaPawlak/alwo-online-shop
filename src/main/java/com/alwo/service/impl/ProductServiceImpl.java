package com.alwo.service.impl;

import com.alwo.exception.ResourceNotFoundException;
import com.alwo.model.Product;
import com.alwo.repository.ProductRepository;
import com.alwo.service.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private static final int PAGE_SIZE = 10;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(int page, Sort.Direction sort) {
        return productRepository.findAllProducts(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "name")));
    }

    //    @Cacheable(cacheNames = "SinglePost", key = "#id")
    public Product getProduct(long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product " + id + " does not exist"));
    }

    @Transactional
    public Product editProduct(Product product) {
//        Product productEdited = productRepository.findById(product.getId())
//                .orElseThrow(() -> new IllegalStateException("Product " + product.getId() + " does not exist"));
        Product productEdited = getProduct(product.getId());
        productEdited.setName(product.getName());
        productEdited.setDescription(productEdited.getDescription());
        productEdited.setPrice(product.getPrice());
        productEdited.setProducer(product.getProducer());
        productEdited.setTax(product.getTax());
        productEdited.setProductType(product.getProductType());
        productEdited.setPrice(product.getPrice());
        productEdited.setActive(product.isActive());
        productEdited.setCategories(product.getCategories());
        return productEdited;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}