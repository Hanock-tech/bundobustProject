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

import com.tsp.bundobust.payload.request.PoliceStationDetails;
import com.tsp.bundobust.policestationdetails.repository.PoliceStationDetailsRepository;
import com.tsp.bundobust.response.UIBaseResponse;

@RestController
@RequestMapping("/api/policestation")
public class PoliceStationController {
	@Autowired
	private PoliceStationDetailsRepository policeStationDetailsRepository;

	@PostMapping(path = "/profile", headers = "X-Version=1.0", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> createPoliceStationProfile(
			@Valid @RequestBody PoliceStationDetails policeStationUiRequestDetails) {
		// Request Validation

		// TODO: Saving to police station collection in police station database
		PoliceStationDetails policeStationDetails = populatePoliceStationDetails(policeStationUiRequestDetails);

		policeStationDetailsRepository.save(policeStationDetails);

		UIBaseResponse baseResponse = new UIBaseResponse();
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	private PoliceStationDetails populatePoliceStationDetails(
			@Valid PoliceStationDetails policeStationUiRequestDetails) {

		PoliceStationDetails policeSationRequest = new PoliceStationDetails();
		policeSationRequest.setSectors(policeStationUiRequestDetails.getSectors());

		return policeSationRequest;
	}

}