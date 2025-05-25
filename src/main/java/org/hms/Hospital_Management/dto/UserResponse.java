package org.hms.Hospital_Management.dto;

import java.time.LocalDateTime;

import org.hms.Hospital_Management.constants.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
	private Long id;
	private String email;
	private Role role;
	private String name;
	private String dob;
	private Integer age;
	private String gender;
	private String speciality;
	private String avatarUrl;

	private String phoneNumber;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}