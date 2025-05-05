package org.jsp.springbootapi.exception;

public class NameNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid name";
	}
}
