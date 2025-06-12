package org.hms.Hospital_Management.dto;
import java.time.LocalDateTime;

import org.hms.Hospital_Management.constants.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

	private Long appointmentID;
	private Double amount;
	private String paymentMethod;
	private LocalDateTime paidAt;

}
