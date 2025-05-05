package org.jsp.springbootapi.exception;

public class InvalidCredentialsException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid Phone or Email or Id or Password";
	}
}
