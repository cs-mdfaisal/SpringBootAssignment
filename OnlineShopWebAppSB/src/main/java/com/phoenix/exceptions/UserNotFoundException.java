package com.phoenix.exceptions;

public class UserNotFoundException extends Exception {

	private String message;
	
	public UserNotFoundException(String message) {
		super();
		this.message=message;
	}

	@Override
	public String toString() {
		return "UserNotFoundException [message=" + message + "]";
	}
	
	
}
