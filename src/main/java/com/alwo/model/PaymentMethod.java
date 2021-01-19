package com.alwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@Table(name = "payment_methods")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 10)
    private String paymentMethod;

    public PaymentMethod(@NotEmpty @Size(min = 2, max = 10) String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod() {
    }
}
