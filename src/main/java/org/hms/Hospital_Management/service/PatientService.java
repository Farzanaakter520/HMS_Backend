package org.hms.Hospital_Management.service;

import java.util.List;
import java.util.Optional;

import org.hms.Hospital_Management.model.Patient;
import org.hms.Hospital_Management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public Optional<Patient> getPatientById(Long id) {
		return patientRepository.findById(id);
	}

	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}

	public Patient updatePatient(Long id, Patient updatedPatient) {
		return patientRepository.findById(id).map(patient -> {
			patient.setName(updatedPatient.getName());
			patient.setAge(updatedPatient.getAge());
			patient.setGender(updatedPatient.getGender());
			patient.setBloodGroup(updatedPatient.getBloodGroup());
			patient.setAddress(updatedPatient.getAddress());
			patient.setPhone(updatedPatient.getPhone());
			patient.setEmail(updatedPatient.getEmail());
			return patientRepository.save(patient);
		}).orElse(null);
	}
}
