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

    // Save or update medicine
    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    // Get all medicines
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    // Get medicine by ID
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id).orElse(null);
    }

    // Delete medicine by ID
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }
}
