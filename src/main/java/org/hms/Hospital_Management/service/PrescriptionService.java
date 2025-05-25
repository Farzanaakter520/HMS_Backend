//package org.hms.Hospital_Management.service;
//
//import org.hms.Hospital_Management.model.Prescription;
//import org.hms.Hospital_Management.model.User;
//import org.hms.Hospital_Management.repository.PrescriptionRepository;
//import org.hms.Hospital_Management.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PrescriptionService {
//	@Autowired
//	private PrescriptionRepository prescriptionRepository;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	public Prescription createPrescription(Long doctorId, Long patientId, String description) {
//		User doctor = userRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
//		User patient = userRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
//
//		Prescription prescription = new Prescription(doctor, patient, description);
//		return prescriptionRepository.save(prescription);
//	}
//
//}
