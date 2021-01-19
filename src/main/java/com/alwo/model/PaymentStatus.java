package com.alwo.model;

import com.alwo.enums.PaymentStatuses;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "payment_statuses")
public class PaymentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_status")
    private String paymentStatus;

    public PaymentStatus(PaymentStatuses paymentStatus) {
        this.paymentStatus = paymentStatus.name();
    }

    public PaymentStatus() {
    }
}
