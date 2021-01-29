package com.tsp.bundobust.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.bundobust.payload.request.PoliceStationDetails;
import com.tsp.bundobust.response.UIBaseResponse;

@RestController
@RequestMapping("/api/policestation")
public class PoliceStationController {
	

	@PostMapping(headers="X-Version=1.0",
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> createPoliceStationProfile(
			@Valid @RequestBody PoliceStationDetails policeStationDetails) {
		
		//TODO: Saving to police station collection in police station database
		UIBaseResponse baseResponse = new UIBaseResponse();
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}
	
	

}
