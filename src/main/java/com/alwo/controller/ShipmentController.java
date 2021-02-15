package com.alwo.controller;

import com.alwo.dto.DtoMapper;
import com.alwo.model.PaymentMethod;
import com.alwo.model.ShipmentMethod;
import com.alwo.service.impl.PaymentServiceImpl;
import com.alwo.service.impl.ShipmentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShipmentController {

    private final ShipmentServiceImpl shipmentService;

    public ShipmentController(ShipmentServiceImpl shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping("/alwo/shipment-methods")
    @ResponseStatus(HttpStatus.OK)
    public List<ShipmentMethod> getShipments(){
        return shipmentService.getShipmentMethods();
    }

}
