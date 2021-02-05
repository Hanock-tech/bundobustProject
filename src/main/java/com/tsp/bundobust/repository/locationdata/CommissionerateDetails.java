package com.tsp.bundobust.repository.locationdata;

import java.util.List;

public class CommissionerateDetails {

	private String zoneDetails;
	private String DivisionDetails;
	private List<String> policeStations;

	public String getZoneDetails() {
		return zoneDetails;
	}

	public void setZoneDetails(String zoneDetails) {
		this.zoneDetails = zoneDetails;
	}

	public String getDivisionDetails() {
		return DivisionDetails;
	}

	public void setDivisionDetails(String divisionDetails) {
		DivisionDetails = divisionDetails;
	}

	public List<String> getPoliceStations() {
		return policeStations;
	}

	public void setPoliceStations(List<String> policeStations) {
		this.policeStations = policeStations;
	}

}
