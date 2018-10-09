package com.cg.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.dbutil.DBUtil;
import com.cg.entities.BookingDetails;
import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;
import com.cg.entities.Users;
import com.cg.exception.BookingsNotFoundException;
import com.cg.exception.HotelNotFoundException;
import com.cg.exception.RoomsNotFoundException;
import com.cg.exception.UserNotFoundException;

public class AdminDaoImpl implements AdminDao
{
	public static final String STAN_AC_ROOM = "STAN_AC_ROOM";
	public static final String STAN_NON_AC_ROOM = "STAN_NON_AC_ROOM";
	public static final String EXEC_AC_ROOM = "EXEC_AC_ROOM";
	public static final String DELUXE_AC_ROOM = "DELUXE_AC_ROOM";
	Connection con=null;
	Statement st= null;
	PreparedStatement pst = null;
	ResultSet rs=null;
	
	
	Logger adminDaoLogger=null;
	public AdminDaoImpl() 
	{
		adminDaoLogger=Logger.getLogger(AdminDaoImpl.class);
		PropertyConfigurator.configure("log4j.properties");
		adminDaoLogger.debug("This is a debug message.");
		adminDaoLogger.warn("This is a warn message.");
		adminDaoLogger.fatal("This is a fatal message.");
	}

	@Override
	public List<Hotel> fetchHotelList() throws HotelNotFoundException{
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
			if(HList.size() == 0){
				throw new HotelNotFoundException("There are no hotels available.");
			}
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		} finally 
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
				adminDaoLogger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		adminDaoLogger.info("All Hotel's data Retrieved");
		return HList;
	}

	@Override
	public int addNewhotel(Hotel hotel) throws HotelNotFoundException{
		int rowsAffected = 0;
		try
		{
			con = DBUtil.getConn();
			String insertHotelQuery="INSERT INTO hotel VALUES(hotel_id_generator.nextval,?,?,?,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(insertHotelQuery);
			pst.setString(1, hotel.getCity());
			pst.setString(2, hotel.getHotel_name());
			pst.setString(3, hotel.getAddress());
			pst.setString(4, hotel.getDescription());
			pst.setFloat(5, hotel.getAvg_rate_per_night());
			pst.setString(6, hotel.getPhone_no());
			pst.setString(7, hotel.getPhone_no2());
			pst.setString(8, hotel.getRating());
			pst.setString(9, hotel.getEmail());
			pst.setString(10,hotel.getFax());
			
			rowsAffected =  pst.executeUpdate();
			if(rowsAffected == 0){
				throw new HotelNotFoundException("Sorry! could not add new Hotel.");
			}
		}catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		}
		adminDaoLogger.info("New Hotel Data Inserted");
		return rowsAffected;
		
	}

	@Override
	public int updateHotelInfo(Hotel hotel) throws HotelNotFoundException{
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
			if(rowsAffected == 0){
				throw new HotelNotFoundException("Could not modify hotel details.");
			}
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		}
		adminDaoLogger.info("Hotel data updated");
		return rowsAffected;
	}

	@Override
	public Hotel searchHotel(String hotel_id) throws HotelNotFoundException{
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
			if(hotel == null){
				throw new HotelNotFoundException("There is no hotel with given hotel_id.");
			}
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		} finally {
			try {
				rs.close();
				con.close();
				st.close();
			} catch (SQLException e) {
				adminDaoLogger.error(e.getMessage());
				System.out.println("App Error: There is problem closing connections.");
			}
		}
		adminDaoLogger.info("The hotel for hotel id "+hotel_id+" is retireved"+hotel);
		return hotel;
	}

	@Override
	public List<RoomDetails> fetchAvailableRooms(String hotel_id) throws RoomsNotFoundException 
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
			if(RoomList.size() == 0){
				throw new RoomsNotFoundException("there are no rooms available.");
			}
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		} finally 
		{
			try
			{
				st.close();
				rs.close();
				con.close();
			}
			catch(SQLException e)
			{
				adminDaoLogger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		adminDaoLogger.info("All Available Rooms data Retrieved");
		return RoomList;
	}

	@Override
	public List<RoomDetails> fetchBookedRooms(String hotel_id) throws RoomsNotFoundException
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
			if(RoomList.size() == 0){
				throw new RoomsNotFoundException("No rooms available for this hotel.");
			}
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		} finally 
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
				adminDaoLogger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		adminDaoLogger.info("All Booked Rooms data Retrieved");
		return RoomList;
	}

	@Override
	public int addRooms(RoomDetails roominfo) throws RoomsNotFoundException, HotelNotFoundException{
		int rowsAffected = 0;
		try
		{
			con = DBUtil.getConn();
			String insertRoomQuery="INSERT INTO roomdetails VALUES(?,room_id_generator.nextval,?,?,?,?,?)";
			pst=con.prepareStatement(insertRoomQuery);
			pst.setString(1, roominfo.getHotel_id());
			pst.setString(2, maxRoomNoFinder(roominfo.getHotel_id()));
			pst.setString(3, roominfo.getRoom_type());
			pst.setFloat(4, roominfo.getPer_night_rate());
			pst.setInt(5, roominfo.isAvailability());
			pst.setString(6, null);
			rowsAffected = pst.executeUpdate();
			if(rowsAffected == 0){
				throw new RoomsNotFoundException("Sorry! could not insert rooms. Please try again.");
			}
			updateAvgRate(roominfo.getHotel_id());
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		}
		adminDaoLogger.info("New Room data Inserted."+rowsAffected);
		return rowsAffected;
	}

	@Override
	public int updateRoomInfo(RoomDetails roomInfo) throws RoomsNotFoundException{
		int rowsAffected = 0;
		try 
		{
			con = DBUtil.getConn();
			String updateRoomQuery = "UPDATE RoomDetails SET room_no=?,room_type=?,per_night_rate=?,availability=?,photo=? WHERE room_id=?";
			pst = con.prepareStatement(updateRoomQuery);
			pst.setString(1, roomInfo.getRoom_no());
			pst.setString(2, roomInfo.getRoom_type());
			pst.setFloat(3, roomInfo.getPer_night_rate());
			pst.setInt(4, roomInfo.isAvailability());
			pst.setBlob(5, roomInfo.getImageFile());
			pst.setString(6, roomInfo.getRoom_id());
			rowsAffected = pst.executeUpdate();	
			if(rowsAffected == 0){
				throw new RoomsNotFoundException("Sorry! could not update room info please try again.");
			}
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		}
		adminDaoLogger.info("Room data Updated."+rowsAffected);
		return rowsAffected;
	}

	@Override
	public void removeRoom(String room_id) throws RoomsNotFoundException{
		try
		{
			con=DBUtil.getConn();
			String removeRoomQuery="DELETE FROM RoomDetails WHERE room_id= ?";
			pst=con.prepareStatement(removeRoomQuery);
			pst.setString(1,room_id);
			rs=pst.executeQuery();
			if(rs == null){
				throw new RoomsNotFoundException("couldn't delete room Please try again.");
			}
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		}finally 
        {
            try
            {   
                rs.close();
                pst.close();
                con.close();
            }
            catch(SQLException e)
            {
            	adminDaoLogger.error(e.getMessage());
                e.printStackTrace();
            }
        }
		adminDaoLogger.info("Room data is deleted");
	}

	@Override
	public List<RoomDetails> fetchAllRooms(String hotel_id) throws RoomsNotFoundException
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
            if(AllRoomList.size() == 0){
            	throw new RoomsNotFoundException("there are no rooms to show.");
            }
        } catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		}finally 
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
            	adminDaoLogger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        adminDaoLogger.info("All rooms data is retrieved");
        return AllRoomList;
	}

	@Override
	public List<BookingDetails> fetchSpecificDateBooking(String date) throws BookingsNotFoundException{
		List<BookingDetails> bookingsList = new ArrayList<BookingDetails>();
		try{
			con=DBUtil.getConn();
			String selectqry="SELECT * FROM bookingdetails WHERE booked_from<='"+date+"' AND booked_to>'"+date+"'";
			st=con.createStatement();
			rs=st.executeQuery(selectqry);
			
			while(rs.next())
			{
				bookingsList.add(new BookingDetails(rs.getString("booking_id"),
				rs.getString("room_id"),
				rs.getString("user_id"),
				rs.getDate("booked_from"),
				rs.getDate("booked_to"),
				rs.getInt("no_of_adults"),
				rs.getInt("no_of_children"),
				rs.getFloat("amount")
				));
			}
			if(bookingsList.size() == 0){
				throw new BookingsNotFoundException("There are no bookings for the specific date."
						+ "\nPlease try again.");
			}
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		} finally{
			try{
				rs.close();
				st.close();
				con.close();
			}
			catch(SQLException e){
				adminDaoLogger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		adminDaoLogger.info("The booking list data for date"+date+" is retireved");
		return bookingsList;
	}

	@Override
	public List<BookingDetails> bookingForSpecificHotel(String hotel_id) throws BookingsNotFoundException{
		List<BookingDetails> BList=new ArrayList<BookingDetails>();
		try{
			con=DBUtil.getConn();
			String selectqry="SELECT * FROM bookingdetails WHERE room_id IN (SELECT room_id FROM roomdetails WHERE hotel_id='"+hotel_id+"')";
			st=con.createStatement();
			rs=st.executeQuery(selectqry);		
			
			if(rs == null){
				throw new BookingsNotFoundException("There is no bookings found for perticular");
			}
			
			while(rs.next()){
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
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		} finally{
			try{
				st.close();
				rs.close();
				con.close();
			}
			catch(SQLException e){
				adminDaoLogger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		adminDaoLogger.info("The booking list data for hotel id "+hotel_id+" is retireved");
		return BList;
	}

	@Override
	public List<Users> guestForHotel(String hotel_id) throws UserNotFoundException{
		
		List<Users> userList = new ArrayList<>();
		
		try{
			con=DBUtil.getConn();
			String query="SELECT user_id FROM bookingdetails WHERE room_id IN (SELECT room_id FROM roomdetails WHERE hotel_id='"+hotel_id+"')";
			st=con.createStatement();
			rs = st.executeQuery(query);	
			Users user = null;
			
			while(rs.next())
			{
				String query1 = "SELECT * FROM users WHERE user_id='"+rs.getString("user_id")+"'";
				ResultSet rs2 = st.executeQuery(query1);
				while(rs2.next()){
					user = new Users(rs.getString("user_id"),
							rs.getString("password"),
							rs.getString("role"),
							rs.getString("user_name"),
							rs.getString("mobile_no"),
							rs.getString("phone"),
							rs.getString("address"),
							rs.getString("email"));
				}
				userList.add(user);
			}
			if(userList.size() == 0){
				throw new UserNotFoundException("There are no guests for the corresponding"
						+ "\n hotel.");
			}
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		} finally{
			try{
				st.close();
				rs.close();
				con.close();
			}
			catch(SQLException e){
				adminDaoLogger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		adminDaoLogger.info("The guest list for hotel id"+hotel_id+"is retireved");
		return userList;
	}

	@Override
	public void deleteHotel(String hotel_id) throws HotelNotFoundException{
		try
		{
			con=DBUtil.getConn();
			String deleteQuery="DELETE FROM Hotel WHERE hotel_id=?";
			pst=con.prepareStatement(deleteQuery);
			pst.setString(1,hotel_id);
			rs=pst.executeQuery();
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		} finally{
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {
				adminDaoLogger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		adminDaoLogger.info("The hotel data for hotel id"+hotel_id+" is deleted");
	}

	@Override
	public int updateAvgRate(String hotel_id) throws HotelNotFoundException{
		Float average = 0f;
		int rowsAffected = 0;
		try
		{
			con = DBUtil.getConn();
			String query="SELECT AVG(per_night_rate) FROM roomdetails WHERE hotel_id='"+hotel_id+"'";
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) average = rs.getFloat(1);
			
			Hotel hotel = searchHotel(hotel_id);
			hotel.setAvg_rate_per_night(average);
			rowsAffected = updateHotelInfo(hotel);
			if(rowsAffected == 0){
				throw new HotelNotFoundException("Couldnt update avg rate.");
			}
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		} finally{
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				adminDaoLogger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		adminDaoLogger.info("The hotel average rate is updated"+rowsAffected);
		return rowsAffected;
	}

	@Override
	public String maxRoomNoFinder(String hotel_id) throws HotelNotFoundException, RoomsNotFoundException{
		
		int maxValue=1; 
		try
		{
			con=DBUtil.getConn();
			String query="Select Max(room_no) from roomdetails where hotel_id='"+hotel_id+"'";
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()) maxValue = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		} finally{
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				adminDaoLogger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		adminDaoLogger.info("The maximum room no of hotel is retrieved"+maxValue);
		return Integer.toString(maxValue+1);
	}

	@Override
	public RoomDetails searchRoom(String room_id) throws RoomsNotFoundException{
		RoomDetails roomDetails = null;
		try
		{
			con=DBUtil.getConn();
			String query="Select * from roomdetails where room_id='"+room_id+"'";
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				roomDetails = new RoomDetails();
				roomDetails.setHotel_id(rs.getString("hotel_id"));
				roomDetails.setRoom_id(rs.getString("room_id"));
				roomDetails.setRoom_no(rs.getString("room_no"));
				roomDetails.setRoom_type(rs.getString("room_type"));
				roomDetails.setPer_night_rate(rs.getFloat("per_night_rate"));
				roomDetails.setAvailability(rs.getInt("availability"));
			}
			if(roomDetails == null){
				throw new RoomsNotFoundException("No room found from the corresponding room_id"
						+ "\nPlease try again.");
			}
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		} finally{
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				adminDaoLogger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		adminDaoLogger.info("The room for room_id"+room_id+"is retrieved");
		return roomDetails;
	}

	@Override
	public boolean searchUser(String user_name) {
		Users user = null;
		try{
			con=DBUtil.getConn();
			String query="Select * from Users where user_name='"+user_name+"'";
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				user = new Users(rs.getString("user_id"),
						rs.getString("password"),
						rs.getString("role"),
						rs.getString("user_name"),
						rs.getString("mobile_no"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("email"));
			}
		} catch (SQLException e) {
			System.out.println("App Error: There is problem in syntax.");
		} catch(IOException e){
			System.out.println("App Error: Could not establish proper connection.");
		} finally{
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(user == null) return false;
		else return true;
		
	}

 
}
