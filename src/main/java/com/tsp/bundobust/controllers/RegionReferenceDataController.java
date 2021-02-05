package com.tsp.bundobust.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.bundobust.exceptions.DBErrorCode;
import com.tsp.bundobust.exceptions.DatabaseException;
import com.tsp.bundobust.locationdata.repository.LocationDataRepository;
import com.tsp.bundobust.locationdata.repository.RegionsDataRepository;
import com.tsp.bundobust.repository.locationdata.LocationDetails;
import com.tsp.bundobust.repository.locationdata.RegionDetails;
import com.tsp.bundobust.response.UIBaseResponse;

@RestController
@RequestMapping("api/regions")
public class RegionReferenceDataController {

	private final Logger log = LoggerFactory.getLogger(RegionReferenceDataController.class);

	@Autowired
	private LocationDataRepository regionsDataRepository;
	@Autowired
	private RegionsDataRepository regionsRepository;

	@PostMapping(value = "/details",
			headers = "X-Version=1.0", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> getRegions(@Valid @RequestParam String districtName) {

		log.info("getdistricts :  for districtName={}" + districtName);
		RegionDetails details = regionsRepository.findByDistrictName(districtName);

		UIBaseResponse response = new UIBaseResponse();
		response.setData(details);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping( value="",headers = "X-Version=1.0",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UIBaseResponse> getAllDistrictsAndCommisionerates() {

		log.info("getAllDistrictsAndCommissionerate : ");
		List<LocationDetails> detailsList = new ArrayList<LocationDetails>();
		List<LocationDetails> districtsAndCommissionerate = regionsDataRepository.findAll();

		if (CollectionUtils.isEmpty(districtsAndCommissionerate)) {
			log.error("getAllDistrictsAndCommisionerates ", districtsAndCommissionerate);
			throw new DatabaseException(DBErrorCode.UI_GET_DETAILS_ERROR, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		for (LocationDetails details : districtsAndCommissionerate) {
			LocationDetails data = new LocationDetails();
			data.setId(details.getId());
			data.setValues(details.getValues());
			detailsList.add(data);
		}
		UIBaseResponse response = new UIBaseResponse();
		response.setData(detailsList);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
