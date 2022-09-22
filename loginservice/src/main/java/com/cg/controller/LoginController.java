package com.cg.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.entity.AuthRequest;
import com.cg.entity.AuthenticationResponse;
import com.cg.entity.LoginResponse;
import com.cg.entity.User;
import com.cg.entity.ValidateService;
import com.cg.util.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class LoginController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	ValidateService validateService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/generate")
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
			
			String jwt = jwtUtil.generateToken(authRequest.getUsername());

			User user = restTemplate.getForObject("http://localhost:8092/user/find/" + authRequest.getUsername(),
					User.class);

			return ResponseEntity
					.ok(new LoginResponse(user.getUserId(), user.getName(), user.getEmail(), jwt));

		}

		catch (Exception e) {
			throw new Exception("Invalid Username or password");
		}

	
	}
	
	@GetMapping("/validate")
    public AuthenticationResponse getValidity(@RequestHeader(name="Authorization")  String token) {
//       byte[] byt = Base64.getUrlDecoder().decode(token);
       
       return validateService.validate(token);
    }

}
