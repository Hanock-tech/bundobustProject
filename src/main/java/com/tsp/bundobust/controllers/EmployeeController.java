package com.tsp.bundobust.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.bundobust.models.Employee;
import com.tsp.bundobust.payload.repository.UserRepository;
import com.tsp.bundobust.response.UIBaseResponse;

@RestController("/api/employee")
public class EmployeeController {
	
	private final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	private UserRepository userRepository;
	
	@PutMapping(path="/details", headers="X-Version=1.0", 
			produces=MediaType.APPLICATION_JSON_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<UIBaseResponse> getEmployeeDetails(@Valid @RequestParam String employeeId) {
		log.info("getEmployeeDetails: for Id={}", employeeId);
		Employee employee = userRepository.findById(employeeId).orElse(null);
		UIBaseResponse baseResponse = new UIBaseResponse();
		baseResponse.setData(employee);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}
}
