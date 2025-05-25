package org.hms.Hospital_Management.controller;

import java.util.List;

import org.hms.Hospital_Management.dto.AppointmentDTO;
import org.hms.Hospital_Management.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	// Endpoint to create a new appointment
	@PostMapping
	public AppointmentDTO createAppointment(@RequestBody AppointmentDTO dto) {
		return appointmentService.createAppointment(dto);
	}

	// Endpoint to get all appointments
	@GetMapping
	public List<AppointmentDTO> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}

	// Endpoint to get an appointment by its ID
	@GetMapping("/{id}")
	public AppointmentDTO getAppointmentById(@PathVariable Long id) {
		return appointmentService.getAppointmentById(id);
	}

	// Endpoint to delete an appointment
	@DeleteMapping("/{id}")
	public void deleteAppointment(@PathVariable Long id) {
		appointmentService.deleteAppointment(id);
	}
}