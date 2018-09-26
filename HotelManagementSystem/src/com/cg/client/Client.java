package com.cg.client;

import java.util.Scanner;

import com.cg.entities.Hotel;
import com.cg.service.AdminService;
import com.cg.service.AdminServiceImpl;

public class Client {
static AdminService admSer=null;;
	public static void main(String[] args) {
		System.out.println("hello world");
		admSer=new AdminServiceImpl();
		Client.addHotel();
	}

private static void addHotel()
{
	 Scanner sc=new Scanner(System.in);
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
	 hotel_id=sc.next();
	 city=sc.next();
	 hotel_name=sc.next();
	 address=sc.next();
	 description=sc.next();
	 avg_rate_per_night=sc.nextFloat();
	 phone_no=sc.next();
	 phone_no2=sc.next();
	 rating=sc.next();
	 email=sc.next();
	 fax=sc.next();
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

