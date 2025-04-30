package org.hms.Hospital_Management.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appointmentId;

	private String name;
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private User patient;

	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	private User doctor;

	private String email;
	private LocalDateTime appointmentDate;

	public Appointment(String name, User patient, User doctor, String email) {
		this.name = name;
		this.patient = patient;
		this.doctor = doctor;
		this.email = email;

	}
}