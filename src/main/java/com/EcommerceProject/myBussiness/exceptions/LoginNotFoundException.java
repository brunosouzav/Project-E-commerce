package com.EcommerceProject.myBussiness.exceptions;

public class LoginNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L; 

	public LoginNotFoundException() {
		super("Login or password invalid");
	}

	public LoginNotFoundException (String mensage) {
		super(mensage);
	}
}
