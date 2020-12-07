package com.tsp.bundobust.exceptions;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

public class InvalidRequestException extends RuntimeException {
	
	private String errorCode;
	
	private String errorMessage;
	
	private boolean retry = false;
	
	private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

	private static final long serialVersionUID = 1L;
	
	public InvalidRequestException(String errorCode, String errorMessage,
			HttpStatus httpStatus, boolean retry, Exception ex) {
		
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.retry = retry;
		this.httpStatus = httpStatus;
	}

	public InvalidRequestException(String errorCode, String errorMessage) {
		
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public InvalidRequestException(String errorCode, String errorMessage, boolean retry) {
		
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.retry = retry;
	}
	
	public InvalidRequestException(String errorCode, String errorMessage, boolean retry, HttpStatus httpStatus) {
		
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.retry = retry;
		this.httpStatus = httpStatus;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isRetry() {
		return retry;
	}

	public void setRetry(boolean retry) {
		this.retry = retry;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
	
	

}
