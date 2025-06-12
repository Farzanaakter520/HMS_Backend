package org.hms.Hospital_Management.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import lombok.*;

@Entity
@Table(name = "prescription")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;

    @ManyToOne
    @JoinColumn(name = "doctorId", nullable = false)
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "patientId", nullable = false)
    private User patient;

    @Column(length = 4000)
    private String medicines;

    @Column(length = 4000)
    private String tests;

    private String patientName;

    private String advice;

    private LocalDate prescriptionDate;

    @PrePersist
    protected void onCreate() {
        prescriptionDate = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        prescriptionDate = LocalDate.now();
    }
}
