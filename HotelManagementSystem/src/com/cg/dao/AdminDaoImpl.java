package com.cg.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
		try
		{
			con = DBUtil.getConn();
			String insertHotelQuery="INSERT INTO hotel VALUES(hotel_id_generator.nextval,?,?,?,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(insertHotelQuery);
			pst.setString(1, hotel.getCity());
			pst.setString(2, hotel.getHotel_name());
			pst.setString(3, hotel.getAddress());
			pst.setString(4, hotel.getDescription());
			pst.setFloat( 5, hotel.getAvg_rate_per_night());
			pst.setString(6, hotel.getPhone_no());
			pst.setString(7, hotel.getPhone_no2());
			pst.setString(8, hotel.getRating());
			pst.setString(9, hotel.getEmail());
			pst.setString(10,hotel.getFax());
			
			return pst.executeUpdate();
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateHotelInfo(Hotel hotel) {
		int rowsAffected=0;
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
			rowsAffected = pst.executeUpdate();	
		} catch (SQLException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rowsAffected;
	}

	@Override
	public Hotel searchHotel(String hotel_id) {
		Hotel hotel = null;
		try {
			con = DBUtil.getConn();
			String Query = "SELECT * FROM hotel WHERE hotel_id='"+hotel_id+"'";
			st=con.createStatement();
			rs=st.executeQuery(Query);
			while(rs.next()) {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public int addRooms(RoomDetails roominfo) {
		int rowsAffected = 0;
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
			
			rowsAffected = pst.executeUpdate();
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public int updateRoomInfo(RoomDetails roominfo) {
		int rowsAffected = 0;
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
			rowsAffected = pst.executeUpdate();	
		}
		catch (SQLException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public void removeRoom(String room_id) {
		try
		{
			con=DBUtil.getConn();
			String removeRoomQuery="DELETE FROM RoomDetails WHERE room_id=?"+room_id;
			pst=con.prepareStatement(removeRoomQuery);
			pst.setString(1,room_id);
			rs=pst.executeQuery();
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<RoomDetails> fetchAllRooms(String hotel_id)
	{
	
        List<RoomDetails> AllRoomList=new ArrayList<RoomDetails>();
        try 
        {
            con=DBUtil.getConn();
            String selectqry="SELECT * FROM RoomDetails";
            st=con.createStatement();
            rs=st.executeQuery(selectqry);      
            
            while(rs.next())
            {
                AllRoomList.add(new RoomDetails(rs.getString("hotel_id"),
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
            
//          throw new HotelException(e.getMessage());
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
//              throw  new HotelException(e.getMessage());
                e.printStackTrace();
            }
        }
        
        return AllRoomList;
	}

	@Override
	public List<BookingDetails> fetchSpecificDateBooking(Date date) {
		return null;
	}

	@Override
	public List<BookingDetails> bookingForSpecificHotel(String hotel_id) {
		List<BookingDetails> BList=new ArrayList<BookingDetails>();
		try{
			con=DBUtil.getConn();
			String selectqry="SELECT * FROM bookingdetails WHERE room_id IN (SELECT room_id FROM roomdetails WHERE hotel_id='"+hotel_id+"')";
			st=con.createStatement();
			rs=st.executeQuery(selectqry);		
			
			while(rs.next())
			{
				BList.add(new BookingDetails(rs.getString("booking_id"),
				rs.getString("room_id"),
				rs.getString("user_id"),
				rs.getDate("booked_from"),
				rs.getDate("booked_to"),
				rs.getInt("no_of_adults"),
				rs.getInt("no_of_children"),
				rs.getFloat("amount")
				));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				st.close();
				rs.close();
				con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return BList;
	}

	@Override
	public List<Users> guestForHotel(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteHotel(String hotel_id) {
		try
		{
			con=DBUtil.getConn();
			String deleteQuery="DELETE FROM Hotel WHERE hotel_id=?";
			pst=con.prepareStatement(deleteQuery);
			pst.setString(1,hotel_id);
			rs=pst.executeQuery();
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
				pst.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

 
}
