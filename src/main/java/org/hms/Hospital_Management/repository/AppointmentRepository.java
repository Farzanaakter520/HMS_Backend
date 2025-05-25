package org.hms.Hospital_Management.repository;

import org.hms.Hospital_Management.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    
}
