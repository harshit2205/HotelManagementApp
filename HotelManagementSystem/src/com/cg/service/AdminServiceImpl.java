package com.cg.service;

import java.util.List;

import com.cg.dao.AdminDaoImpl;
import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;

public class AdminServiceImpl implements AdminService{
	
	AdminDaoImpl adminDaoImpl=null;
	
	

	public AdminServiceImpl() {
		adminDaoImpl = new AdminDaoImpl();
	}

	@Override
	public List<Hotel> fetchHotelList() {
		// TODO Auto-generated method stub
		return adminDaoImpl.fetchHotelList();
	}

	@Override
	public int addNewhotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return adminDaoImpl.addNewhotel(hotel);
	}

	@Override
	public int updateHotelInfo(Hotel hotel) {
		// TODO Auto-generated method stub
		return adminDaoImpl.updateHotelInfo(hotel);
	}

	@Override
	public Hotel searchHotel(String hotel_id) {
		// TODO Auto-generated method stub
		return adminDaoImpl.searchHotel(hotel_id);
	}

	@Override
	public List<RoomDetails> fetchAvailableRooms(String hotel_id) {
		// TODO Auto-generated method stub
		return adminDaoImpl.fetchAvailableRooms(hotel_id);
	}

	@Override
	public List<RoomDetails> fetchBookedRooms(String hotel_id) {
		// TODO Auto-generated method stub
		return adminDaoImpl.fetchBookedRooms(hotel_id);
	}

	@Override
	public void addRooms(RoomDetails roominfo) {
		// TODO Auto-generated method stub
		adminDaoImpl.addRooms(roominfo);
	}

	@Override
	public void updateRoomInfo(RoomDetails roominfo) {
		// TODO Auto-generated method stub
		adminDaoImpl.updateRoomInfo(roominfo);
	}

	@Override
	public void removeRoom(String room_id) {
		// TODO Auto-generated method stub
		adminDaoImpl.removeRoom(room_id);
	}

	@Override
	public List<RoomDetails> fetchAllRooms(String hotel_id) {
		// TODO Auto-generated method stub
		return adminDaoImpl.fetchAllRooms(hotel_id);
	}

}
