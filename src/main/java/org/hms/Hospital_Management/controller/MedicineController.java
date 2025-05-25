package org.hms.Hospital_Management.controller;

import java.util.List;

import org.hms.Hospital_Management.model.Medicine;
import org.hms.Hospital_Management.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    // Create a new medicine
    @PostMapping
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine) {
        Medicine saved = medicineService.saveMedicine(medicine);
        return ResponseEntity.ok(saved);
    }

    // Get all medicines
    @GetMapping
    public ResponseEntity<List<Medicine>> getAllMedicines() {
        return ResponseEntity.ok(medicineService.getAllMedicines());
    }

    // Get a medicine by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
        Medicine medicine = medicineService.getMedicineById(id);
        if (medicine == null) {
            return ResponseEntity.notFound().build();  
        }
        return ResponseEntity.ok(medicine);
    }

    // Update an existing medicine
    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicine) {
        Medicine existingMedicine = medicineService.getMedicineById(id);
        if (existingMedicine == null) {
            return ResponseEntity.notFound().build();  
        }
        medicine.setId(id);  
        Medicine updated = medicineService.saveMedicine(medicine); 
        return ResponseEntity.ok(updated);
    }

    // Delete a medicine by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
        Medicine existingMedicine = medicineService.getMedicineById(id);
        if (existingMedicine == null) {
            return ResponseEntity.notFound().build();  
        }
        medicineService.deleteMedicine(id);  
        return ResponseEntity.noContent().build();  
    }
}
