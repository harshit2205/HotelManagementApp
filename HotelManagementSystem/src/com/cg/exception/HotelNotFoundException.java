package com.cg.exception;

public class HotelNotFoundException extends Exception{

	
	private static final long serialVersionUID = 1L;
	String message;

	public HotelNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "\nHotel Not Found Exception: "+message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
