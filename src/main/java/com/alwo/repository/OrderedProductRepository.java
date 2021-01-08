package com.alwo.repository;

import com.alwo.model.OrderedProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Long> {

    @Query("select op from OrderedProduct op")
    List<OrderedProduct> findAllOrderedProduct(Pageable page);
}
