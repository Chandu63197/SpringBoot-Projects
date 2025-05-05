package org.jsp.adminbusapi.exception;

import org.jsp.adminbusapi.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdminBusApiexceptionHandler {
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleANFE(AdminNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData("Admin Not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BusNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleBNFE(BusNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData("Bus Not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
