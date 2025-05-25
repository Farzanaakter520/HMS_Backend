//package org.hms.Hospital_Management.controller;
//
//import org.hms.Hospital_Management.model.Prescription;
//import org.hms.Hospital_Management.repository.PrescriptionRepository;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/prescriptions")
//@CrossOrigin(origins = "http://localhost:4200") // You can also configure CORS globally
//public class PrescriptionController {
//
//    private final PrescriptionRepository prescriptionRepository;
//
//    public PrescriptionController(PrescriptionRepository prescriptionRepository) {
//        this.prescriptionRepository = prescriptionRepository;
//    }
//
//    @PostMapping
//    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription) {
//        Prescription saved = prescriptionRepository.save(prescription);
//        return ResponseEntity.ok(saved);
//    }
//}
