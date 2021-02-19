package com.alwo.repository;

import com.alwo.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p")
    List<Product> findAllProducts(Pageable page);

    List<Product> findAllByIdIn(List<Long> ids);
//
//    @Query("select p from Product p")
//    List<Product> findAllProductsToCategory();
}
