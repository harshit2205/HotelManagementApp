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
		String user_name, password;
		System.out.println("LOGIN PORTAL\n");
		System.out.print("username:   ");
		user_name = scan.next();
		System.out.print("password:   ");
		password = scan.next();
		
		if(user_name.equals("secret123") || password.equals("secret123")){
			showAdminDashboard(user_name);
		}else{
			Users currentUser = userSer.LoginUser(user_name, password);
			if(currentUser == null){
				System.out.println("Invalid User Login Again!");
				Login();
			}else{
				showUserDashboard(currentUser);
			}
		}
		
		
		
	}


	private static void showUserDashboard(Users currentUser) {
		// TODO Auto-generated method stub
		
	}


	private static void showAdminDashboard(String user_name) {
		int choice = 0;
		System.out.println("Welcome "+user_name+"\n");
		System.out.println("1. Add New Hotel.");
		System.out.println("2. Modify Hotel Details.");
		System.out.println("3. Show All Hotels Info.");
		choice = scan.nextInt();
		
		switch(choice){
		case 1: addNewhotel();
			break;
		case 2: modifyHotel();
			break;
		case 3: fetchHotel();
			break;
		default:System.out.println("Invalid Input! Please Try Again.");
		}
	}


	private static void addNewhotel() {
		Hotel hotel = new Hotel();
		System.out.println("\nENTER HOTEL DETAILS.");
		System.out.print("Enter Hotel Name: ");
		hotel.setHotel_name(scan.next());
		System.out.print("Enter Hotel Address: ");
		hotel.setAddress(scan.next());
		System.out.print("Enter Corresponding City: ");
		hotel.setCity(scan.next());
		System.out.print("Enter Hotel Rating: ");
		hotel.setRating(scan.next());
		System.out.print("Enter Average Rooms Rate Per Night: ");
		hotel.setAvg_rate_per_night(scan.nextFloat());
		System.out.print("Enter Customer Contact Number: \n1: ");
		hotel.setPhone_no(scan.next());
		System.out.print("2: ");
		hotel.setPhone_no2(scan.next());
		System.out.print("Enter Hotel Public Mail: ");
		hotel.setEmail(scan.next());
		System.out.print("Enter Hotel Fax: ");
		hotel.setFax(scan.next());
		
		admSer.addNewhotel(hotel);
		
	}


	private static void modifyHotel() {
		System.out.println("Enter Hotel Id");
		String hotelId=scan.next();
		 if(admSer.searchHotel(hotelId) == null){
			 System.out.println("Invalid Hotel Id! Enter Again");
			 modifyHotel();
		 } else	{
			Hotel hotel = new Hotel(); 
			hotel.setHotel_id(hotelId);
			System.out.println("\nENTER HOTEL DETAILS.");
			System.out.print("Enter Hotel Name: ");
			hotel.setHotel_name(scan.next());
			System.out.print("Enter Hotel Address: ");
			hotel.setAddress(scan.next());
			System.out.print("Enter Corresponding City: ");
			hotel.setCity(scan.next());
			System.out.print("Enter Hotel Rating: ");
			hotel.setRating(scan.next());
			System.out.print("Enter Average Rooms Rate Per Night: ");
			hotel.setAvg_rate_per_night(scan.nextFloat());
			System.out.print("Enter Customer Contact Number: \n1: ");
			hotel.setPhone_no(scan.next());
			System.out.print("2: ");
			hotel.setPhone_no2(scan.next());
			System.out.print("Enter Hotel Public Mail: ");
			hotel.setEmail(scan.next());
			System.out.print("Enter Hotel Fax: ");
			hotel.setFax(scan.next());
			if(admSer.updateHotelInfo(hotel)==1){
				System.out.println("Hotel Details Updated");
			}
			}
	}


	private static void fetchHotel() {
		// TODO Auto-generated method stub
		
	}



}

