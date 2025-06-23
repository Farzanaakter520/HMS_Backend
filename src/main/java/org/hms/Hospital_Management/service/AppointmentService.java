package org.hms.Hospital_Management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.hms.Hospital_Management.dto.AppointmentDTO;
import org.hms.Hospital_Management.model.Appointment;
import org.hms.Hospital_Management.model.User;
import org.hms.Hospital_Management.repository.AppointmentRepository;
import org.hms.Hospital_Management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private UserRepository userRepository;

	// Method to create an appointment from DTO
	public AppointmentDTO createAppointment(AppointmentDTO dto) {
		User patient = userRepository.findById(dto.getPatientId())
				.orElseThrow(() -> new RuntimeException("Patient not found"));
		User doctor = userRepository.findById(dto.getDoctorId())
				.orElseThrow(() -> new RuntimeException("Doctor not found"));

		Appointment appointment = new Appointment();
		appointment.setPatient(patient);
		appointment.setDoctor(doctor);
		appointment.setScheduledTime(dto.getScheduledTime());

		Appointment saved = appointmentRepository.save(appointment);
		return convertToDTO(saved);
	}

	// Method to retrieve all appointments
	public List<AppointmentDTO> getAllAppointments() {
		return appointmentRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	// Method to get a specific appointment by ID
	public AppointmentDTO getAppointmentById(Long id) {
		return appointmentRepository.findById(id).map(this::convertToDTO)
				.orElseThrow(() -> new RuntimeException("Appointment not found"));
	}

	// Method to delete an appointment
	public void deleteAppointment(Long id) {
		if (!appointmentRepository.existsById(id)) {
			throw new RuntimeException("Appointment not found");
		}
		appointmentRepository.deleteById(id);
	}

	// Convert the Appointment entity to AppointmentDTO
	private AppointmentDTO convertToDTO(Appointment appointment) {
		AppointmentDTO dto = new AppointmentDTO();

		dto.setPatientId(appointment.getPatient().getId());
		dto.setDoctorId(appointment.getDoctor().getId());
		dto.setScheduledTime(appointment.getScheduledTime());
		return dto;
	}

	public List<AppointmentDTO> getAppointmentSByDoctorId(Long id) {
		
		List<Appointment> applist = appointmentRepository.findAllByDoctorId(id);
		
		return applist.stream().map(this::convertToDTO).collect(Collectors.toList());
	}
}
