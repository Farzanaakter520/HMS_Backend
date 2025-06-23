package org.hms.Hospital_Management.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDTO {

    @JsonProperty("doctorId")
    private Long doctorId;

    private String doctorName; 

    @JsonProperty("patientId")
    private Long patientId;

    private String patientName;

    private String medicines;
    private String tests;
    private String advice;

    private LocalDate prescriptionDate;
}
