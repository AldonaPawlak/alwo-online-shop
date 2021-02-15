package com.alwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "shipment_methods")
public class ShipmentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String shipmentMethod;
    private BigDecimal shipmentCost;
    private String url;
    private String description;

    public ShipmentMethod(@NotEmpty String shipmentMethod,
                          BigDecimal shipmentCost,
                          String url,
                          String description) {
        this.shipmentMethod = shipmentMethod;
        this.shipmentCost = shipmentCost;
        this.url = url;
        this.description = description;
    }

    public ShipmentMethod() {
    }


}
