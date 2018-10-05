package com.cg.service;

import java.sql.Date;
import java.util.List;

import com.cg.entities.BookingDetails;
import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;
import com.cg.entities.Users;
import com.cg.exception.BookingsNotFoundException;
import com.cg.exception.HotelNotFoundException;
import com.cg.exception.RoomsNotFoundException;
import com.cg.exception.UserCreationException;
import com.cg.exception.UserNotFoundException;

public interface UserService {
	public int registerUser(Users user) 
			throws UserCreationException;
	public Users LoginUser(String user_name, String password)
			throws UserNotFoundException;
	public List<RoomDetails> fetchAvailableRooms(String hotel_id)
			throws RoomsNotFoundException;
	public BookingDetails bookRoom(String room_id,BookingDetails bookDet)
			throws RoomsNotFoundException, BookingsNotFoundException;
	public BookingDetails viewBookingStatus(String booking_id)
			throws BookingsNotFoundException;
	public List<Hotel> searchHotelByCity(String city)
			throws HotelNotFoundException;
	public Float fetchPerNightRate(String room_id)
			throws RoomsNotFoundException;
	public float amountCalculator(Date bookedFrom,Date bookedTo,Float avgRatePerNight);
}
