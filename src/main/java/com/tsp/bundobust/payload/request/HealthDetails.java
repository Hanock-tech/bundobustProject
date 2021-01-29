package com.tsp.bundobust.payload.request;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class HealthDetails {

	private boolean isUnderAnyMedication;
	private List<String> typeOfMedications;
	private String reason; // if the medication selected is others
	
	public boolean isUnderAnyMedication() {
		return isUnderAnyMedication;
	}

	public void setUnderAnyMedication(boolean isUnderAnyMedication) {
		this.isUnderAnyMedication = isUnderAnyMedication;
	}

	public List<String> getTypeOfMedications() {
		return typeOfMedications;
	}

	public void setTypeOfMedications(List<String> typeOfMedications) {
		this.typeOfMedications = typeOfMedications;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
