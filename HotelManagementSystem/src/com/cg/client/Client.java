package com.cg.client;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.cg.dao.AdminDaoImpl;
import com.cg.dao.UserDaoImpl;
import com.cg.entities.BookingDetails;
import com.cg.entities.Hotel;
import com.cg.entities.RoomDetails;
import com.cg.entities.Users;
import com.cg.service.AdminServiceImpl;
import com.cg.service.UserServiceImpl;

public class Client {
	static AdminServiceImpl admSer = null;
	static UserServiceImpl userSer = null;
	
	static Scanner scan;

	public static void main(String[] args) {	
		scan = new Scanner(System.in);
		admSer = new AdminServiceImpl();
		userSer = new UserServiceImpl();
		loadIndex();
		
	}

	//index or the main base page for the application....
	private static void loadIndex() {
		int choice = 0;
		System.out.println("Welcome to SADBHAVNA HOTELS");
		System.out.println("1. Login   2. Register   3. Exit");
		choice = scan.nextInt();
		
		switch(choice){
		case 1:Login();
			break;
		case 2:Register();
			break;
		case 3:System.exit(0);
			break;
		default: System.out.println("incorrect input!");
		loadIndex();
		}
		
	}


	
	private static void Register() {
		System.out.println("\nREGISTRATION PORTAL");
		int user_role;
		Users user = new Users();
		System.out.print("Enter User Name: ");
		user.setUser_name(scan.next());
		System.out.print("Enter Password: ");
		user.setPassword(scan.next());
		System.out.println("choose role\n1.user\n2.Employee");
		user_role = scan.nextInt();
		if(user_role == 1) user.setRole("user");
		else user.setRole("employee");
		System.out.print("Enter Mobile Number: ");
		user.setMobile_no(scan.next());
		System.out.print("Enter Phone Number: ");
		user.setPhone(scan.next());
		System.out.print("Enter Address: ");
		scan.nextLine();
		user.setAddress(scan.nextLine());
		System.out.print("Enter Email Address: ");
		user.setEmail(scan.next());
		int rowsAffected = userSer.registerUser(user);
		if(rowsAffected == 1)	showUserDashboard(user);
		else{	
			System.out.println("Invalid input problem resgistering, Register again");
			loadIndex();
		}
	}


	private static void Login() {
		String user_name, password;
		int choice = 0;
		System.out.println("\nLOGIN PORTAL");
		System.out.println("Login as- \n1. Admin\t2. User/Employee\t3. New User.");
		choice = scan.nextInt();
		
		switch(choice){
		case 1:
			System.out.println("\nEnter Admin Credentials. ");
			System.out.print("username:   ");
			user_name = scan.next();
			System.out.print("password:   ");
			password = scan.next();
			if(user_name.equals("secret123") || password.equals("secret123")){
			showAdminDashboard(user_name);
			}
			break;
		case 2:
			System.out.println("\nEnter User Credentials. ");
			System.out.print("username:   ");
			user_name = scan.next();
			System.out.print("password:   ");
			password = scan.next();
			Users currentUser = userSer.LoginUser(user_name, password);
			if(currentUser == null){
				System.out.println("Invalid User Login Again!");
				Login();
			}else{
				showUserDashboard(currentUser);
			}
			break;
		case 3:
			Register();
			break;
		default:
			System.out.println("Invalid Input Try Again!");
			Login();
		}
		
		
		
	}


	private static void showUserDashboard(Users currentUser) {
		int choice=0;
		System.out.println("\nWelcome "+currentUser.getUser_name());
		System.out.println("\nDASHBOARD");
		System.out.println("1. Find Hotel by City.");
		System.out.println("2. Book Rooms.");
		System.out.println("3. View Booking Status.");
		System.out.println("4. Loggout.");
		choice=scan.nextInt();
		switch (choice) {
		case 1:	findHotelByCity(currentUser);
				showUserDashboard(currentUser);
			break;
		case 2: bookRoom(currentUser);
			break;
		case 3: viewBookingStatus(currentUser);
		    break;
		case 4: loadIndex();
		 	break;
		default: System.out.println("Invalid Input! Please Try Again.");
		         showUserDashboard(currentUser);
		}
	}


	private static void findHotelByCity(Users currentUser) {
		String city;
		System.out.println("\nFind Hotel And Rooms By City.");
		System.out.print("Enter City Name : ");
		city = scan.next();
		System.out.println();
		List<Hotel> hotels = userSer.searchHotelByCity(city);
		if(hotels.size() == 0){
			System.out.println("Could not Find Hotel in the corresponding city!"
					+ "\nYou can try another city.\n");
		}else{
			for(Hotel hotel: hotels){
				System.out.println(hotel);
				
				System.out.println("Showing available Rooms.\n");
				List<RoomDetails> rooms = userSer.fetchAvailableRooms(hotel.getHotel_id());
				for(RoomDetails room : rooms){
					System.out.println(room);
				}
			}
		}
	}


	private static void viewBookingStatus(Users currentUser) {
		System.out.println("Enter Your Booking Id: ");
		System.out.println("\n"+userSer.viewBookingStatus(scan.next()));
		showUserDashboard(currentUser);
		
	}


	private static void bookRoom(Users currentUser) {
		String option = "";
		System.out.println("\nBook Room.\n");
		BookingDetails bookingDetails=new BookingDetails();
		
		System.out.println("Do you have Room Id for Booking: (Y/N)");
		option = scan.next();
		if(option.equals("N")) {
			findHotelByCity(currentUser);
		}else if(option.equals("Y")){
		}else{
			System.out.println("Incorrect Input! Redirecting to Find Hotle By City Name.");
			findHotelByCity(currentUser);
		}
			System.out.println("Enter Room Id.");
			bookingDetails.setRoom_id(scan.next());
			bookingDetails.setUser_id(currentUser.getUser_id());
			System.out.println("Enter Check-In Date. (format: yyyy-mm-dd)");
			bookingDetails.setBooked_from(Date.valueOf(scan.next()));
			System.out.println(bookingDetails.getBooked_from().getTime());
			System.out.println("Enter Check-Out Date. (format: yyyy-mm-dd)");
			bookingDetails.setBooked_to(Date.valueOf(scan.next()));
			System.out.println(bookingDetails.getBooked_to().getTime());
			System.out.println("Enter Number of Adults.");
			bookingDetails.setNo_of_adults(scan.nextInt());
			System.out.println("Enter Number of Children.");
			bookingDetails.setNo_of_children(scan.nextInt());
			
			float avgRate = userSer.amountCalculator(bookingDetails.getBooked_from(), 
					bookingDetails.getBooked_to(), 
					userSer.fetchPerNightRate(bookingDetails.getRoom_id()));
			bookingDetails.setAmount(avgRate);
			bookingDetails=userSer.bookRoom(bookingDetails.getRoom_id(), bookingDetails);
		    System.out.println(bookingDetails);
		showUserDashboard(currentUser);
		
	}


	private static void showAdminDashboard(String user_name) {
		int choice = 0;
		System.out.println("\nWelcome "+user_name);
		System.out.println("\nDASHBOARD");
		System.out.println("1. Add New Hotel.");
		System.out.println("2. Modify Hotel Details.");
		System.out.println("3. Show All Hotels Info.");
		System.out.println("4. Add New Room.");
		System.out.println("5. Update Room Details.");
		System.out.println("6. Delete Room.");
		System.out.println("7. Show bookings for specific date.");
		System.out.println("8. Fetch bookings for specfied hotel.");
		System.out.println("9. Find Guest List for specified hotel.");
		System.out.println("10. Loggout.");
		choice = scan.nextInt();
		
		switch(choice){
		case 1: addNewhotel(user_name);
			break;
		case 2: modifyHotel(user_name);
			break;
		case 3: fetchHotel(user_name);
			break;
		case 4: addNewRooms(user_name);
			break;
		case 5:	updateroomdetail(user_name);
			break;
		case 6:	deleteRoom(user_name);
			break;
		case 7: bookingForSpecificDate(user_name);
			break;
		case 8: bookingForSpecificHotel(user_name);
			break;
		case 9: guestListForHotel(user_name);
			break;
		case 10: loadIndex();
			break;
		default:System.out.println("Invalid Input! Please Try Again.");
		}
	}


	private static void guestListForHotel(String user_name) {
		
	}

	private static void bookingForSpecificHotel(String user_name) {
		String hotel_id = "";
		System.out.println("Enter the Hotel Id"
				+ "\nif u dont have Hotel Id press 1"
				+ "\n to view List of hotels:");
		hotel_id = scan.next();
		if(hotel_id.equals("1")){
			fetchHotel(user_name);
			return;
		}else{
			List<BookingDetails> allbookings = 
				admSer.bookingForSpecificHotel(hotel_id);
			if(allbookings == null){
				System.out.println("there is no bookings for perticular hotel.");
				showAdminDashboard(user_name);
			}
			for(BookingDetails booking: allbookings){
				System.out.println(booking);
				System.out.println();
			}
			showAdminDashboard(user_name);
		}
	}

	private static void bookingForSpecificDate(String user_name) {
		
	}

	private static void deleteRoom(String user_name) {
		System.out.println("Enter Room Id.");
		String room_id = scan.next();
		RoomDetails roomDetails = admSer.searchRoom(room_id);
		if(roomDetails == null){
			System.out.println("Room Id provided is invalid!");
			deleteRoom(user_name);
			return;
		}else{
		admSer.removeRoom(room_id);
		showAdminDashboard(user_name);
		}
	}


	private static void updateroomdetail(String user_name) {
		System.out.println("\nUpdate Room:");
		System.out.print("Enter Room Id For Updation: ");
		RoomDetails roomDetails = admSer.searchRoom(scan.next());
		if(roomDetails == null){
			System.out.println("Room Id provided is invalid!");
			updateroomdetail(user_name);
			return;
		}else{
			int choice = 0;
			System.out.print("Enter Hotel Id: ");
			roomDetails.setHotel_id(scan.next());
			System.out.println("Select Room Type:");
			System.out.println("1. "+AdminDaoImpl.STAN_NON_AC_ROOM+
					"\n2. "+AdminDaoImpl.STAN_AC_ROOM+
					"\n3. "+AdminDaoImpl.EXEC_AC_ROOM+
					"\n4. "+AdminDaoImpl.DELUXE_AC_ROOM);
			switch(choice)
			{
			case 1: roomDetails.setRoom_type(AdminDaoImpl.STAN_NON_AC_ROOM);
				break;
			case 2: roomDetails.setRoom_type(AdminDaoImpl.STAN_AC_ROOM);
				break;
			case 3: roomDetails.setRoom_type(AdminDaoImpl.EXEC_AC_ROOM);
				break;
			case 4: roomDetails.setRoom_type(AdminDaoImpl.DELUXE_AC_ROOM);
				break;
				default: System.out.println("Incorrect Input!");
				           updateroomdetail(user_name);
				           return;
			}
			System.out.print("Enter Per Night Rate: ");
			roomDetails.setPer_night_rate(scan.nextFloat());
			roomDetails.setAvailability(UserDaoImpl.AVAILABLE);
			if(admSer.updateRoomInfo(roomDetails) == 1){
				System.out.println("Room Details Successfully Altered.");
				showAdminDashboard(user_name);
			}
			else{
				System.out.println("Could not alter Information. "
						+ "\nRedirecting to form resubmission");
				updateroomdetail(user_name);
				return;
			}
			
		}
	}


	private static void addNewRooms(String user_name) {
		RoomDetails roomDetails = new RoomDetails();
		int choice = 0;
		System.out.println("Enter Hotel Id.");
		roomDetails.setHotel_id(scan.next());
		System.out.println("Select Room Type.");
		System.out.println("1. "+AdminDaoImpl.STAN_NON_AC_ROOM+
				"\n2. "+AdminDaoImpl.STAN_AC_ROOM+
				"\n3. "+AdminDaoImpl.EXEC_AC_ROOM+
				"\n4. "+AdminDaoImpl.DELUXE_AC_ROOM);
		choice = scan.nextInt();
		switch(choice)
		{
		case 1: roomDetails.setRoom_type(AdminDaoImpl.STAN_NON_AC_ROOM);
			break;
		case 2: roomDetails.setRoom_type(AdminDaoImpl.STAN_AC_ROOM);
			break;
		case 3: roomDetails.setRoom_type(AdminDaoImpl.EXEC_AC_ROOM);
			break;
		case 4: roomDetails.setRoom_type(AdminDaoImpl.DELUXE_AC_ROOM);
			break;
			default: System.out.println("Incorrect Input!");
			           addNewRooms(user_name);
			           return;
		}
		System.out.println("Enter Per Night Rate.");
		roomDetails.setPer_night_rate(scan.nextFloat());
		admSer.updateAvgRate(roomDetails.getHotel_id());
		roomDetails.setAvailability(UserDaoImpl.AVAILABLE);
		if(admSer.addRooms(roomDetails) == 1)
		{
			System.out.println("Room Successfully Added.");
			showAdminDashboard(user_name);
		}
		else
		{
		  System.out.println("Could not add Room ");	
		}
		
	}


	private static void addNewhotel(String user_name) {
		Hotel hotel = new Hotel();
		int rowsAffected = 0;
		System.out.println("\nENTER HOTEL DETAILS.");
		System.out.print("Enter Hotel Name: ");
		scan.nextLine();
		hotel.setHotel_name(scan.nextLine());
		System.out.print("Enter Hotel Address: ");
		hotel.setAddress(scan.nextLine());
		System.out.print("Enter Corresponding City: ");
		hotel.setCity(scan.next());
		System.out.print("Enter Hotel Rating: ");
		hotel.setRating(scan.next());
		System.out.println("Enter Description of Hotel");
		scan.nextLine();
		hotel.setDescription(scan.nextLine());
		System.out.print("Enter Contact Number: \n1: ");
		hotel.setPhone_no(scan.next());
		System.out.print("2: ");
		hotel.setPhone_no2(scan.next());
		System.out.print("Enter Hotel Public Mail: ");
		hotel.setEmail(scan.next());
		System.out.print("Enter Hotel Fax: ");
		hotel.setFax(scan.next());
		rowsAffected = admSer.addNewhotel(hotel);
		if(rowsAffected == 1)	System.out.println("New Hotel Added!");
		else	System.out.println("Invalid Input");
		
		showAdminDashboard(user_name);
		
	}


	private static void modifyHotel(String user_name) {
		System.out.println("Enter Hotel Id");
		String hotelId=scan.next();
		 if(admSer.searchHotel(hotelId) == null){
			 System.out.println("Invalid Hotel Id! Enter Again");
			 modifyHotel(user_name);
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
		 showAdminDashboard(user_name);
	}


	private static void fetchHotel(String user_name) {
		int choice = 0;
		System.out.println("\nGet All Hotel List.");
		List<Hotel> hotelList = admSer.fetchHotelList();
		for(Hotel hotel: hotelList){
			System.out.println(hotel);
		}
		System.out.println("\n1. Go back to Dashboard.   2. Add rooms.");
		choice = scan.nextInt();
		switch(choice){
		case 1:
			showAdminDashboard(user_name);
			break;
		case 2:
			addNewRooms(user_name);
			break;
		default: System.out.println("Invalid Input! Redirecting to DashBoard.");
			showAdminDashboard(user_name);
		}
	}
}


	
	