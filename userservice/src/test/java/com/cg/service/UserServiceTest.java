package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exception.UserNotFoundException;
import com.cg.model.User;
import com.cg.repository.UserRepository;

@SpringBootTest
class UserServiceTest {

	@InjectMocks
	private UserService userService = new UserServiceImpl();

	@Mock
	private UserRepository userRepository;

	@Test
	void testViewUser() {

		User user = new User(1, "king", "raj@mail.com", 89891999,"kumar","kumar");

		Optional<User> optionalBook = Optional.of(user);

		when(userRepository.findByUsername("kumar")).thenReturn(optionalBook.get());

		User myUser = userService.getUserByUsername("kumar");

		assertEquals("kumar", myUser.getUsername());
	}
	


	@Test
	void testGetUserByNameWithException() {

		when(userRepository.findByUsername("kumar")).thenThrow(UserNotFoundException.class);

		assertThrows(UserNotFoundException.class, () -> userService.getUserByUsername("kumar"));
	}

	@Test
	void testSaveUser() {

		
		User user = new User(1, "king", "raj@mail.com", 89891999,"kumar","kumar");

		when(userRepository.save(user)).thenReturn(user);

		User newUser = userService.saveUser(user);

		assertEquals("king", newUser.getName());

		verify(userRepository, times(1)).save(user); // useful for testing void methods

	}
	
	
	@Test
	void testDeleteUser() {
		
		User user = new User(2, "king", "raj@mail.com", 89891999,"kumar","kumar");

		Optional<User> optionalBook = Optional.of(user);

		when(userRepository.findById(2)).thenReturn(optionalBook);

		userService.deleteUser(2);

		verify(userRepository, times(1)).findById(2);
		verify(userRepository, times(1)).deleteById(2);

	}

}