package org.hms.Hospital_Management.dto;

<<<<<<< HEAD
public class PasswordChangeRequest {
 
=======
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PasswordChangeRequest(@NotBlank(message = "Current password cannot be blank") String currentPassword,

		@NotBlank(message = "New password cannot be blank") @Size(min = 6, message = "New password must be at least 6 characters") String newPassword) {
>>>>>>> 993b635443fceb6c5ad7c83be8ff6b3de42a54a1
}
