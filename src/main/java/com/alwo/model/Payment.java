package com.alwo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private PaymentStatus paymentStatus;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private PaymentMethod paymentMethod;

    public Payment(PaymentStatus paymentStatus, PaymentMethod paymentMethod) {
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
    }

    public Payment() {
    }
}
