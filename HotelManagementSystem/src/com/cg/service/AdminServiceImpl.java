package com.cg.service;

import java.sql.Date;
import java.util.List;

import com.cg.dao.AdminDaoImpl;
import com.cg.entities.BookingDetails;
import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;
import com.cg.entities.Users;

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
	public int addRooms(RoomDetails roominfo) {
		// TODO Auto-generated method stub
		return adminDaoImpl.addRooms(roominfo);
	}

	@Override
	public int updateRoomInfo(RoomDetails roomDetail) {
		// TODO Auto-generated method stub
		return adminDaoImpl.updateRoomInfo(roomDetail);
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

	@Override
	public String maxRoomNoFinder(String hotel_id) {
		return adminDaoImpl.maxRoomNoFinder(hotel_id);
	}

	@Override
	public List<BookingDetails> fetchSpecificDateBooking(Date date) {
		return adminDaoImpl.fetchSpecificDateBooking(date);
	}

	@Override
	public List<BookingDetails> bookingForSpecificHotel(String hotel_id) {
		return adminDaoImpl.bookingForSpecificHotel(hotel_id);
	}

	@Override
	public List<Users> guestForHotel(String hotel_id) {
		return adminDaoImpl.guestForHotel(hotel_id);
	}

	@Override
	public void deleteHotel(String hotel_id) {
	    adminDaoImpl.deleteHotel(hotel_id);
	}

	@Override
	public int updateAvgRate(String hotel_id) {
		return adminDaoImpl.updateAvgRate(hotel_id);
	}

	@Override
	public RoomDetails searchRoom(String room_id) {
		return adminDaoImpl.searchRoom(room_id);
	}

}
