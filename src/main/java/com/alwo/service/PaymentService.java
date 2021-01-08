package com.alwo.service;

import com.alwo.model.*;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PaymentService {

    List<Payment> getPayments(int page, Sort.Direction sort);

    Payment getPaymentById(long id);

    PaymentMethod getPaymentMethodById(long id);

    PaymentStatus getPaymentStatusById(long id);

    List<PaymentMethod> getPaymentMethods(int page, Sort.Direction sort);

    List<PaymentStatus> getPaymentStatuses(int page, Sort.Direction sort);
}
