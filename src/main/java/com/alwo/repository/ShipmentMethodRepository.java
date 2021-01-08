package com.alwo.repository;

import com.alwo.model.ShipmentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipmentMethodRepository extends JpaRepository<ShipmentMethod, Long> {

    Optional<ShipmentMethod> findShipmentMethodById(Long shipmentMethodId);
}
