package com.cg.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.dbutil.DBUtil;
import com.cg.entities.Users;

public class UserDaoImpl implements UserDao{
	
	Connection con=null;
	Statement st= null;
	PreparedStatement pst = null;
	ResultSet rs=null;
	

	@Override
	public int registerUser(Users user) {
		try
		{
			con = DBUtil.getConn();
			String query="INSERT INTO Users VALUES(users.nextval,?,?,?,?,?,?,?)";
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
