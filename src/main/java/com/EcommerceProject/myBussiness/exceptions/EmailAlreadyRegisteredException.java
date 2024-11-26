package com.EcommerceProject.myBussiness.exceptions;

public class EmailAlreadyRegisteredException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	public EmailAlreadyRegisteredException () {
	 super ("Email already registered");	
	}

	public EmailAlreadyRegisteredException(String mensage) {
		super(mensage);
	}
}
