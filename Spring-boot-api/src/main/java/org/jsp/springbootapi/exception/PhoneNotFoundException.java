package org.jsp.springbootapi.exception;

public class PhoneNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid Phone";
	}
}
