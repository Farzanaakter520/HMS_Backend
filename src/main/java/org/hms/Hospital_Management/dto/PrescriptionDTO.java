package org.hms.Hospital_Management.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDTO {
	private Long doctorId;
	private Long patientId;
	private String description;
	private LocalDate prescription_date;

}
