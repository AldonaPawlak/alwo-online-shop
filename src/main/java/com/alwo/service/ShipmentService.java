package com.alwo.service;

import com.alwo.model.Shipment;
import com.alwo.model.ShipmentMethod;
import com.alwo.model.ShipmentStatus;
import org.springframework.data.domain.Sort;

import java.util.List;


public interface ShipmentService {

    List<Shipment> getShipments(int page, Sort.Direction sort);

    Shipment getShipmentById(long id);

    ShipmentMethod getShipmentMethodById(long id);

    ShipmentStatus getShipmentStatusById(long id);

    List<ShipmentMethod> getShipmentMethods(int page, Sort.Direction sort);

    List<ShipmentStatus> getShipmentStatuses(int page, Sort.Direction sort);
}
