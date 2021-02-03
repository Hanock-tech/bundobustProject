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
import com.tsp.bundobust.eventdb.repository.EventRepository;
import com.tsp.bundobust.eventrepository.data.EventData;
import com.tsp.bundobust.payload.request.EventDetailsUiRequest;
import com.tsp.bundobust.payload.response.UIPostingDetailsResponse;
import com.tsp.bundobust.response.UIBaseResponse;

@RequestMapping("api/event")
@RestController

public class EventController {
	@Autowired
	private EventRepository eventRepository;

	@PostMapping(path = "/postingevent",
			headers = "X-Version=1.0", 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> createEvent(@Valid @RequestBody EventDetailsUiRequest uiRequest) {

		// request validation
		EventData eventData = populateEventDetails(uiRequest);

		eventRepository.save(eventData);
		UIBaseResponse baseResponse = new UIBaseResponse();
		UIPostingDetailsResponse uiPostingDetailsResponse = new UIPostingDetailsResponse();
		uiPostingDetailsResponse.setId(uiRequest.getEventName());

		baseResponse.setData(uiPostingDetailsResponse);
		// TODO: Include event details in the response
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);

	}

	private EventData populateEventDetails(EventDetailsUiRequest uiRequest) {
		// TODO Auto-generated method stub
		EventData eventDetails = new EventData();
		eventDetails.setEventId(uiRequest.getEventName());
		eventDetails.setEventName(uiRequest.getEventName());
		eventDetails.setEventStartDate(uiRequest.getEventStartDate());
		eventDetails.setEventEndDate(uiRequest.getEventEndDate());
		eventDetails.setDivisionName(uiRequest.getDivisionName());
		eventDetails.setDistrictName(uiRequest.getDistrictName());
		eventDetails.setCommissionerateName(uiRequest.getCommissionerateName());
		eventDetails.setPoliceStationName(uiRequest.getPoliceStationName());
		eventDetails.setSdpoName(uiRequest.getSdpoName());
		eventDetails.setCircleName(uiRequest.getCircleName());
		eventDetails.setZoneName(uiRequest.getZoneName());

		return eventDetails;
	}

}
