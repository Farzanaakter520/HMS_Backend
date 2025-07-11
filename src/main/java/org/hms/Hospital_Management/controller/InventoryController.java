package org.hms.Hospital_Management.controller;


import org.hms.Hospital_Management.model.Inventory;
import org.hms.Hospital_Management.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/all")
    public List<Inventory> getAllMedicine() {
        return inventoryService.getAllMedicine();
    }

    @GetMapping("/search")
    public List<Inventory> getMedByName(@RequestParam String name) {
        return inventoryService.getMedByName(name);
    }


    @PostMapping("/receive")
    public ResponseEntity<Inventory> receiveMedicine(@RequestBody Inventory inventory) {
        Inventory saved = inventoryService.receiveMedicine(inventory); // This uses your accumulation logic
        return ResponseEntity.ok(saved);
    }


    @DeleteMapping("/delete-by-name-and-category")
    public ResponseEntity<String> deleteByNameAndCategory(@RequestParam String name,
                                                          @RequestParam String category) {
        inventoryService.deleteMedicineByNameAndCategory(name, category);
        return ResponseEntity.ok(name + category + " deleted successfully");
    }

    @PutMapping("/update-by-name-and-category")
    public ResponseEntity<Inventory> updateMedicineByNameAndStrength(@RequestParam String name, @RequestParam String category, @RequestBody Inventory updatedInventory) {
        Inventory updated = inventoryService.updateMedicineByNameAndCategory(name, category, updatedInventory);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/low-stock")
    public List<Inventory> getLowStockMedicines() {
        return inventoryService.getLowStockMedicines(10); // Threshold = 10 try to my best
    }
}