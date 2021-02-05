package com.tsp.bundobust.controllers;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.bundobust.dao.EventDao;
import com.tsp.bundobust.eventdb.repository.EventRepository;
import com.tsp.bundobust.eventrepository.data.EventData;
import com.tsp.bundobust.exceptions.DBErrorCode;
import com.tsp.bundobust.exceptions.DatabaseException;
import com.tsp.bundobust.payload.request.AllocateEmployeeUiRequest;
import com.tsp.bundobust.payload.request.EventDetailsUiRequest;
import com.tsp.bundobust.payload.response.UIPostingDetailsResponse;
import com.tsp.bundobust.response.UIBaseResponse;

@RestController
@RequestMapping("api/event")
public class EventController {

	private final Logger log = LoggerFactory.getLogger(EventController.class);

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private EventDao eventDao;

	@PostMapping(headers = "X-Version=1.0", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> createEvent(@Valid @RequestBody EventDetailsUiRequest uiRequest) {

		log.info("createEvent: Request received={}", uiRequest);
		// TODO: request validation
		EventData eventData = populateEventDetails(uiRequest);
		eventRepository.save(eventData);
		UIBaseResponse baseResponse = new UIBaseResponse();
		UIPostingDetailsResponse uiPostingDetailsResponse = new UIPostingDetailsResponse();
		uiPostingDetailsResponse.setId(uiRequest.getEventName());
		baseResponse.setData(uiPostingDetailsResponse);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	@GetMapping(headers = "X-Version=1.0", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> getAllActiveEvents() throws ParseException {
		log.info("getAllActiveEvents : ");
		List<EventData> activeEvents = new ArrayList<EventData>();
		List<EventData> eventsData = eventRepository.findAll();
		if (CollectionUtils.isEmpty(eventsData)) {
			log.error("getAllActiveEvents: empty Event list from database for ActiveEvents={}", eventsData);
			throw new DatabaseException(DBErrorCode.UI_GET_DETAILS_ERROR, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		for (EventData data : eventsData) {
			if ((LocalDate.parse(data.getEventEndDate()).isAfter(LocalDate.now()))) {
				EventData result = new EventData();
				result.setEventEndDate(data.getEventEndDate());
				result.setCircleName(data.getCircleName());
				result.setCommissionerateName(data.getCommissionerateName());
				result.setDivisionName(data.getDivisionName());
				result.setPoliceStationName(data.getPoliceStationName());
				result.setSdpoName(data.getSdpoName());
				result.setZoneName(data.getZoneName());
				result.setEventId(data.getEventId());
				result.setEventName(data.getEventName());
				result.setEventStartDate(data.getEventStartDate());
				activeEvents.add(result);

			}
		}

		UIBaseResponse baseResponse = new UIBaseResponse();
		baseResponse.setData(activeEvents);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	@PutMapping(path = "/employee/assign",
			headers = "X-Version=1.0", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> deployStaffToEvent(@Valid @RequestBody AllocateEmployeeUiRequest uiRequest) {
		log.info("deployStaffToEvent: Request received={}", uiRequest);
		// TODO: Add validations
		UIBaseResponse baseResponse = new UIBaseResponse();
		UIPostingDetailsResponse uiPostingDetailsResponse = new UIPostingDetailsResponse();
		boolean result = eventDao.updateStaff(uiRequest.getEventId(), uiRequest.getEmployees());

		if (result == true) {
			uiPostingDetailsResponse.setId(uiRequest.getEventId());
			baseResponse.setData(uiPostingDetailsResponse);
		}
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);

	}

	private EventData populateEventDetails(EventDetailsUiRequest uiRequest) {

		EventData eventDetails = new EventData();
		eventDetails.setEventId(String.valueOf(new Random().nextInt()));
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
