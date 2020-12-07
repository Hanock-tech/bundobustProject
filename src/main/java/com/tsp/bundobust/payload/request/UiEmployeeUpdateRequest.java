package com.tsp.bundobust.payload.request;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UiEmployeeUpdateRequest {
	
	private String skills;
	
	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
		
	}

}
