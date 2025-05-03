package org.hms.Hospital_Management.repository;

import java.util.List;
import java.util.Optional;

import org.hms.Hospital_Management.constants.Role;
import org.hms.Hospital_Management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);

	List<User> findByRole(Role role);

	Optional<User> findByIdAndRole(Long id, Role role);
}