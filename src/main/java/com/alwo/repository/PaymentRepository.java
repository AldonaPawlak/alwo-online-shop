package com.alwo.repository;

import com.alwo.model.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

//    @Query("select p from Payment p")
//    List<Payment> findAllPayments(Pageable page);
//
//    Optional<Payment> findById(Long paymentId);
}
