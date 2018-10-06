package com.cg.service;

import com.cg.entities.BookingDetails;
import com.cg.entities.Hotel;
import com.cg.entities.Users;
import com.cg.exception.ValidationException;

public interface ValidationService 
{
	public String userValidation(Users user) 
			throws ValidationException;
	public String hotelValidation(Hotel hotel) 
			throws ValidationException;
	public String bookingDetailsValidation(BookingDetails bookD) 
			throws ValidationException;
}
