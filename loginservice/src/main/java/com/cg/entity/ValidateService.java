package com.cg.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.cg.service.CustomUserDetailsService;
import com.cg.util.JwtUtil;

@Service
public class ValidateService {

	@Autowired
	private JwtUtil jwtutils;

	@Autowired
	private CustomUserDetailsService service;
	


	/**
	 * @param token compare the token returns the authenticationResponse
	 */
	
	
	public AuthenticationResponse validate(String token) {
		AuthenticationResponse authenticationResponse = new AuthenticationResponse();
//		AuthRequest auth = new AuthRequest();
		
//		UserDetails userDetails = service.loadUserByUsername(username);
		
//		 String username = jwtutils.extractUsername(token);
		String jwt = token.substring(7);
//		System.out.print("jwtttt"+jwt);
//		 String jwt = token.split(" ")[1].trim();
		authenticationResponse.setJwtToken(jwt);
		authenticationResponse.setValid(jwtutils.validateJwtToken(jwt));
		return authenticationResponse;
	}
}
