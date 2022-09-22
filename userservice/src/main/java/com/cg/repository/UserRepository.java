package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	User findByUsername(String username);
	

	
	Optional<User> findByUsernameAndPassword(String username, String password);

}
