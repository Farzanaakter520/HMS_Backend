package org.hms.Hospital_Management.repository;

import org.hms.Hospital_Management.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface InventoryRepository extends JpaRepository <Inventory, Long> {

    Optional<Inventory> findByItemNameAndCategory(String itemName, String category);


    List<Inventory> findAllByItemNameContainingIgnoreCase(String name);


    List<Inventory> findByQuantityLessThan(int quantity);





}
