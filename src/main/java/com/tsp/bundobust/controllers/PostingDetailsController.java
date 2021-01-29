package com.tsp.bundobust.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.bundobust.models.Employee;
import com.tsp.bundobust.payload.repository.UserRepository;
import com.tsp.bundobust.payload.request.PostingInformation;
import com.tsp.bundobust.payload.request.UiPostingDetailsRequest;
import com.tsp.bundobust.payload.response.UIPostingDetailsResponse;
import com.tsp.bundobust.response.UIBaseResponse;

@RestController
@RequestMapping("/api/employee")
public class PostingDetailsController {
	@Autowired
	UserRepository employeeRepository;

	@PostMapping(path = "/posting/details", headers = "X-Version=1.0", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> updatePostingDetails(
			@Valid @RequestBody UiPostingDetailsRequest uiPostingDetailsRequest) {

		// TODO: Request validation
		Employee employee = populateEmployee(uiPostingDetailsRequest);
		employeeRepository.save(employee);

		UIBaseResponse response = new UIBaseResponse();
		UIPostingDetailsResponse uiPostingDetailsResponse = new UIPostingDetailsResponse();
		uiPostingDetailsResponse.setId(uiPostingDetailsRequest.getPostingDetails().getId());
		response.setData(uiPostingDetailsResponse);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private Employee populateEmployee(@Valid UiPostingDetailsRequest request) {
		
		Employee employee = new Employee();
		
		PostingInformation postingDetails = request.getPostingDetails();
		employee.setFirstName(postingDetails.getFirstName());
		employee.setLastName(postingDetails.getLastName());
		employee.setId(postingDetails.getId());
		employee.setRank(postingDetails.getRank());
		employee.setDistrictName(postingDetails.getDistrict());
		employee.setSdpoName(postingDetails.getSdpo());
		employee.setCircleName(postingDetails.getCircle());
		employee.setPoliceStationName(postingDetails.getPoliceStation());
		employee.setOfficeType(postingDetails.getOfficeType());
		employee.setCommissionerateName(postingDetails.getCommissionerate());
		employee.setDivisonName(postingDetails.getDivision());
		employee.setPersonalSkills(request.getPersonalSkills());
		employee.setBankDetails(request.getBankDetails());
		employee.setPermanentAddress(request.getPermanentAddress());
		employee.setTemporaryAddress(request.getTemporaryAddress());
		employee.setHealthDetails(request.getHealthDetails());
		
		return employee;
	}
}
