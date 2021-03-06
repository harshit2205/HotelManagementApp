package com.cg.exception;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	String message;

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
