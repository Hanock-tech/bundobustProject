package com.tsp.bundobust.payload.request;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class LawAndOrderSkills {

	private boolean hasCrimePreventionOrDetectionSkill;

	private boolean hasSbAndIntelligenceSkill;

	private boolean hasTrafficSkill;

	public boolean isHasCrimePreventionOrDetectionSkill() {
		return hasCrimePreventionOrDetectionSkill;
	}

	public void setHasCrimePreventionOrDetectionSkill(boolean hasCrimePreventionOrDetectionSkill) {
		this.hasCrimePreventionOrDetectionSkill = hasCrimePreventionOrDetectionSkill;
	}

	public boolean isHasSbAndIntelligenceSkill() {
		return hasSbAndIntelligenceSkill;
	}

	public void setHasSbAndIntelligenceSkill(boolean hasSbAndIntelligenceSkill) {
		this.hasSbAndIntelligenceSkill = hasSbAndIntelligenceSkill;
	}

	public boolean isHasTrafficSkill() {
		return hasTrafficSkill;
	}

	public void setHasTrafficSkill(boolean hasTrafficSkill) {
		this.hasTrafficSkill = hasTrafficSkill;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
