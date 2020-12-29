package com.alwo.service;


import com.alwo.model.Product;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(int page, Sort.Direction sort);

    Product getProduct(long id);

    Product editProduct(Product product);

}
