package com.tsp.bundobust.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.bundobust.exceptions.DBErrorCode;
import com.tsp.bundobust.exceptions.DatabaseException;
import com.tsp.bundobust.response.UIBaseResponse;
import com.tsp.bundobust.uireferencedb.repository.PostingDetailsRepository;
import com.tsp.bundobust.uireferencedb.repository.data.UiPostingReferenceData;

@RestController
@RequestMapping("/api/employee")
public class UILabelsPostingReferenceData {
	
	private Logger log = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private PostingDetailsRepository postingDetailsRepository;

	@GetMapping(path="/ui/labels/postingdetails",
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="X-Version=1.0"
			)
	public ResponseEntity<UIBaseResponse> getUIReferenceData() {

		UiPostingReferenceData uiPostingReferenceData = postingDetailsRepository.findById("employeeCreationReferenceData").orElse(null);
		if(null == uiPostingReferenceData) {
			log.error("getUIReferenceData: Empty response from database");
			throw new DatabaseException(DBErrorCode.UI_POSTING_DETAILS_ERROR, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		UIBaseResponse baseResponse = new UIBaseResponse();
		baseResponse.setData(uiPostingReferenceData);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}
}
