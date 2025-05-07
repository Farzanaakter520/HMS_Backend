package org.hms.Hospital_Management.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private Integer age;
	private String gender;
	private String bloodGroup;
	private String address;
	private String phone;
	private String email;
	private LocalDate date;

	public Patient(String name, Integer age, String gender, String bloodGroup, String address, String phone,
			String email, LocalDate date) {

		this.name = name;
		this.age = age;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.date = date;

	}
}