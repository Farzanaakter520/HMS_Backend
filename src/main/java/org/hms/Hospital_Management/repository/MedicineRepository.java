package org.hms.Hospital_Management.repository;

import org.hms.Hospital_Management.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
