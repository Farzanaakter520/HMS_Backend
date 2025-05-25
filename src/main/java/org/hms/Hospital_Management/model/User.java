package org.hms.Hospital_Management.model;

import java.time.LocalDateTime;

import org.hms.Hospital_Management.constants.Role;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String email;

	@JsonIgnore
	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	private String name;
	private String phoneNumber;
	private String dob;
	private Integer age;
	private String gender;
	private String speciality;
	private String avatarUrl;
	

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public User(String email, String password, Role role, String name, String phoneNumber,String dob, Integer age, String gender, String speciality, String avatarUrl) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.age = age;
		this.gender = gender;
		this.speciality = speciality;
		this.avatarUrl = avatarUrl;
	}

	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
		updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = LocalDateTime.now();
	}
}
