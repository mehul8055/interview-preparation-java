package com.mehul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehul.model.User;

/**
 * @author Mehul
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
