package org.hms.Hospital_Management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String department;
	private String email;
	private String degree;
	private String address;
	private Double salary;

	public Doctor(String name, String department, String email, String degree, String address, Double salary) {
		this.name = name;
		this.department = department;
		this.email = email;
		this.degree = degree;
		this.address = address;
		this.salary = salary;
	}

}
