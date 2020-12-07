package com.tsp.bundobust.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.MDC;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ErrorResponse {
	
	private String timestamp = new Date().toString();
	
	private String code;
	
	private String message;
	
	private List<String> errors = new ArrayList<String>();
	
	private String path;
	
	private String requestId = MDC.get("requestId");
	
	private boolean retry;
	
	
	public ErrorResponse(InvalidRequestException ex, String uri) {
		
		this.code = ex.getErrorCode();
		this.message = ex.getErrorMessage();
		this.retry = ex.isRetry();
		this.path = uri;
	}

	public ErrorResponse(MethodArgumentNotValidException ex, String uri) {
		
		this.code = "IR001";
		this.message = ex.getMessage();
		this.retry = false;
		this.errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> (x.getField() +" "+x.getDefaultMessage()))
                .collect(Collectors.toList());
		this.path = uri;
	}

	public ErrorResponse(Exception ex, String uri) {
		this.code = "GE001";
		this.message = ex.getMessage();
		this.retry = false;
		this.path = uri;
		
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public boolean isRetry() {
		return retry;
	}

	public void setRetry(boolean retry) {
		this.retry = retry;
	}
	
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}
