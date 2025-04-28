package org.hms.Hospital_Management.repository;

import org.hms.Hospital_Management.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
