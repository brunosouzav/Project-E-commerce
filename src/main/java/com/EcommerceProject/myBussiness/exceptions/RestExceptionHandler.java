package com.EcommerceProject.myBussiness.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmailAlreadyRegisteredException.class)
	private ResponseEntity<String> emailAlreadyRegistered(EmailAlreadyRegisteredException exception){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
	}

	@ExceptionHandler(LoginNotFoundException.class)
	private ResponseEntity<String> loginNotFoundException (LoginNotFoundException loginNotFoundException){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(loginNotFoundException.getMessage());
	} 

}
