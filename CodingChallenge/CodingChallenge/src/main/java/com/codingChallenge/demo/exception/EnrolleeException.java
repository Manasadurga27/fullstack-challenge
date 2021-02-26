package com.codingChallenge.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class EnrolleeException extends RuntimeException{
	
	private static final long serialVersionUID = -1809069826752557868L;
	public EnrolleeException(String message, Throwable t) {
		super(message, t);
	}

	public EnrolleeException(String message) {
		super(message);
	}
}
