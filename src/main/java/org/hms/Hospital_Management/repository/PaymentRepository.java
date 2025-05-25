package org.hms.Hospital_Management.repository;

import org.hms.Hospital_Management.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	Payment findByAppointment_id(Long appointmentID);
}
