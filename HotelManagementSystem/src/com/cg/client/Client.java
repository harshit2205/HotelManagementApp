package com.cg.client;

import java.util.Scanner;

import com.cg.entities.Hotel;
import com.cg.entities.Users;
import com.cg.service.AdminServiceImpl;
import com.cg.service.UserServiceImpl;

public class Client {
	static AdminServiceImpl admSer = null;
	static UserServiceImpl userSer = null;
	
	static Scanner scan;

	public static void main(String[] args) {

		
		int choice = 0;
		scan = new Scanner(System.in);
		admSer = new AdminServiceImpl();
		userSer = new UserServiceImpl();
		
		System.out.println("Welcome to sadbhavna Hotels");
		System.out.println("1.Login\n2.Register");
		choice = scan.nextInt();
		
		switch(choice){
		case 1:Login();
			break;
		case 2:Register();
			break;
		default: System.out.println("incorrect input");
		}

		System.out.println("hello world");
		admSer=new AdminServiceImpl();
		Client.addHotel();
		

	}


	private static void Register() {
		int user_role;
		Users user = new Users();
		System.out.println("Enter User Name");
		user.setUser_name(scan.next());
		System.out.println("Enter Password");
		user.setPassword(scan.next());
		System.out.println("choose role\n1.user\n2.Employee");
		user_role = scan.nextInt();
		if(user_role == 1) user.setRole("user");
		else user.setRole("employee");
		System.out.println("Enter Mobile Number");
		user.setMobile_no(scan.next());
		System.out.println("Enter Phone Number");
		user.setPhone(scan.next());
		System.out.println("Enter Address");
		user.setAddress(scan.next());
		System.out.println("Enter Email Address");
		user.setEmail(scan.next());
		
		int rowsAffected = userSer.registerUser(user);
		System.out.println(rowsAffected);
	}


	private static void Login() {
		// TODO Auto-generated method stub
		
	}


	private static void addHotel()
	{
		 String hotel_id;
		 String city;
		 String hotel_name;
		 String address;
		 String description;
		 float avg_rate_per_night;
		 String phone_no;
		 String phone_no2;
		 String rating;
		 String email;
		 String fax;
		 System.out.println("Enter hotelid");
		 hotel_id=scan.next();
		 city=scan.next();
		 hotel_name=scan.next();
		 address=scan.next();
		 description=scan.next();
		 avg_rate_per_night=scan.nextFloat();
		 phone_no=scan.next();
		 phone_no2=scan.next();
		 rating=scan.next();
		 email=scan.next();
		 fax=scan.next();
		 Hotel hotel=new Hotel(hotel_id,
				 city,hotel_name,
				 address,
				 description,
				 avg_rate_per_night,
				 phone_no,
				 phone_no2,
				 rating,
				 email,
				 fax);
	     try{
	    	int data= admSer.addNewhotel(hotel);
	    	 System.out.println(data+"Inserted");
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	
	}
}

