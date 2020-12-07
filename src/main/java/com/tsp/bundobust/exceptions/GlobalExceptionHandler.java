package com.tsp.bundobust.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<ErrorResponse> invalidRequestException(InvalidRequestException ex, 
			WebRequest request) {
		
		log.error("invalidRequestException="+ex);
		ErrorResponse response = new ErrorResponse(ex, request.getContextPath());
		return new ResponseEntity<ErrorResponse>(response, ex.getHttpStatus());
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<ErrorResponse> databaseException(InvalidRequestException ex, 
			WebRequest request) {

		log.error("databaseException="+ex);
		ErrorResponse response = new ErrorResponse(ex, request.getContextPath());
		return new ResponseEntity<ErrorResponse>(response, ex.getHttpStatus());
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		log.error("databaseException="+ex);
		ErrorResponse response = new ErrorResponse(ex, ((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
	
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error("handleExceptionInternal="+ex);
		headers.setContentType(MediaType.APPLICATION_JSON);
		ErrorResponse response = new ErrorResponse(ex, ((ServletWebRequest)request).getRequest().getRequestURI().toString());
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}
		return new ResponseEntity<Object>(response, headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
