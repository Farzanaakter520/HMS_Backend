package org.hms.Hospital_Management.service;

import java.util.List;
import java.util.Optional;

import org.hms.Hospital_Management.constants.Role;
import org.hms.Hospital_Management.model.CustomUserDetails;
import org.hms.Hospital_Management.model.User;
import org.hms.Hospital_Management.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public List<User> getUsersByRole(Role role) {
		return userRepository.findByRole(role);
	}

	public Optional<User> findByIdAndRole(Long id, Role role) {
		return userRepository.findByIdAndRole(id, role);
	}

	@Transactional
	public User createUser(User user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("Email is already in use");
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return userRepository.save(user);
	}

	@Transactional
	public User updateUser(Long id, User userDetails) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));

		// Update fields
		user.setName(userDetails.getName());

		user.setPhoneNumber(userDetails.getPhoneNumber());

		// Only update email if it has changed and is not already in use
		if (!user.getEmail().equals(userDetails.getEmail())) {
			if (userRepository.existsByEmail(userDetails.getEmail())) {
				throw new RuntimeException("Email is already in use");
			}
			user.setEmail(userDetails.getEmail());
		}

		// Update password if provided
		if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
			user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
		}

		// Update role if provided
		if (userDetails.getRole() != null) {
			user.setRole(userDetails.getRole());
		}

		return userRepository.save(user);
	}

	@Transactional
	public void deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
			throw new RuntimeException("User not found with id: " + id);
		}

		userRepository.deleteById(id);
	}

	public User getCurrentUser(Authentication authentication) {
		if (authentication == null) {
			return null;
		}

		if (authentication.getPrincipal() instanceof CustomUserDetails) {
			return ((CustomUserDetails) authentication.getPrincipal()).user();
		}

		return null;
	}

	@Transactional
	public void changePassword(Long userId, String currentPassword, String newPassword) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

		if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
			throw new RuntimeException("Current password is incorrect");
		}

		user.setPassword(passwordEncoder.encode(newPassword));

		userRepository.save(user);
	}

	public UserDetails loadUserByUsername(String username) {
		Optional<User> byEmail = userRepository.findByEmail(username);
		return byEmail.map(CustomUserDetails::new).orElse(null);
	}
}
