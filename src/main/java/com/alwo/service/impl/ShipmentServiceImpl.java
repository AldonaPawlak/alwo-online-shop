package com.alwo.service.impl;

import com.alwo.exception.ResourceNotFoundException;
import com.alwo.model.Shipment;
import com.alwo.model.ShipmentMethod;
import com.alwo.model.ShipmentStatus;
import com.alwo.repository.ShipmentMethodRepository;
import com.alwo.repository.ShipmentRepository;
import com.alwo.repository.ShipmentStatusRepository;
import com.alwo.service.ShipmentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private ShipmentRepository shipmentRepository;
    private ShipmentStatusRepository shipmentStatusRepository;
    private ShipmentMethodRepository shipmentMethodRepository;
    private static final int PAGE_SIZE = 10;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository, ShipmentStatusRepository shipmentStatusRepository, ShipmentMethodRepository shipmentMethodRepository) {
        this.shipmentRepository = shipmentRepository;
        this.shipmentStatusRepository = shipmentStatusRepository;
        this.shipmentMethodRepository = shipmentMethodRepository;
    }

    @Override
    public List<Shipment> getShipments(int page, Sort.Direction sort) {
        return shipmentRepository.findAllShipments(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    @Override
     public Shipment getShipmentById(long id){
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment " + id + " does not exist"));
    }

    @Override
    public ShipmentMethod getShipmentMethodById(long id) {
        return shipmentMethodRepository.findShipmentMethodById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ShipmentMethod " + id + " does not exist"));
    }

    @Override
    public ShipmentStatus getShipmentStatusById(long id) {
        return null;
    }

    @Override
    public List<ShipmentMethod> getShipmentMethods(int page, Sort.Direction sort) {
        return shipmentRepository.findAllShipmentMethods(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    @Override
    public List<ShipmentStatus> getShipmentStatuses(int page, Sort.Direction sort) {
        return shipmentRepository.findAllShipmentStatuses(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }
}
