package org.hms.Hospital_Management.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prescription")

public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prescription_id;

	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	private User doctor;

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private User patient;

	private LocalDateTime prescription_date;
	private String description;

	public Prescription(User doctor, User patient, String description) {
		this.doctor = doctor;
		this.patient = patient;
		this.description = description;
	}

	@PreUpdate
	protected void prescription_date() {
		prescription_date = LocalDateTime.now();
	}
}
