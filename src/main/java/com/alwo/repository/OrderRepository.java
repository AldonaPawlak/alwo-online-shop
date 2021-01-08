package com.alwo.repository;

import com.alwo.model.Order;
import com.alwo.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

    @Query("select o from Order o")
    List<Order> findAllOrders(Pageable page);

    @Override
    Optional<Order> findById(Long orderId);

    List<Order> findAllByUser(User user);
}
