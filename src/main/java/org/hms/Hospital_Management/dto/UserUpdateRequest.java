package org.hms.Hospital_Management.dto;

import org.hms.Hospital_Management.constants.Role;

import jakarta.validation.constraints.Email;

public record UserUpdateRequest(@Email(message = "Email should be valid") String email,

		Role role, String name, String phoneNumber) {
}
