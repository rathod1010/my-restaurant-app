package com.cg.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	void givenUserShouldReturnUserObject() {
		User user1 = new User(2, "king", "raj@mail.com", 89891999,"kumar","kumar");
		userRepository.save(user1);
		User user2 = userRepository.findByUsername(user1.getUsername());
		assertNotNull(user2);
		assertEquals(user1.getName(), user2.getName());
	}
	
	@Test
	void getAllMustReturnAllBooks()
	{
		User a1 = new User(8, "king", "raj@mail.com", 89891999,"ram","kumar");
		User a2 = new User(7, "aman", "aman@mail.com", 78789,"abc","kumar");
		userRepository.save(a1);
		userRepository.save(a2);
		List<User> userList = (List<User>) userRepository.findAll();
		assertEquals("king", userList.get(4).getName());
		
	}
	

	@Test
	void testSaveUser()
	{
		
		User u2 = new User(9, "aman", "aman@mail.com", 78789,"king","kumar");
		userRepository.save(u2);
		User newUser =userRepository.findById(u2.getUserId()).get();
		assertNotNull(newUser);
		assertEquals(u2.getUserId(), newUser.getUserId());
		
	}

	
	@Test
	void testDeleteBook() {
		User user4 = new User(3, "ram", "raj@mail.com", 89891999,"kkk","kumar");
		userRepository.save(user4);
		userRepository.delete(user4);
		assertEquals(userRepository.findById(3),Optional.empty());

	}
	   
}
