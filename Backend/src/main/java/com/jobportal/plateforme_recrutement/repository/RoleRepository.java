package com.jobportal.plateforme_recrutement.repository;

import com.jobportal.plateforme_recrutement.model.Role;
import com.jobportal.plateforme_recrutement.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
