package com.tsp.bundobust.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.bundobust.response.UIBaseResponse;

@RequestMapping("api/event")
@RestController
public class EventController {
	
	@PostMapping()
	public ResponseEntity<UIBaseResponse> createEvent(
			@Valid @RequestBody EventDetailsUiRequest uiRequest) {
		
		// TODO: Include event details in the response
		return null;
	}

}
