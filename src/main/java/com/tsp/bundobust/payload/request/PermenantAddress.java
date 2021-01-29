package com.tsp.bundobust.payload.request;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PermenantAddress {

	private String addressLine;
	private String streetName;
	private String cityOrVillageOrTown;
	private String district;
	private String state;
	private String pinCode;

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCityOrVillageOrTown() {
		return cityOrVillageOrTown;
	}

	public void setCityOrVillageOrTown(String cityOrVillageOrTown) {
		this.cityOrVillageOrTown = cityOrVillageOrTown;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
