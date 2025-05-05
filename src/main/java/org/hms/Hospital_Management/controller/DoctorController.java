package org.hms.Hospital_Management.controller;

import org.hms.Hospital_Management.model.Doctor;
import org.hms.Hospital_Management.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
		Doctor saved = doctorService.saveDoctor(doctor);
		return ResponseEntity.ok(saved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
		Doctor doctor = doctorService.getDoctorById(id);
		return ResponseEntity.ok(doctor);
	}

}
