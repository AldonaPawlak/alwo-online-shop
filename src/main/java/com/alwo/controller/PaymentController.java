package com.alwo.controller;

import com.alwo.dto.DtoMapper;
import com.alwo.dto.PaymentDto;
import com.alwo.model.PaymentMethod;
import com.alwo.service.impl.BasketServiceImpl;
import com.alwo.service.impl.PaymentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {


    private final PaymentServiceImpl paymentService;
    private final DtoMapper dtoMapper;

    public PaymentController(PaymentServiceImpl paymentService, DtoMapper dtoMapper) {
        this.paymentService = paymentService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/alwo/payment-methods")
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentMethod> getPayments(){
        return paymentService.getPaymentMethods();
    }

}
