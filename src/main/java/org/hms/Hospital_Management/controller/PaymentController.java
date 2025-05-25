package org.hms.Hospital_Management.controller;

import java.util.List;

import org.hms.Hospital_Management.dto.PaymentDto;
import org.hms.Hospital_Management.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping
	public PaymentDto createPayment(@RequestBody PaymentDto dto) {
		return paymentService.createPayment(dto);
	}

	@GetMapping
	public List<PaymentDto> getAllPayments() {
		return paymentService.getAllPayments();
	}

	@GetMapping("/{id}")
	public PaymentDto getPaymentById(@PathVariable Long id) {
		return paymentService.getPaymentById(id);
	}

	@GetMapping("/appointment/{appointmentId}")
	public PaymentDto getPaymentByAppointment(@PathVariable Long appointmentId) {
		return paymentService.getPaymentByAppointmentId(appointmentId);
	}

	@DeleteMapping("/{id}")
	public void deletePayment(@PathVariable Long id) {
		paymentService.deletePayment(id);
	}
}