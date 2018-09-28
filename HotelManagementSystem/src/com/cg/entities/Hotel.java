package com.cg.entities;

public class Hotel {

	private String hotel_id;
	private String city;
	private String hotel_name;
	private String address;
	private String description;
	private float avg_rate_per_night;
	private String phone_no;
	private String phone_no2;
	private String rating;
	private String email;
	private String fax;
	
	//constructor parameterized and non parameterized...
	public Hotel(String hotel_id, String city, String hotel_name,
			String address, String description, float avg_rate_per_night,
			String phone_no, String phone_no2, String rating, String email,
			String fax) {
		super();
		this.hotel_id = hotel_id;
		this.city = city;
		this.hotel_name = hotel_name;
		this.address = address;
		this.description = description;
		this.avg_rate_per_night = avg_rate_per_night;
		this.phone_no = phone_no;
		this.phone_no2 = phone_no2;
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
		return   hotel_id + "\t" + hotel_name.toUpperCase() + "\n" + address
				+ "\t " + city + "\n About = " + description + "\n\nRs. "
				+ avg_rate_per_night + "/pernight \t Contact No. " + phone_no
				+ " " + phone_no2 + "\n This Hotel is Rated " + rating
				+ "Star \t email = " + email + ",\n fax = " + fax+"\n" ;
		 
	}

	//getter and setter functions....
	public String getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
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
		return avg_rate_per_night;
	}

	public void setAvg_rate_per_night(float avg_rate_per_night) {
		this.avg_rate_per_night = avg_rate_per_night;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getPhone_no2() {
		return phone_no2;
	}

	public void setPhone_no2(String phone_no2) {
		this.phone_no2 = phone_no2;
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
