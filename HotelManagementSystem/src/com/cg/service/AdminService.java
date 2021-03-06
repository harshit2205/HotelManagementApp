package com.cg.service;

import java.util.List;

import com.cg.entities.BookingDetails;
import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;
import com.cg.entities.Users;
import com.cg.exception.BookingsNotFoundException;
import com.cg.exception.HotelNotFoundException;
import com.cg.exception.RoomsNotFoundException;
import com.cg.exception.UserNotFoundException;

public interface AdminService {

	public List<Hotel> fetchHotelList() 
			throws HotelNotFoundException;
	public int addNewhotel(Hotel hotel)
			throws HotelNotFoundException;
	public int updateHotelInfo(Hotel hotel) 
			throws HotelNotFoundException;
	public Hotel searchHotel(String hotel_id) 
			throws HotelNotFoundException;
	public List<RoomDetails> fetchAvailableRooms(String hotel_id)
			throws RoomsNotFoundException;
	public List<RoomDetails> fetchBookedRooms(String hotel_id)
			throws RoomsNotFoundException;
	public int addRooms(RoomDetails roominfo)
			throws RoomsNotFoundException, HotelNotFoundException;
	public int updateRoomInfo(RoomDetails roomDetail)
			throws RoomsNotFoundException;
	public void removeRoom(String room_id)
			throws RoomsNotFoundException;
	public List<RoomDetails> fetchAllRooms(String hotel_id)
			throws RoomsNotFoundException;
	public List<BookingDetails> fetchSpecificDateBooking(String date)
			throws BookingsNotFoundException;
	public List<BookingDetails> bookingForSpecificHotel(String hotel_id)
			throws BookingsNotFoundException;
	public List<Users> guestForHotel(String hotel_id)
			throws UserNotFoundException; 
	public void deleteHotel(String hotel_id)
			throws HotelNotFoundException;
	public int updateAvgRate(String hotel_id)
			throws HotelNotFoundException;
	public String maxRoomNoFinder(String hotel_id)
			throws HotelNotFoundException, RoomsNotFoundException;
	public RoomDetails searchRoom(String room_id)
			throws RoomsNotFoundException;
	public boolean searchUser(String user_name);
	public RoomDetails searchAvailableRoom(String room_id)
			throws RoomsNotFoundException;
	public RoomDetails searchAvailableRoomByHotel(String hotel_id)
			throws RoomsNotFoundException; 
}
