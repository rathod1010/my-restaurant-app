package com.cg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.AuthenticationFailedException;
import com.cg.exception.UserNameNotExistingException;
import com.cg.model.User;
import com.cg.repository.UserRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User userLogin(String username, String password) {

		

		Optional<User> optionalUser2 = userRepository.findByUsernameAndPassword(username, password);

		if (optionalUser2.isEmpty()) {
			throw new AuthenticationFailedException("Username & Password not matching");
		}

		User user = optionalUser2.get();

		return user;
	}

}
