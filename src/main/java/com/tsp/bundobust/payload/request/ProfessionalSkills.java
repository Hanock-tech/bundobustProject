package com.tsp.bundobust.payload.request;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ProfessionalSkills {

	private boolean hasFirstAidSkill;
	private boolean hasComputer;
	private boolean hasDrivingSkill;
	private boolean hasElectricianSkill;
	private boolean hasPlumberSkill;
	private boolean hasSwimmingSkill;

	public boolean isHasFirstAidSkill() {
		return hasFirstAidSkill;
	}

	public void setHasFirstAidSkill(boolean hasFirstAidSkill) {
		this.hasFirstAidSkill = hasFirstAidSkill;
	}

	public boolean isHasComputer() {
		return hasComputer;
	}

	public void setHasComputer(boolean hasComputer) {
		this.hasComputer = hasComputer;
	}

	public boolean isHasDrivingSkill() {
		return hasDrivingSkill;
	}

	public void setHasDrivingSkill(boolean hasDrivingSkill) {
		this.hasDrivingSkill = hasDrivingSkill;
	}

	public boolean isHasElectricianSkill() {
		return hasElectricianSkill;
	}

	public void setHasElectricianSkill(boolean hasElectricianSkill) {
		this.hasElectricianSkill = hasElectricianSkill;
	}

	public boolean isHasPlumberSkill() {
		return hasPlumberSkill;
	}

	public void setHasPlumberSkill(boolean hasPlumberSkill) {
		this.hasPlumberSkill = hasPlumberSkill;
	}

	public boolean isHasSwimmingSkill() {
		return hasSwimmingSkill;
	}

	public void setHasSwimmingSkill(boolean hasSwimmingSkill) {
		this.hasSwimmingSkill = hasSwimmingSkill;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
