package com.cg.service;

import java.sql.Date;
import java.util.List;

import com.cg.entities.BookingDetails;
import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;
import com.cg.entities.Users;

public interface UserService {

	public int registerUser(Users user);
	public Users LoginUser(String user_name, String password);
	public List<RoomDetails> fetchAvailableRooms(String hotel_id);
	public BookingDetails bookRoom(String room_id,BookingDetails bookDet);
	public BookingDetails viewBookingStatus(String booking_id);
	public List<Hotel> searchHotelByCity(String city);
	public float amountCalculator(Date bookedFrom,Date bookedTo,Float avgRatePerNight);
	public Float fetchPerNightRate(String room_id);
}
