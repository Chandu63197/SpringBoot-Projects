package org.jsp.springbootapi.exception;

import java.util.List;

import org.jsp.springbootapi.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserBootApiExceptionHandler extends ResponseEntityExceptionHandler{
   @ExceptionHandler(IdNotFoundException.class)
   public ResponseEntity<ResponseStructure<String>> handleINFE(IdNotFoundException exception){
	   ResponseStructure<String> structure=new ResponseStructure<>();
	   structure.setData("User Not Found");
	   structure.setMessage(exception.getMessage());
	   structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	   return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(InvalidCredentialsException.class)
   public ResponseEntity<ResponseStructure<String>> handleICE(InvalidCredentialsException exception){
	   ResponseStructure<String> structure=new ResponseStructure<>();
	   structure.setData("User Not verified");
	   structure.setMessage(exception.getMessage());
	   structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	   return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(NameNotFoundException.class)
   public ResponseEntity<ResponseStructure<String>> handleNNFE(NameNotFoundException exception){
	   ResponseStructure<String> structure=new ResponseStructure<>();
	   structure.setData("User Not verified");
	   structure.setMessage(exception.getMessage());
	   structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	   return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(AgeNotFoundException.class)
   public ResponseEntity<ResponseStructure<String>> handleANFE(AgeNotFoundException exception){
	   ResponseStructure<String> structure=new ResponseStructure<>();
	   structure.setData("User Not verified");
	   structure.setMessage(exception.getMessage());
	   structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	   return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(EmailNotFoundException.class)
   public ResponseEntity<ResponseStructure<String>> handleENFE(EmailNotFoundException exception){
	   ResponseStructure<String> structure=new ResponseStructure<>();
	   structure.setData("User Not verified");
	   structure.setMessage(exception.getMessage());
	   structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	   return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(PhoneNotFoundException.class)
   public ResponseEntity<ResponseStructure<String>> handlePNFE(PhoneNotFoundException exception){
	   ResponseStructure<String> structure=new ResponseStructure<>();
	   structure.setData("User Not verified");
	   structure.setMessage(exception.getMessage());
	   structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	   return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
   }


}
