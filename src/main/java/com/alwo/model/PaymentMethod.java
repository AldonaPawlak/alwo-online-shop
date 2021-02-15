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
    private String paymentMethod;
    private String url;
    private String description;


    public PaymentMethod(@NotEmpty String paymentMethod, String url, String description) {
        this.paymentMethod = paymentMethod;
        this.url = url;
        this.description = description;
    }

    public PaymentMethod() {
    }
}
