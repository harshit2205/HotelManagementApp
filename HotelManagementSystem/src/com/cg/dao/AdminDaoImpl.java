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
		con = DBUtil.getConn();
		String updateQuery = "UPDATE hotel SET city=?,hotel_name=?,address=?,description=?,avg_rate_per_night=?,phone_no1=?,phone_no2=?,rating=?,email=?,fax=? WHERE hotel_id=?";
		pst = con.prepareStatement(updateQuery);
		pst.setString(1, hotel.getCity());
		pst.setString(2, hotel.getHotel_name());
		pst.setString(3, hotel.getAddress());
		pst.setString(4, hotel.getDescription());
		pst.setFloat(5, hotel.getAvg_rate_per_night());
		pst.setString(6, hotel.getPhone_no());
		pst.setString(7, hotel.getPhone_no2());
		pst.setString(8, hotel.getRating());
		pst.setString(9, hotel.getEmail());
		pst.setString(10, hotel.getFax());
		pst.setString(11, hotel.getHotel_id());
		pst.executeUpdate();
		
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
