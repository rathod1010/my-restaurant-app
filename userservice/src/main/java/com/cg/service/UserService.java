package com.cg.service;

import java.util.List;

import com.cg.model.User;

public interface UserService {
	
	User saveUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(int userId);
	
	User getUserByUsername(String username);
	

}
