package com.mehul.service;

import com.mehul.model.User;

/**
 * @author Mehul
 *
 */
public interface UserService {
 
	void save(User user);

    User findByUsername(String username);
}
