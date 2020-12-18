package com.alwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@Table(name = "shipment_statuses")
public class ShipmentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 10)
    private String shipmentStatus;

    public ShipmentStatus(@NotEmpty @Size(min = 2, max = 10) String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public ShipmentStatus() {
    }


}