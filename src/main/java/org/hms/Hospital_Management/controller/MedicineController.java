package org.hms.Hospital_Management.controller;

import java.util.List;

import org.hms.Hospital_Management.model.Medicine;
import org.hms.Hospital_Management.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	@PostMapping
	public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine) {
		Medicine saved = medicineService.saveMedicine(medicine);
		return ResponseEntity.ok(saved);
	}

	@GetMapping
	public ResponseEntity<List<Medicine>> getAllMedicines() {
		return ResponseEntity.ok(medicineService.getAllMedicines());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
		return ResponseEntity.ok(medicineService.getMedicineById(id));
	}
}
