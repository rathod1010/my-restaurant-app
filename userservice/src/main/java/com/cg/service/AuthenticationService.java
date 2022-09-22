package com.cg.service;

import com.cg.model.User;

public interface AuthenticationService {
	
	User userLogin(String username,String password);

}
