package com.cg.service;

import java.sql.Date;
import java.util.List;

import com.cg.dao.UserDaoImpl;
import com.cg.entities.BookingDetails;
import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;
import com.cg.entities.Users;
import com.cg.exception.BookingsNotFoundException;
import com.cg.exception.HotelNotFoundException;
import com.cg.exception.RoomsNotFoundException;
import com.cg.exception.UserCreationException;
import com.cg.exception.UserNotFoundException;

public class UserServiceImpl implements UserService{

	UserDaoImpl userDaoImpl;
	
	public UserServiceImpl() {
		userDaoImpl = new UserDaoImpl();
	}

	@Override
	public int registerUser(Users user) throws UserCreationException{
		return userDaoImpl.registerUser(user);
	}

	@Override
	public Users LoginUser(String user_name, String password) 
			throws UserNotFoundException{
		return userDaoImpl.LoginUser(user_name, password);
	}

	@Override
	public List<RoomDetails> fetchAvailableRooms(String hotel_id) 
			throws RoomsNotFoundException{
		return userDaoImpl.fetchAvailableRooms(hotel_id);
	}

	@Override
	public BookingDetails bookRoom(String room_id, BookingDetails bookDet) 
			throws RoomsNotFoundException, BookingsNotFoundException{
		return userDaoImpl.bookRoom(room_id, bookDet);
	}

	@Override
	public BookingDetails viewBookingStatus(String booking_id) 
			throws BookingsNotFoundException{
		return userDaoImpl.viewBookingStatus(booking_id);
	}

	@Override
	public float amountCalculator(Date bookedFrom, Date bookedTo,
			Float avgRatePerNight) {
		int diffInDays = (int)( (bookedTo.getTime() - bookedFrom.getTime()) 
                / (1000 * 60 * 60 * 24));
		return (diffInDays*avgRatePerNight);
	}

	@Override
	public List<Hotel> searchHotelByCity(String city) 
			throws HotelNotFoundException{
		return userDaoImpl.searchHotelByCity(city);
	}

	@Override
	public Float fetchPerNightRate(String room_id) 
			throws RoomsNotFoundException{
		return userDaoImpl.fetchPerNightRate(room_id);
	}

}
