package com.tsp.bundobust.exceptions;

public enum IRErrorCode {

	
	GENERIC_ERROR("IR001"), 
	USER_NAME_ALREADY_EXISTS("IR002"), 
	EMAIL_ALREADY_EXISTS("IR003"),
	NO_ROLE_FOUND("IR004");
	
	private String errorCode;
	

	IRErrorCode(String code) {
		this.errorCode = code;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
