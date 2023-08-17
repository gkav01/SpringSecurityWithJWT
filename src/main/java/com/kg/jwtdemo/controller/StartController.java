package com.kg.jwtdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kg.jwtdemo.entity.AuthenticationRequest;
import com.kg.jwtdemo.util.JWTUtil;

@RestController
public class StartController {
	
	@Autowired
	private JWTUtil  jwtUtil;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String start() {
		return "Hello world!";
	}
	
	@PostMapping(path = "/authenticate", consumes = "application/json")
	public String getToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUname(), authRequest.getPwd()));
		} catch(Exception e) {
			throw new Exception("Authentication failed");
		}
		return jwtUtil.generateJwtToken(authRequest.getUname());
	}
}