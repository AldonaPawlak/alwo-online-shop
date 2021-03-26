package com.alwo.repository;

import com.alwo.model.BasketProduct;
import com.alwo.model.Product;
import com.alwo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {

    List<BasketProduct> findAllByUser(User user);

    BasketProduct findBasketProductByProduct(Product product);

}

