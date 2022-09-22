package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.LoginRequest;
import com.cg.model.LoginResponse;
import com.cg.model.User;
import com.cg.service.AuthenticationService;
import com.cg.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationService authenticationService;
	
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User newUser = userService.saveUser(user);

		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<User> modifyUser(@RequestBody User user) {
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> removeUser(@PathVariable("userId") int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("User deleted Successfully", HttpStatus.OK);
	}
	@GetMapping("/find/{userName}")
	public ResponseEntity<User> removeUser(@PathVariable("userName") String username) {
		User user =userService.getUserByUsername(username);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> singin(@RequestBody LoginRequest loginReq) {

		User user =  authenticationService.userLogin(loginReq.getUsername(),loginReq.getPassword());

		LoginResponse loginResp = new LoginResponse();
		loginResp.setUserId(user.getUserId());
		loginResp.setName(user.getName());
		loginResp.setEmail(user.getEmail());
		return new ResponseEntity<>(loginResp, HttpStatus.OK);

	}

}
