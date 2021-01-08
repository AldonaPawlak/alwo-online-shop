package com.alwo.model;

import com.alwo.enums.ShipmentStatuses;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Setter
@Getter
@Table(name = "shipment_statuses")
public class ShipmentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "shipment_status")
    private String shipmentStatus;

    public ShipmentStatus(ShipmentStatuses shipmentStatus) {
        this.shipmentStatus = shipmentStatus.name();
    }

    public ShipmentStatus() {
    }
}
