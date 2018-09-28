package com.cg.service;

import java.util.List;

import com.cg.entities.BookingDetails;
import com.cg.entities.RoomDetails;
import com.cg.entities.Users;

public interface UserService {

	public int registerUser(Users user);
	public Users LoginUser(String user_name, String password);
	public List<RoomDetails> fetchAvailableRooms(String hotel_id);
	public BookingDetails bookRoom(String room_id,BookingDetails bookDet);
	public BookingDetails viewBookingStatus(String booking_id);
}
