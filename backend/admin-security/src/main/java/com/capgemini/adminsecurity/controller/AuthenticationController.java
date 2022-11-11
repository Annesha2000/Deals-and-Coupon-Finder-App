package com.capgemini.adminsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.adminsecurity.model.Admin;
import com.capgemini.adminsecurity.payload.request.LoginRequest;
import com.capgemini.adminsecurity.payload.request.SignupRequest;
import com.capgemini.adminsecurity.payload.response.JwtResponse;
import com.capgemini.adminsecurity.payload.response.MessageResponse;
import com.capgemini.adminsecurity.repository.AdminRepository;
import com.capgemini.adminsecurity.security.jwt.JwtUtils;
import com.capgemini.adminsecurity.service.UserDetailsImpl;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController 
{
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), // userDetails.getUsername()  which one is correct?
																										
				userDetails.getEmail()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
		if (adminRepository.existsByUsername(signUpRequest.getUserName())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}
		if (adminRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}
		// Create new user's account
		Admin admin = new Admin(signUpRequest.getUserName(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		adminRepository.save(admin);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

	}

}
