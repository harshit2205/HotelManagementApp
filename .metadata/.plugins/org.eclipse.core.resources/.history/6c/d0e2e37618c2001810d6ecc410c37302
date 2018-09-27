package com.cg.dao;

import java.util.List;

import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;

public interface AdminDao {
	
	public List<Hotel> fetchHotelList();
	public int addNewhotel(Hotel hotel);
	public void updateHotelInfo(Hotel hotel);
	public Hotel searchHotel(String hotel_id);
	public List<RoomDetails> fetchAvailableRooms(String hotel_id);
	public List<RoomDetails> fetchBookedRooms(String hotel_id);
	public void addRooms(RoomDetails roominfo);
	public void updateRoomInfo(RoomDetails roominfo);
	public void removeRoom(String room_id);
	public List<RoomDetails> fetchAllRooms(String hotel_id);
}
