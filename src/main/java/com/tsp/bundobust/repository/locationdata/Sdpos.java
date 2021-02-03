package com.tsp.bundobust.repository.locationdata;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Sdpos {
	private String sdpoName;
	private List<Circles> circles;
	public String getSdpoName() {
		return sdpoName;
	}
	public void setSdpoName(String sdpoName) {
		this.sdpoName = sdpoName;
	}
	public List<Circles> getCircles() {
		return circles;
	}
	public void setCircles(List<Circles> circles) {
		this.circles = circles;
	}
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
