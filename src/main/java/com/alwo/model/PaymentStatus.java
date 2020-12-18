package com.alwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@Table(name = "payment_statuses")
public class PaymentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 10)
    private String paymentStatus;

    public PaymentStatus(@NotEmpty @Size(min = 2, max = 10) String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentStatus() {
    }


}