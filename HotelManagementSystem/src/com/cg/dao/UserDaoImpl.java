package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.dbutil.DBUtil;
import com.cg.entities.Hotel;
import com.cg.entities.Users;

public class UserDaoImpl implements UserDao{
	
	Connection con=null;
	Statement st= null;
	PreparedStatement pst = null;
	ResultSet rs=null;
	

	@Override
	public int registerUser(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Users LoginUser(String user_name, String password) {
		
		Users user = null;
		
		try 
		{
			con=DBUtil.getConn();
			String query="SELECT * FROM Users where username='"+user_name+"' AND password='"+password+"'";
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

}
