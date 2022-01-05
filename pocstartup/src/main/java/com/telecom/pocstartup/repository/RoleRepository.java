package com.telecom.pocstartup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.pocstartup.domain.Role;
import com.telecom.pocstartup.domain.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName roleName);
}