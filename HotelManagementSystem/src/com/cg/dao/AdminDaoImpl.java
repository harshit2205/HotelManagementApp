package com.cg.dao;

import java.util.List;

import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;

public class AdminDaoImpl implements AdminDao{

	@Override
	public List<Hotel> fetchHotelList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewhotel(Hotel hotel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHotelInfo(Hotel hotel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hotel searchHotel(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomDetails> fetchAvailableRooms(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomDetails> fetchBookedRooms(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRooms(RoomDetails roominfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRoomInfo(RoomDetails roominfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRoom(String room_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RoomDetails> fetchAllRooms() {
		// TODO Auto-generated method stub
		return null;
	}
 
}
