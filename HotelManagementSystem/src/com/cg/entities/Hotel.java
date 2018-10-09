package com.cg.entities;

public class Hotel {

	private String hotelId; //hotel_id
	private String city;  //city
	private String hotelName; //hotel_name
	private String address; //address
	private String description; //description
	private float avgRatePerNight; //avg_rate_per_night
	private String phoneNo; //phone_no
	private String phoneNo2; //phone_no2
	private String rating; //rating
	private String email; //email
	private String fax; //fax
	
	//constructor parameterized and non parameterized...
	public Hotel(String hotel_id, String city, String hotel_name,
			String address, String description, float avg_rate_per_night,
			String phone_no, String phone_no2, String rating, String email,
			String fax) {
		super();
		this.hotelId = hotel_id;
		this.city = city;
		this.hotelName = hotel_name;
		this.address = address;
		this.description = description;
		this.avgRatePerNight = avg_rate_per_night;
		this.phoneNo = phone_no;
		this.phoneNo2 = phone_no2;
		this.rating = rating;
		this.email = email;
		this.fax = fax;
	}

	public Hotel() {
		super();
	}

	//to string function....
	@Override
	public String toString() {
		
		
		
		
		
		return  "________________________________________________________________________________"
				+ "\nHotel Id: "+hotelId+"  Hotel Name: "+hotelName.toUpperCase()
				+ "\nAddress: "+address+"\t City: "+city
				+ "\nDescription:\n"+description
				+ "\nRating: "+rating+ " Star"+"\n"+phoneNo+"\t|\t"+phoneNo2
				+ "\nEmail: "+email+"\tFax: "+fax+"\n"
				+ "________________________________________________________________________________";
		 
	}

	//getter and setter functions....
	public String getHotel_id() {
		return hotelId;
	}

	public void setHotel_id(String hotel_id) {
		this.hotelId = hotel_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotel_name() {
		return hotelName;
	}

	public void setHotel_name(String hotel_name) {
		this.hotelName = hotel_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAvg_rate_per_night() {
		return avgRatePerNight;
	}

	public void setAvg_rate_per_night(float avg_rate_per_night) {
		this.avgRatePerNight = avg_rate_per_night;
	}

	public String getPhone_no() {
		return phoneNo;
	}

	public void setPhone_no(String phone_no) {
		this.phoneNo = phone_no;
	}

	public String getPhone_no2() {
		return phoneNo2;
	}

	public void setPhone_no2(String phone_no2) {
		this.phoneNo2 = phone_no2;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
	
	
	
}
