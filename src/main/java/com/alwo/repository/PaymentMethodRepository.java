package com.alwo.repository;

import com.alwo.model.PaymentMethod;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    @Query("select pm from PaymentMethod pm")
    List<PaymentMethod> findAllPaymentMethods(Pageable page);
    Optional<PaymentMethod> findPaymentMethodById(Long paymentMethodId);
}
