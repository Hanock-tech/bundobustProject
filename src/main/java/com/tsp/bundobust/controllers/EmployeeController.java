package com.tsp.bundobust.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.bundobust.exceptions.DBErrorCode;
import com.tsp.bundobust.exceptions.DatabaseException;
import com.tsp.bundobust.exceptions.IRErrorCode;
import com.tsp.bundobust.exceptions.InvalidRequestException;
import com.tsp.bundobust.models.Employee;
import com.tsp.bundobust.payload.repository.UserRepository;
import com.tsp.bundobust.response.UIBaseResponse;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/details", headers = "X-Version=1.0", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> getEmployeeDetails(@Valid @RequestParam String employeeId) {
		log.info("getEmployeeDetails: for Id={}", employeeId);
		Employee employee = userRepository.findById(employeeId).orElse(null);
		UIBaseResponse baseResponse = new UIBaseResponse();
		baseResponse.setData(employee);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	@GetMapping(path = "/listemployeedetails", 
			headers = "X-Version=1.0", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> getAllEmployeeDetails(@Valid @RequestParam String policeStationName) {

		List<Employee> employees = userRepository.findByPoliceStationName(policeStationName);

		if (CollectionUtils.isEmpty(employees)) {
			throw new DatabaseException(DBErrorCode.UI_GET_DETAILS_ERROR, HttpStatus.UNPROCESSABLE_ENTITY);
			// TODO: Write exception code and message throw new
			// DatabaseException(uiPostingDetailsError, unprocessableEntity)
		}

		UIBaseResponse baseResponse = new UIBaseResponse();
		baseResponse.setData(employees);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}
}
