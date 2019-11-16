package com.mehul.service;

/**
 * @author Mehul
 *
 */
public interface SecurityService {
    
	String findLoggedInUsername();

    void autoLogin(String username, String password);
}
