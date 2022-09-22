package com.cg.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

//import com.cg.model.AuthResponse;
import com.cg.model.AuthenticationResponse;

import feign.Headers;

@FeignClient(name = "Jwtauthorization", url = "http://localhost:8093")
public interface AuthClient {

	
    @GetMapping(value="/validate")
    public AuthenticationResponse getValidity(@RequestHeader("Authorization") String token);
}