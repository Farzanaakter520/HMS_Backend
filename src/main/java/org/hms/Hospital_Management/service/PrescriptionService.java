package org.hms.Hospital_Management.service;

import org.hms.Hospital_Management.dto.PrescriptionDTO;
import org.hms.Hospital_Management.model.Prescription;
import org.hms.Hospital_Management.model.User;
import org.hms.Hospital_Management.repository.PrescriptionRepository;
import org.hms.Hospital_Management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private UserRepository userRepository;

    // CREATE
    public Prescription savePrescription(PrescriptionDTO dto) {
        User doctor = userRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        User patient = userRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

        Prescription prescription = new Prescription();
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        prescription.setMedicines(dto.getMedicines());
        prescription.setTests(dto.getTests());
        prescription.setPatientName(dto.getPatientName());
       
        prescription.setAdvice(dto.getAdvice());

        return prescriptionRepository.save(prescription);
    }

    // GET ALL
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    // GET BY ID
    public Optional<Prescription> getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id);
    }

    // UPDATE
    public Prescription updatePrescription(Long id, Prescription updatedPrescription) {
        return prescriptionRepository.findById(id).map(existing -> {
            existing.setMedicines(updatedPrescription.getMedicines());
            existing.setPatientName(updatedPrescription.getPatientName());
            existing.setMedicines(updatedPrescription.getMedicines());
            existing.setTests(updatedPrescription.getTests());
            existing.setAdvice(updatedPrescription.getAdvice());
            existing.setDoctor(updatedPrescription.getDoctor());
            existing.setPatient(updatedPrescription.getPatient());
            return prescriptionRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Prescription not found with id " + id));
    }

    // DELETE
    public void deletePrescription(Long id) {
        if (!prescriptionRepository.existsById(id)) {
            throw new RuntimeException("Prescription not found with id " + id);
        }
        prescriptionRepository.deleteById(id);
    }
}
