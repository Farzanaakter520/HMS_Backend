package org.hms.Hospital_Management.dto;
<<<<<<< HEAD
=======

>>>>>>> 7f42c42caeb037a2d3ee83fa205602b9ea3f60b3
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PasswordChangeRequest(
        @NotBlank(message = "Current password cannot be blank")
        String currentPassword,

<<<<<<< HEAD
        @NotBlank(message = "New password cannot be blank")
        @Size(min = 6, message = "New password must be at least 6 characters")
        String newPassword
) {
=======
		@NotBlank(message = "New password cannot be blank") @Size(min = 6, message = "New password must be at least 6 characters") String newPassword) {
>>>>>>> 7f42c42caeb037a2d3ee83fa205602b9ea3f60b3
}
