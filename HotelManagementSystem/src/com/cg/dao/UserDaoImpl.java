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
import com.cg.entities.BookingDetails;
import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;
import com.cg.entities.Users;

public class UserDaoImpl implements UserDao{
	
	
	static int BOOKED=0;
	static int AVAILABLE=1;
	Connection con=null;
	Statement st= null;
	PreparedStatement pst = null;
	ResultSet rs=null;
	

	@Override
	public int registerUser(Users user) {
		try
		{
			con = DBUtil.getConn();
			String query="INSERT INTO Users VALUES(user_sequence.nextval,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(query);
			pst.setString(1, user.getPassword());
			pst.setString(2, user.getRole());
			pst.setString(3, user.getUser_name());
			pst.setString(4, user.getMobile_no());
			pst.setString(5, user.getPhone());
			pst.setString(6, user.getAddress());
			pst.setString(7, user.getEmail());
			return pst.executeUpdate();
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Users LoginUser(String user_name, String password) {
		
		Users user = null;
		try 
		{
			con=DBUtil.getConn();
			String query="SELECT * FROM Users where user_name='"+user_name+"' AND password='"+password+"'";
			st=con.createStatement();
			rs=st.executeQuery(query);		
			
			while(rs.next())
			{
				user = new Users(rs.getString("user_id"),
						rs.getString("password"),
						rs.getString("role"),
						rs.getString("user_name"),
						rs.getString("mobile_no"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("email"));
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
		return user;
	}

	@Override
	public List<RoomDetails> fetchAvailableRooms(String hotel_id) {
		
		List<RoomDetails> roomsList = new ArrayList<RoomDetails>();
		try {
			con = DBUtil.getConn();
			String query="SELECT * FROM roomdetails WHERE hotel_id='"+hotel_id+"' AND availability="+UserDaoImpl.AVAILABLE;
			st=con.createStatement();
			rs=st.executeQuery(query);	
			
			while(rs.next()){
				RoomDetails room = new RoomDetails(
				rs.getString("hotel_id"),
				rs.getString("room_id"),
				rs.getString("room_no"),
				rs.getString("room_type"),
				rs.getFloat("per_night_rate"),
				rs.getInt("availability"),
				rs.getBlob("photo"));
				roomsList.add(room);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally{
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
		return roomsList;
	}

	@Override
	public BookingDetails bookRoom(String room_id, BookingDetails bookDet) {
		
		try {
			con = DBUtil.getConn();
			String query = "UPDATE roomdetails SET availability="+UserDaoImpl.BOOKED+" WHERE roomi_id='"+room_id+"'";
			pst = con.prepareStatement(query);
			pst.executeUpdate();
			
			query="SELECT booking_id_generator.nextval FROM dual";
			st=con.createStatement();
			rs = st.executeQuery(query);
			rs.next();
			String booking_id = rs.getString("nextval");
			
			query = "INSERT INTO bookingdetails VALUES(?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, booking_id);
			pst.setString(1, room_id);
			pst.setString(2, bookDet.getUser_id());
			pst.setDate(3, bookDet.getBooked_from());
			pst.setDate(4, bookDet.getBooked_to());
			pst.setInt(5, bookDet.getNo_of_adults());
			pst.setInt(6, bookDet.getNo_of_children());
			pst.setFloat(7, bookDet.getAmount());
			pst.executeUpdate();
			
			query = "SELECT * FROM bookingdetails WHERE booking_id='"+booking_id+"'";
			st = con.createStatement();
			rs =st.executeQuery(query);
			while(rs.next()){
				bookDet = new BookingDetails(
						rs.getString("booking_id"),
						rs.getString("room_id"),
						rs.getString("user_id"),
						rs.getDate("booked_from"),
						rs.getDate("booked_to"),
						rs.getInt("no_of_adults"),
						rs.getInt("no_of_children"),
						rs.getFloat("amount"));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally{
			try{
				st.close();
				rs.close();
				con.close();
			}
			catch(SQLException e){
//				throw  new HotelException(e.getMessage());
				e.printStackTrace();
			}
		}
		return bookDet;
	}

	@Override
	public BookingDetails viewBookingStatus(String booking_id) {
		
		BookingDetails bookdetail= null;
		try {
			con = DBUtil.getConn();
			String query="SELECT * FROM bookingdetails WHERE booking_id ='"+booking_id+"'";
			st=con.createStatement();
			rs=st.executeQuery(query);	
			
			while(rs.next()){
				bookdetail = new BookingDetails(
						rs.getString("booking_id"),
						rs.getString("room_id"),
						rs.getString("user_id"),
						rs.getDate("booked_from"),
						rs.getDate("booked_to"),
						rs.getInt("no_of_adults"),
						rs.getInt("no_of_children"),
						rs.getFloat("amount"));
			}
			}catch (SQLException | IOException e) {
				e.printStackTrace();
			} finally{
				try
				{
					st.close();
					rs.close();
					con.close();
				}
				catch(SQLException e)
				{
//					throw  new HotelException(e.getMessage());
					e.printStackTrace();
				}
			}
		return bookdetail;
	}

	@Override
	public List<Hotel> searchHotelByCity(String city) {
		List<Hotel> hotels = null;
		try {
			con = DBUtil.getConn();
			String Query = "SELECT * FROM hotel WHERE city='"+city+"'";
			st=con.createStatement();
			rs=st.executeQuery(Query);
			if(rs != null)	hotels = new ArrayList<>();
			while(rs.next()) {
				Hotel hotel = new Hotel();
				hotel = new Hotel();
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
				hotels.add(hotel);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				con.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return hotels;
	}

}
