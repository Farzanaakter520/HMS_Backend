package org.hms.Hospital_Management.repository;

import org.hms.Hospital_Management.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
