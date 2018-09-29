package com.cg.client;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.cg.entities.BookingDetails;
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
		
		System.out.println("Welcome to SADBHAVNA HOTELS");
		System.out.println("1.Login\t2.Register");
		choice = scan.nextInt();
		
		switch(choice){
		case 1:Login();
			break;
		case 2:Register();
			break;
		default: System.out.println("incorrect input!");
	
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
		int choice = 0;
		System.out.println("LOGIN PORTAL\n");
		System.out.println("Login as- \n1. Admin\t2. User/Employee");
		choice = scan.nextInt();
		
		System.out.print("username:   ");
		user_name = scan.next();
		System.out.print("password:   ");
		password = scan.next();
		
		switch(choice){
		case 1:
			if(user_name.equals("secret123") || password.equals("secret123")){
			showAdminDashboard(user_name);
			}
			break;
		case 2:
			Users currentUser = userSer.LoginUser(user_name, password);
			if(currentUser == null){
				System.out.println("Invalid User Login Again!");
				Login();
			}else{
				showUserDashboard(currentUser);
			}
			break;
		default:
			System.out.println("Invalid Input Try Again!");
			Login();
		}
		
		
		
	}


	private static void showUserDashboard(Users currentUser) {
		int choice=0;
		System.out.println("Welcome \n"+currentUser+"\n");
		System.out.println("1. Book Room.");
		System.out.println("2. View Booking Status.");
		System.out.println("3. Fetch Available Rooms.");
		choice=scan.nextInt();
		switch (choice) {
		case 1: bookRoom(currentUser.getUser_id());
			
			break;
		case 2: viewBookingStatus();
			    break;
		case 3: fetchAvailableRooms();
		        break;
		
		default: System.out.println("Invalid Input! Please Try Again.");
		         showUserDashboard(currentUser);
		         
			
		}
	}


	private static void fetchAvailableRooms() {
		// TODO Auto-generated method stub
		
	}


	private static void viewBookingStatus() {
		// TODO Auto-generated method stub
		
	}


	private static void bookRoom(String userId) {
		BookingDetails bookingDetails=new BookingDetails();
		System.out.println("Enter Room Id.");
		bookingDetails.setRoom_id(scan.next());
		bookingDetails.setUser_id(userId);
		System.out.println("Enter Check-In Date.");
		bookingDetails.setBooked_from(Date.valueOf(scan.next()));
		System.out.println("Enter Check-Out Date.");
		bookingDetails.setBooked_from(Date.valueOf(scan.next()));
		System.out.println("Enter Number of Adults.");
		bookingDetails.setNo_of_adults(scan.nextInt());
		System.out.println("Enter Number of Children.");
		bookingDetails.setNo_of_children(scan.nextInt());
		
		float avgRate = userSer.amountCalculator(bookingDetails.getBooked_from(), 
				bookingDetails.getBooked_to(), 
				500.00f);
		bookingDetails.setAmount(avgRate);
		bookingDetails=userSer.bookRoom(bookingDetails.getRoom_id(), bookingDetails);
	    System.out.println(bookingDetails);
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
		System.out.println("Enter Description of Hotel");
		scan.nextLine();
		hotel.setDescription(scan.nextLine());
		System.out.print("Enter Average Rooms Rate Per Night: ");
		hotel.setAvg_rate_per_night(scan.nextFloat());
		System.out.print("Enter Contact Number: \n1: ");
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
		System.out.println("\nGet All Hotel List.");
		List<Hotel> hotelList = admSer.fetchHotelList();
		for(Hotel hotel: hotelList){
			System.out.println(hotel);
		}
	}



}


	
	