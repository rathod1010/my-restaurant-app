package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.UserAlreadyExistsException;
import com.cg.exception.UserNotFoundException;
import com.cg.model.User;
import com.cg.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {

		Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUsername(user.getUsername()));

		if (optionalUser.isPresent()) {
			throw new UserAlreadyExistsException("Username already exists with " +"->"+ user.getUsername());
		}

		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		Optional<User> optionalUser = userRepository.findById(user.getUserId());
		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("No User is found to update with id " + user.getUserId());
		}

		return userRepository.save(user);

	}

	@Override
	public void deleteUser(int userId) {

		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("No User is found to delete with id " + userId);
		}

		userRepository.deleteById(userId);

	}

	@Override
	public User getUserByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

}
