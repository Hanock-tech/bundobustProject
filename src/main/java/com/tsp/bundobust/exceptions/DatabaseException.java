package com.tsp.bundobust.exceptions;

import org.springframework.http.HttpStatus;

public class DatabaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	
	public DatabaseException() {
		
	}


	public DatabaseException(DBErrorCode uiPostingDetailsError, HttpStatus unprocessableEntity) {
		// TODO Auto-generated constructor stub
	}

}
