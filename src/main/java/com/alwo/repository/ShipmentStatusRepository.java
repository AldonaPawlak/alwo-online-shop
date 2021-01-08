package com.alwo.repository;

import com.alwo.model.ShipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipmentStatusRepository extends JpaRepository<ShipmentStatus, Long> {

    Optional<ShipmentStatus> findShipmentStatusById(Long shipmentStatusId);
}
