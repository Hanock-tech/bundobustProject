package com.tsp.bundobust.repository.locationdata;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Circles {

	private String name;
	private List<String> policeStation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(List<String> policeStation) {
		this.policeStation = policeStation;
	}
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}
