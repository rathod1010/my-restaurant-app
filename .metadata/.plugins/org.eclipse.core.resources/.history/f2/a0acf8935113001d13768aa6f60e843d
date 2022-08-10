package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.AuthRequest;
import com.cg.util.JwtUtil;

@RestController
public class LoginController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;


	@PostMapping("/generate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

		try
		{
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} 
		catch (Exception e)
		{
			throw new Exception("Invalid Username or Password");
		}

		return jwtUtil.generateToken(authRequest.getUsername());

	}

}
