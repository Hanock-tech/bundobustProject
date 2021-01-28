package com.tsp.bundobust.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.bundobust.payload.request.UiPostingDetailsRequest;
import com.tsp.bundobust.payload.response.UIPostingDetailsResponse;
import com.tsp.bundobust.response.UIBaseResponse;

@RestController
@RequestMapping("/api/employee")
public class PostingDetailsController {

	@PostMapping(path="/posting/details",
			headers="X-Version=1.0",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> updatePostingDetails(
			@Valid  @RequestBody  UiPostingDetailsRequest uiPostingDetailsRequest) {

		UIBaseResponse response = new UIBaseResponse();
		
		// TODO: Create Employee Object and persist in employee database

		UIPostingDetailsResponse uiPostingDetailsResponse = new UIPostingDetailsResponse();
		uiPostingDetailsResponse.setId(uiPostingDetailsRequest.getPostingDetails().getId());
		response.setData(uiPostingDetailsResponse);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
