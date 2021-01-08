package com.alwo.repository;

import com.alwo.model.Shipment;
import com.alwo.model.ShipmentMethod;
import com.alwo.model.ShipmentStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    @Query("select s from Shipment s")
    List<Shipment> findAllShipments(Pageable page);

    @Query("select sm from ShipmentMethod sm")
    List<ShipmentMethod> findAllShipmentMethods(Pageable page);

    @Query("select ss from ShipmentStatus ss")
    List<ShipmentStatus> findAllShipmentStatuses(Pageable page);

    @Override
    Optional<Shipment> findById(Long shipmentId);
}
