package org.hms.Hospital_Management.model;

import java.time.LocalDateTime;

import org.hms.Hospital_Management.constants.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "appointment_id", referencedColumnName = "id")
	private Appointment appointment;

	private Double amount;

	private String paymentMethod;

	private PaymentStatus status;

	private LocalDateTime paidAt;


	public Payment(Appointment appointment, Double amount, String paymentMethod, PaymentStatus status,
			LocalDateTime paidAt) {
		this.appointment = appointment;
		
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.paidAt = paidAt;
	}

}
