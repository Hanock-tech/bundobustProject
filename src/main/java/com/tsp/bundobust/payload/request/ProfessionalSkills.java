package com.tsp.bundobust.payload.request;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ProfessionalSkills {

	private boolean hasFirstAid;
	private boolean hasComputer;
	private boolean hasDriving;
	private boolean hasElectrician;
	private boolean hasPlumber;
	private boolean hasSwimming;

	public boolean isHasFirstAid() {
		return hasFirstAid;
	}

	public void setHasFirstAid(boolean hasFirstAid) {
		this.hasFirstAid = hasFirstAid;
	}

	public boolean isHasComputer() {
		return hasComputer;
	}

	public void setHasComputer(boolean hasComputer) {
		this.hasComputer = hasComputer;
	}

	public boolean isHasDriving() {
		return hasDriving;
	}

	public void setHasDriving(boolean hasDriving) {
		this.hasDriving = hasDriving;
	}

	public boolean isHasElectrician() {
		return hasElectrician;
	}

	public void setHasElectrician(boolean hasElectrician) {
		this.hasElectrician = hasElectrician;
	}

	public boolean isHasPlumber() {
		return hasPlumber;
	}

	public void setHasPlumber(boolean hasPlumber) {
		this.hasPlumber = hasPlumber;
	}

	public boolean isHasSwimming() {
		return hasSwimming;
	}

	public void setHasSwimming(boolean hasSwimming) {
		this.hasSwimming = hasSwimming;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
