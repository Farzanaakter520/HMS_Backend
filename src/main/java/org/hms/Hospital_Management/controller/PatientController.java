package org.hms.Hospital_Management.controller;

import java.util.List;
import java.util.Optional;

import org.hms.Hospital_Management.model.Patient;
import org.hms.Hospital_Management.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

	@PostMapping
	public Patient createPatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}

	@GetMapping("/{id}")
	public Optional<Patient> getPatientById(@PathVariable Long id) {
		return patientService.getPatientById(id);
	}

	@PutMapping("/{id}")
	public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
		return patientService.updatePatient(id, patient);
	}

	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable Long id) {
		patientService.deletePatient(id);
	}
}
