package com.cg.service;

import java.sql.Date;
import java.util.List;

import com.cg.entities.BookingDetails;
import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;
import com.cg.entities.Users;

public interface AdminService {

	public List<Hotel> fetchHotelList();
	public int addNewhotel(Hotel hotel);
	public int updateHotelInfo(Hotel hotel);
	public Hotel searchHotel(String hotel_id);
	public List<RoomDetails> fetchAvailableRooms(String hotel_id);
	public List<RoomDetails> fetchBookedRooms(String hotel_id);
	public int addRooms(RoomDetails roominfo);
	public int updateRoomInfo(RoomDetails roomDetail);
	public void removeRoom(String room_id);
	public List<RoomDetails> fetchAllRooms(String hotel_id);
	public List<BookingDetails> fetchSpecificDateBooking(Date date);
	public List<BookingDetails> bookingForSpecificHotel(String hotel_id);
	public List<Users> guestForHotel(String hotel_id); 
	public void deleteHotel(String hotel_id);
	public int updateAvgRate(String hotel_id);
	public String maxRoomNoFinder(String hotel_id);
	public RoomDetails searchRoom(String room_id);
}
