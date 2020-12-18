package com.alwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@Table(name = "shipment_methods")
public class ShipmentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 10)
    private String shipmentMethod;

    public ShipmentMethod(@NotEmpty @Size(min = 2, max = 10) String shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public ShipmentMethod() {
    }


}