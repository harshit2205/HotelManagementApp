package com.cg.service;

import com.cg.dao.UserDaoImpl;
import com.cg.entities.Users;

public class UserServiceImpl implements UserService{

	UserDaoImpl userDaoImpl;
	
	
	
	public UserServiceImpl() {
		userDaoImpl = new UserDaoImpl();
	}

	@Override
	public int registerUser(Users user) {
		
		return userDaoImpl.registerUser(user);
	}

	@Override
	public Users LoginUser(String user_name, String password) {
		
		return null;
	}

}
