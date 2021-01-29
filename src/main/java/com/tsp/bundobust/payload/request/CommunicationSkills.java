package com.tsp.bundobust.payload.request;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CommunicationSkills {

	private boolean hasEnglishFluency;

	public boolean isHasEnglishFluency() {
		return hasEnglishFluency;
	}

	public void setHasEnglishFluency(boolean hasEnglishFluency) {
		this.hasEnglishFluency = hasEnglishFluency;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}
