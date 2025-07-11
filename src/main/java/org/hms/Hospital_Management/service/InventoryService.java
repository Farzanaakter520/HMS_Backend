package org.hms.Hospital_Management.service;


import org.hms.Hospital_Management.model.Inventory;
import org.hms.Hospital_Management.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory saveMedicine(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory getMedicineById(Long id) {
        return inventoryRepository.findById(id).get();
    }

    public boolean updateInventoryCount(int count, String operator, Inventory inventory) {
        try {
            if (operator == "deduct") {
                inventory.setQuantity(inventory.getQuantity() - count);
            }
            inventoryRepository.save(inventory);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Inventory> getAllMedicine() {
        return inventoryRepository.findAll();
    }

    public List<Inventory> getMedByName(String name) {
        return inventoryRepository.findAllByItemNameContainingIgnoreCase(name);
    }

    public void deleteMedicineByNameAndCategory(String name, String category) {
        Inventory inventory = inventoryRepository.findByItemNameAndCategory(name, category)
                .orElseThrow(() -> new RuntimeException("Medicine not found with name: " + name + category));
        inventoryRepository.delete(inventory);
    }

    public Inventory updateMedicineByNameAndCategory(String name, String category, Inventory updatedInventory) {
        Inventory inventory = inventoryRepository.findByItemNameAndCategory(name, category)
                .orElseThrow(() -> new RuntimeException("Medicine not found with name: " + name + category));

        inventory.setCategory(updatedInventory.getCategory());
        inventory.setUnitPrice(updatedInventory.getUnitPrice());
        inventory.setPurchaseDiscount(updatedInventory.getPurchaseDiscount());
        inventory.setSellPrice(updatedInventory.getSellPrice());

        return inventoryRepository.save(inventory);
    }

    // Modified receive logic to update quantity if item exists
    public Inventory receiveMedicine(Inventory newInventory) {
        Optional<Inventory> existing = inventoryRepository.findByItemNameAndCategory(
                newInventory.getItemName(), newInventory.getCategory());

        if (existing.isPresent()) {
            Inventory inventory = existing.get();
            inventory.setQuantity(inventory.getQuantity() + newInventory.getQuantity());
            inventory.setUnitPrice(newInventory.getUnitPrice());
            inventory.setPurchaseDiscount(newInventory.getPurchaseDiscount());
            inventory.setNetPurchasePrice(newInventory.getNetPurchasePrice());
            inventory.setSellPrice(newInventory.getSellPrice());
            return inventoryRepository.save(inventory);
        } else {
            return inventoryRepository.save(newInventory);
        }
    }

    public List<Inventory> getLowStockMedicines(int threshold) {
        return inventoryRepository.findByQuantityLessThan(threshold);
    }
}