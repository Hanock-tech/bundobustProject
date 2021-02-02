package com.tsp.bundobust.payload.request;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Sectors {

	@NotBlank
	public String sectorName;
	@NotBlank
	public String inchargeName;
	public List<String> areas;
	public List<String> sensitivePickets;
	public List<String> hyperSensitivePickets;
	public List<String> immersionPoints;
	public List<String> mobileParties;
	public List<String> patrolCars;
	public List<String> blueColts;

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getInchargeName() {
		return inchargeName;
	}

	public void setInchargeName(String inchargeName) {
		this.inchargeName = inchargeName;
	}

	public List<String> getAreas() {
		return areas;
	}

	public void setAreas(List<String> areas) {
		this.areas = areas;
	}

	public List<String> getSensitivePickets() {
		return sensitivePickets;
	}

	public void setSensitivePickets(List<String> sensitivePickets) {
		this.sensitivePickets = sensitivePickets;
	}

	public List<String> getHyperSensitivePickets() {
		return hyperSensitivePickets;
	}

	public void setHyperSensitivePickets(List<String> hyperSensitivePickets) {
		this.hyperSensitivePickets = hyperSensitivePickets;
	}

	public List<String> getImmersionPoints() {
		return immersionPoints;
	}

	public void setImmersionPoints(List<String> immersionPoints) {
		this.immersionPoints = immersionPoints;
	}

	public List<String> getMobileParties() {
		return mobileParties;
	}

	public void setMobileParties(List<String> mobileParties) {
		this.mobileParties = mobileParties;
	}

	public List<String> getPatrolCars() {
		return patrolCars;
	}

	public void setPatrolCars(List<String> patrolCars) {
		this.patrolCars = patrolCars;
	}

	public List<String> getBlueColts() {
		return blueColts;
	}

	public void setBlueColts(List<String> blueColts) {
		this.blueColts = blueColts;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}
