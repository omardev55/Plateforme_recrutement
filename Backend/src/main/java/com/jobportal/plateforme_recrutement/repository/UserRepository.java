package com.jobportal.plateforme_recrutement.repository;

import com.jobportal.plateforme_recrutement.model.Role;
import com.jobportal.plateforme_recrutement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);  // ✅ Corrigé pour retourner un Optional

    List<User> findByRoles(Set<Role> roles);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
