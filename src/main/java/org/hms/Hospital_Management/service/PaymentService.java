package org.hms.Hospital_Management.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.hms.Hospital_Management.constants.PaymentStatus;
import org.hms.Hospital_Management.dto.PaymentDto;
import org.hms.Hospital_Management.model.Appointment;
import org.hms.Hospital_Management.model.Payment;
import org.hms.Hospital_Management.repository.AppointmentRepository;
import org.hms.Hospital_Management.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	public PaymentDto createPayment(PaymentDto dto) {
		Appointment appointment = appointmentRepository.findById(dto.getAppointmentID())
				.orElseThrow(() -> new RuntimeException("Appointment not found"));

		Payment payment = new Payment(appointment, dto.getAmount(), dto.getPaymentMethod(),
				dto.getStatus() != null ? dto.getStatus() : PaymentStatus.UNPAID, LocalDateTime.now());

		return convertToDto(paymentRepository.save(payment));
	}

	public List<PaymentDto> getAllPayments() {
		return paymentRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public PaymentDto getPaymentById(Long id) {
		return paymentRepository.findById(id).map(this::convertToDto)
				.orElseThrow(() -> new RuntimeException("Payment not found"));
	}

	public PaymentDto getPaymentByAppointmentId(Long appointmentId) {
		Payment payment = paymentRepository.findByAppointment_id(appointmentId);
		if (payment == null) {
			throw new RuntimeException("Payment not found for appointment ID: " + appointmentId);
		}
		return convertToDto(payment);
	}

	public void deletePayment(Long id) {
		if (!paymentRepository.existsById(id)) {
			throw new RuntimeException("Payment not found");
		}
		paymentRepository.deleteById(id);
	}

	private PaymentDto convertToDto(Payment payment) {
		return new PaymentDto(payment.getAppointment().getId(), payment.getAmount(), payment.getPaymentMethod(),
				payment.getStatus(), payment.getPaidAt());
	}
}
