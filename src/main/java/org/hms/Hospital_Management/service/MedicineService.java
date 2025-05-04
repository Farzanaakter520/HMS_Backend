package org.hms.Hospital_Management.service;

import java.util.List;

import org.hms.Hospital_Management.model.Medicine;
import org.hms.Hospital_Management.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;

	public Medicine saveMedicine(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
	}

	public Medicine getMedicineById(Long id) {
		return medicineRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Medicine not found with ID: " + id));
	}
}
