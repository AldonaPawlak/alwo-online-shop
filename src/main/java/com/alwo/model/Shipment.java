package com.alwo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private ShipmentStatus shipmentStatus;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private ShipmentMethod shipmentMethod;

    public Shipment(ShipmentStatus shipmentStatus, ShipmentMethod shipmentMethod) {
        this.shipmentStatus = shipmentStatus;
        this.shipmentMethod = shipmentMethod;
    }

    public Shipment() {
    }
}
