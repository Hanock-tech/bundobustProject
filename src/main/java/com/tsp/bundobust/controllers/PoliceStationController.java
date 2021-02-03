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
import com.tsp.bundobust.payload.request.PoliceStationDetailsUiRequest;
import com.tsp.bundobust.payload.response.UIPostingDetailsResponse;
import com.tsp.bundobust.policestationdb.repository.PoliceStationDetailsRepository;
import com.tsp.bundobust.repository.data.PoliceStationData;
import com.tsp.bundobust.response.UIBaseResponse;

@RestController
@RequestMapping("/api/policestation")
public class PoliceStationController {

	@Autowired
	private PoliceStationDetailsRepository policeStationDetailsRepository;

	@PostMapping(path = "/profile", headers = "X-Version=1.0", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> createPoliceStationProfile(
			@Valid @RequestBody PoliceStationDetailsUiRequest uiRequest) {
		// Request Validation

		// TODO: Saving to police station collection in police station database
		PoliceStationData policeStationDetails = populatePoliceStationDetails(uiRequest);

		policeStationDetailsRepository.save(policeStationDetails);

		UIBaseResponse baseResponse = new UIBaseResponse();
		UIPostingDetailsResponse uiPostingDetailsResponse = new UIPostingDetailsResponse();
		uiPostingDetailsResponse.setId(uiRequest.getPoliceStationName());
		baseResponse.setData(uiPostingDetailsResponse);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	private PoliceStationData populatePoliceStationDetails(@Valid PoliceStationDetailsUiRequest uiRequest) {
		PoliceStationData policeStationData = new PoliceStationData();
		policeStationData.setId(uiRequest.getPoliceStationName());
		policeStationData.setPoliceStationName(uiRequest.getPoliceStationName());
		policeStationData.setBlueColts(uiRequest.getBlueColts());
		policeStationData.setHyperSensitivePickets(uiRequest.getHyperSensitivePickets());
		policeStationData.setMobileParties(uiRequest.getMobileParties());
		policeStationData.setImmersionPoints(uiRequest.getImmersionPoints());
		policeStationData.setSectorAreas(uiRequest.getSectorAreas());
		policeStationData.setPatrolCars(uiRequest.getPatrolCars());
		policeStationData.setSectorName(uiRequest.getSectorName());
		// TODO : Add remaining setters

		return policeStationData;
	}

}
