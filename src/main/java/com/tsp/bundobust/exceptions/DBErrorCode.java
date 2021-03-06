package com.tsp.bundobust.exceptions;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public enum DBErrorCode {
	
	GENERIC_EXCEPTION("DB001"),
	UI_POSTING_DETAILS_ERROR("DB002"),
	UI_GET_DETAILS_ERROR("DB003");

	private String errorCode;

	DBErrorCode(String code) {
		
		this.errorCode = code;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
