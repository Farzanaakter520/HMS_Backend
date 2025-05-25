//package org.hms.Hospital_Management.model;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.PrePersist;
//import jakarta.persistence.PreUpdate;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "prescription")
//
//public class Prescription {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long prescriptionId;
//
//	@ManyToOne
//	@JoinColumn(name = "doctor_id", nullable = false)
//	private User doctor;
//
//	@ManyToOne
//	@JoinColumn(name = "patient_id", nullable = false)
//	private User patient;
//
//	@OneToMany
//	@JoinColumn(name = "medicine", nullable = false)
//	private Medicine medicine;
//	
//	private String description;
//	
//	private LocalDate prescription_date;
//
//	public Prescription(User doctor, User patient, String description) {
//		this.doctor = doctor;
//		this.patient = patient;
//		this.description = description;
//		this.prescription_date = LocalDate.now();
//	}
//
//	@PrePersist
//	protected void onCreate() {
//		prescription_date = LocalDate.now();
//	}
//
//	@PreUpdate
//	protected void onUpdate() {
//		prescription_date = LocalDate.now();
//	}
//
////	@ManyToMany(mappedBy = "medicines")
////	private Set<Medicine> prescriptions;
//
//}
