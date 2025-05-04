package org.hms.Hospital_Management.service;

import java.util.List;

import org.hms.Hospital_Management.model.Doctor;
import org.hms.Hospital_Management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	public Doctor getDoctorById(Long id) {
		return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
	}
}
