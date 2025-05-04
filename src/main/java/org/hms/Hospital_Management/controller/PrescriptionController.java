package org.hms.Hospital_Management.controller;

import org.hms.Hospital_Management.dto.PrescriptionDTO;
import org.hms.Hospital_Management.model.Prescription;
import org.hms.Hospital_Management.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

	@Autowired
	private PrescriptionService prescriptionService;

	@PostMapping
	public ResponseEntity<Prescription> createPrescription(@RequestBody PrescriptionDTO dto) {
		Prescription savedPrescription = prescriptionService.createPrescription(dto.getDoctorId(), dto.getPatientId(),
				dto.getDescription());
		return ResponseEntity.ok(savedPrescription);
	}
}
