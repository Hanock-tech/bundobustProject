package com.tsp.bundobust.payload.request;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class HealthDetails {

	private boolean hasUnderAnyMedication;
	private String hasTypeOfMedication;
	private String hasReason;
	private List<String> hasMedications;

	public boolean isHasUnderAnyMedication() {
		return hasUnderAnyMedication;
	}

	public void setHasUnderAnyMedication(boolean hasUnderAnyMedication) {
		this.hasUnderAnyMedication = hasUnderAnyMedication;
	}

	public String getHasTypeOfMedication() {
		return hasTypeOfMedication;
	}

	public void setHasTypeOfMedication(String hasTypeOfMedication) {
		this.hasTypeOfMedication = hasTypeOfMedication;
	}

	public String getHasReason() {
		return hasReason;
	}

	public void setHasReason(String hasReason) {
		this.hasReason = hasReason;
	}

	public List<String> getHasMedications() {
		return hasMedications;
	}

	public void setHasMedications(List<String> hasMedications) {
		this.hasMedications = hasMedications;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
