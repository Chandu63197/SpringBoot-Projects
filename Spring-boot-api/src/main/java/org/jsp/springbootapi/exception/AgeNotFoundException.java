package org.jsp.springbootapi.exception;

public class AgeNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid Age";
	}
}
