package com.tsp.bundobust.controllers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.bundobust.exceptions.IRErrorCode;
import com.tsp.bundobust.exceptions.InvalidRequestException;
import com.tsp.bundobust.models.ERole;
import com.tsp.bundobust.models.Employee;
import com.tsp.bundobust.payload.repository.UserRepository;
import com.tsp.bundobust.payload.request.LoginRequest;
import com.tsp.bundobust.payload.request.SignupRequest;
import com.tsp.bundobust.payload.response.JwtResponse;
import com.tsp.bundobust.payload.security.jwt.JwtUtils;
import com.tsp.bundobust.payload.security.services.UserDetailsImpl;
import com.tsp.bundobust.response.UIBaseResponse;
import com.tsp.bundobust.util.PropertyUtil;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/employee")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository employeeRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	private PropertyUtil propertyUtil;
	
	private Logger log = LoggerFactory.getLogger(AuthController.class);

	@PostMapping(path="/signin", 
			headers="X-Version=1.0", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> authenticateEmployee(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getId(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		Set<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toSet());


		JwtResponse jwtResponse = new JwtResponse(jwt, 
				userDetails.getId(), 
				userDetails.getEmail(), 
				roles);

		return ResponseEntity.ok(new UIBaseResponse(jwtResponse));
	}

	@PostMapping(path="/signup", 
			headers="X-Version=1.0", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		log.info("registerUser: signUpRequest={}", signUpRequest);
		
		if (employeeRepository.existsByid(signUpRequest.getId())) {
			throw new InvalidRequestException(IRErrorCode.USER_NAME_ALREADY_EXISTS.getErrorCode(), 
					propertyUtil.getValue(IRErrorCode.USER_NAME_ALREADY_EXISTS.getErrorCode()));
		}
		
		signUpRequest.setPassword(encoder.encode(signUpRequest.getPassword()));
		// Create new user's account
		Employee employee = new Employee(signUpRequest);

		Set<String> strRoles = signUpRequest.getRole();
		Set<String> roles = new HashSet<>();
		
		if (strRoles == null) {
			
			throw new InvalidRequestException(IRErrorCode.NO_ROLE_FOUND.getErrorCode(), 
					propertyUtil.getValue(IRErrorCode.NO_ROLE_FOUND.getErrorCode()));
		} else {
			
			for(String s : strRoles) {
				ERole eRole = ERole.valueOf(s);
				if(null == eRole) {
					throw new InvalidRequestException(IRErrorCode.NO_ROLE_FOUND.getErrorCode(), 
							propertyUtil.getValue(IRErrorCode.NO_ROLE_FOUND.getErrorCode()));
				}
				roles.add(eRole.name());
			}
		}
		employee.setRoles(roles);
		employeeRepository.save(employee);
	}
}
