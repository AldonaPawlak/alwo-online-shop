package com.alwo.service;


import com.alwo.model.Product;
import org.springframework.data.domain.Sort;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ProductService {

    @NotNull List<Product> getProducts(int page, Sort.Direction sort);

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product editProduct(@NotNull (message = "The product cannot be null.") @Valid Product product);

    Product addProduct(@NotNull (message = "The product cannot be null.") @Valid Product product);

    void deleteProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    List<Product> getProductsByCategories(List<String> categories);

}
