package com.cg.dao;

import com.cg.entities.Users;

public interface UserDao {
	
	public int registerUser(Users user);
	public Users LoginUser(String user_name, String password);
}
