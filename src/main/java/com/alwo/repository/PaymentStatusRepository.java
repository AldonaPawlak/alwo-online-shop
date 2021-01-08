package com.alwo.repository;

import com.alwo.model.PaymentStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Long> {

    @Query("select ps from PaymentStatus ps")
    List<PaymentStatus> findAllPaymentStatuses(Pageable page);

    Optional<PaymentStatus> findPaymentStatusById(Long paymentStatusId);
}
