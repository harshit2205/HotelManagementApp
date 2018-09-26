package com.cg.service;

import java.util.List;

import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;

public interface AdminService {

	public List<Hotel> fetchHotelList();
	public void addNewhotel(Hotel hotel);
	public void updateHotelInfo(Hotel hotel);
	public Hotel searchHotel(String hotel_id);
	public List<RoomDetails> fetchAvailableRooms(String hotel_id);
	public List<RoomDetails> fetchBookedRooms(String hotel_id);
	public void addRooms(RoomDetails roominfo);
	public void updateRoomInfo(RoomDetails roominfo);
	public void removeRoom(String room_id);
	public List<RoomDetails> fetchAllRooms();
}
