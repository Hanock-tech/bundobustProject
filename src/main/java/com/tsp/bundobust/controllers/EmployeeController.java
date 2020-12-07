package com.tsp.bundobust.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.bundobust.payload.request.UiEmployeeUpdateRequest;

@RestController("/api/employee/details")
public class EmployeeController {
	
	private final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@PutMapping(headers="X-Version=1.0", 
			produces=MediaType.APPLICATION_JSON_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateEmployeeDetails(@RequestBody UiEmployeeUpdateRequest updateRequest) {
		
		log.info("updateEmployeeDetails: ");
	}

}
