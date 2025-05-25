package org.hms.Hospital_Management.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
//	private Long id;
	private Long patientId;
	private Long doctorId;
	private LocalDateTime scheduledTime;

}
