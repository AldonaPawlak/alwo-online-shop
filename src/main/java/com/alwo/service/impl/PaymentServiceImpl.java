package com.alwo.service.impl;

import com.alwo.exception.ResourceNotFoundException;
import com.alwo.model.*;
import com.alwo.repository.PaymentMethodRepository;
import com.alwo.repository.PaymentRepository;
import com.alwo.repository.PaymentStatusRepository;
import com.alwo.service.PaymentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;
    private PaymentStatusRepository paymentStatusRepository;
    private PaymentMethodRepository paymentMethodRepository;
    private static final int PAGE_SIZE = 10;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentStatusRepository paymentStatusRepository, PaymentMethodRepository paymentMethodRepository) {
        this.paymentRepository = paymentRepository;
        this.paymentStatusRepository = paymentStatusRepository;
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(long id){
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment " + id + " does not exist"));
    }

    @Override
    public PaymentMethod getPaymentMethodById(long id) {
        return paymentMethodRepository.findPaymentMethodById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ShipmentMethod " + id + " does not exist"));
    }

    @Override
    public PaymentStatus getPaymentStatusById(long id) {
        return paymentStatusRepository.findPaymentStatusById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ShipmentMethod " + id + " does not exist"));
    }

    @Override
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public List<PaymentStatus> getPaymentStatuses(int page, Sort.Direction sort) {
        return paymentStatusRepository.findAllPaymentStatuses(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }
}
