package com.tsp.bundobust.payload.request;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UiPostingDetailsRequest {

	@Valid
	private PostingInformation postingDetails;

	@Valid
	private PersonalSkills personalSkills;

	@Valid
	private BankDetails bankDetails;

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

	public PersonalSkills getPersonalSkills() {
		return personalSkills;
	}

	public void setPersonalSkills(PersonalSkills personalSkills) {
		this.personalSkills = personalSkills;
	}

	public BankDetails getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public HealthDetails getHealthDetails() {
		return healthDetails;
	}

	public void setHealthDetails(HealthDetails healthDetails) {
		this.healthDetails = healthDetails;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
