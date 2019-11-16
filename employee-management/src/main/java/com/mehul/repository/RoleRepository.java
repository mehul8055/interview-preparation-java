package com.mehul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehul.model.Role;

/**
 * @author Mehul
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
}
