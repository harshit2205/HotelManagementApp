package com.cg.service;

import java.util.List;

import com.cg.dao.UserDaoImpl;
import com.cg.entities.BookingDetails;
import com.cg.entities.RoomDetails;
import com.cg.entities.Users;

public class UserServiceImpl implements UserService{

	UserDaoImpl userDaoImpl;
	
	
	
	public UserServiceImpl() {
		userDaoImpl = new UserDaoImpl();
	}

	@Override
	public int registerUser(Users user) {
		
		return userDaoImpl.registerUser(user);
	}

	@Override
	public Users LoginUser(String user_name, String password) {
		
		return null;
	}

	@Override
	public List<RoomDetails> fetchAvailableRooms(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingDetails bookRoom(String room_id, BookingDetails bookDet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingDetails viewBookingStatus(String booking_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
