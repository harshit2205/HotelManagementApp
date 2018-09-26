package com.cg.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.dbutil.DBUtil;
import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;

public class AdminDaoImpl implements AdminDao
{
	Connection con=null;
	Statement st= null;
	PreparedStatement pst = null;
	ResultSet rs=null;
	
	
	@Override
	public List<Hotel> fetchHotelList() 
	{
		List<Hotel> HList=new ArrayList<Hotel>();
		try 
		{
			con=DBUtil.getConn();
			String selectqry="SELECT * FROM hotel";
			st=con.createStatement();
			rs=st.executeQuery(selectqry);		
			
			while(rs.next())
			{
				HList.add(new Hotel(rs.getString("hotel_id"),
				rs.getString("city"),
				rs.getString("hotel_name"),
				rs.getString("address"),
				rs.getString("description"),
				rs.getFloat("avg_rate_per_night"),
				rs.getString("phone_no1"),
				rs.getString("phone_no2"),
				rs.getString("rating"),
				rs.getString("email"),
				rs.getString("fax")));
			}
		}
		catch(Exception e)
		{
//			throw new HotelException(e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				st.close();
				rs.close();
				con.close();
			}
			catch(SQLException e)
			{
//				throw  new HotelException(e.getMessage());
				e.printStackTrace();
			}
		}
		
		return HList;
	}

	@Override
	public int addNewhotel(Hotel hotel) {
		// TODO Auto-generated method stub
		
		try
		{
			con = DBUtil.getConn();
			String insertHotelQuery="INSERT INTO hotel VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(insertHotelQuery);
			pst.setString(1, hotel.getHotel_id());
			pst.setString(2, hotel.getCity());
			pst.setString(3, hotel.getHotel_name());
			pst.setString(4, hotel.getAddress());
			pst.setString(5, hotel.getDescription());
			pst.setFloat(6, hotel.getAvg_rate_per_night());
			pst.setString(7, hotel.getPhone_no());
			pst.setString(8, hotel.getPhone_no2());
			pst.setString(9, hotel.getRating());
			pst.setString(10, hotel.getEmail());
			pst.setString(11, hotel.getFax());
			
			return pst.executeUpdate();
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void updateHotelInfo(Hotel hotel) {
		try 
		{
			con = DBUtil.getConn();
			String updateQuery = "UPDATE hotel SET city=?,hotel_name=?,address=?,description=?,avg_rate_per_night=?,phone_no1=?,phone_no2=?,rating=?,email=?,fax=? WHERE hotel_id=?";
			pst = con.prepareStatement(updateQuery);
			pst.setString(1, hotel.getCity ());
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
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Hotel searchHotel(String hotel_id) {
		Hotel hotel = new Hotel();
		try {
			con = DBUtil.getConn();
			String searchQuery = "SELECT * FROM hotel WHERE hotel_id="+hotel_id;
			st=con.createStatement();
			rs=st.executeQuery(searchQuery);
			while(rs.next()) {
				hotel.setHotel_id(rs.getString("hotel_id"));
				hotel.setCity(rs.getString("city"));
				hotel.setHotel_name(rs.getString("hotel_name"));
				hotel.setAddress(rs.getString("address"));
				hotel.setDescription(rs.getString("description"));
				hotel.setAvg_rate_per_night(rs.getFloat("avg_rate_per_night"));
				hotel.setPhone_no(rs.getString("phone_no1"));
				hotel.setPhone_no2(rs.getString("phone_no2"));
				hotel.setRating(rs.getString("rating"));
				hotel.setEmail(rs.getString("email"));
				hotel.setFax(rs.getString("fax"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			rs.close();
			con.close();
			st.close();
		}
		
		return hotel;
	}

	@Override
	public List<RoomDetails> fetchAvailableRooms(String hotel_id) 
	{
		List<RoomDetails> RoomList=new ArrayList<RoomDetails>();
		try 
		{
			con=DBUtil.getConn();
			String selectqry="SELECT Room_No FROM RoomDetails where availability=1 AND hotel_id="+hotel_id;
			st=con.createStatement();
			rs=st.executeQuery(selectqry);		
			
			while(rs.next())
			{
				RoomList.add(new RoomDetails(rs.getString("hotel_id"),
						rs.getString("room_id"),
						rs.getString("room_no"),
						rs.getString("room_type"),
						rs.getFloat("per_night_rate"),
						rs.getInt("availability"),
						rs.getBlob("imageFile")));
			}
		}
			
		catch(Exception e)
		{
			
//			throw new HotelException(e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				st.close();
				rs.close();
				con.close();
			}
			catch(SQLException e)
			{
//				throw  new HotelException(e.getMessage());
				e.printStackTrace();
			}
		}
		
		return RoomList;
	}

	@Override
	public List<RoomDetails> fetchBookedRooms(String hotel_id)
	{
		List<RoomDetails> RoomList=new ArrayList<RoomDetails>();
		try 
		{
			con=DBUtil.getConn();
			String selectqry="SELECT Room_No FROM RoomDetails where availability=1 AND hotel_id="+hotel_id;
			st=con.createStatement();
			rs=st.executeQuery(selectqry);		
			
			while(rs.next())
			{
				RoomList.add(new RoomDetails(rs.getString("hotel_id"),
						rs.getString("room_id"),
						rs.getString("room_no"),
						rs.getString("room_type"),
						rs.getFloat("per_night_rate"),
						rs.getInt("availability"),
						rs.getBlob("imageFile")));
			}
		}
			
		catch(Exception e)
		{
			
//			throw new HotelException(e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				st.close();
				rs.close();
				con.close();
			}
			catch(SQLException e)
			{
//				throw  new HotelException(e.getMessage());
				e.printStackTrace();
			}
		}
		
		return RoomList;
	}

	@Override
	public void addRooms(RoomDetails roominfo) {
		
		try
		{
			con = DBUtil.getConn();
			String insertRoomQuery="INSERT INTO roomdetails VALUES(?,?,?,?,?,?,?)";
			pst=con.prepareStatement(insertRoomQuery);
			pst.setString(1, roominfo.getHotel_id());
			pst.setString(2, roominfo.getRoom_id());
			pst.setString(3, roominfo.getRoom_no());
			pst.setString(4, roominfo.getRoom_type());
			pst.setFloat(5, roominfo.getPer_night_rate());
			pst.setInt(6, roominfo.isAvailability());
			pst.setString(7, null);
			
			pst.executeUpdate();
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void updateRoomInfo(RoomDetails roominfo) {
		// TODO Auto-generated method stub
		try 
		{
			con = DBUtil.getConn();
			String updateRoomQuery = "UPDATE RoomDetails SET room_no=?,room_type=?,per_night_rate=?,availability=?,photo=? WHERE room_id=?";
			pst = con.prepareStatement(updateRoomQuery);
			pst.setString(1, roominfo.getRoom_no());
			pst.setString(2, roominfo.getRoom_type());
			pst.setFloat(3, roominfo.getPer_night_rate());
			pst.setInt(4, roominfo.isAvailability());
			pst.setBlob(5, roominfo.getImageFile());
			pst.setString(6, roominfo.getRoom_id());
			pst.executeUpdate();	
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeRoom(String room_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RoomDetails> fetchAllRooms(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
