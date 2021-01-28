package com.tsp.bundobust.payload.request;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.tomcat.jni.Address;

public class UiPostingDetailsRequest {
	
	@Valid
	private PostingInformation postingDetails;
	
	@Valid
	private PersonalSkills personalSkills;
	
	@Valid
	private BankDetails bankingDetails;
	
	@Valid
	private Address address;
	
	@Valid
	private HealthDetails healthDetails;
	

	public PostingInformation getPostingDetails() {
		return postingDetails;
	}

	public void setPostingDetails(PostingInformation postingDetails) {
		this.postingDetails = postingDetails;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
