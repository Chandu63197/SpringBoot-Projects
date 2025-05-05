package org.jsp.springbootapi.exception;

public class EmailNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid Email";
	}
}
