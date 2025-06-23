package org.hms.Hospital_Management.repository;

import java.util.List;

import org.hms.Hospital_Management.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findAllByDoctorId(Long id);
    
}
