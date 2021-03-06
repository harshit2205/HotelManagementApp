package com.cg.entities;
import java.sql.Date;
public class BookingDetails {

	private String bookingId;  //booking_id
	private String roomId;  //room_id
	private String userId;  //user_id
	private Date startDate;   //booked_from 
	private Date endDate;  //booked_to
	private Integer adultCount; //no_of_adults
	private Integer childrenCount; //no_of_children
	private Float amount; //amount
	
	//constructor parameterized and non parameterized....
	public BookingDetails(String booking_id, String room_id, String user_id,
			Date booked_from, Date booked_to, Integer no_of_adults,
			Integer no_of_children, Float amount) {
		super();
		this.bookingId = booking_id;
		this.roomId = room_id;
		this.userId = user_id;
		this.startDate = booked_from;
		this.endDate = booked_to;
		this.adultCount = no_of_adults;
		this.childrenCount = no_of_children;
		this.amount = amount;
	}

	public BookingDetails() {
		super();
	}

	//to string function....
	@Override
	public String toString() {
		return "_____________________________________________________\n"
				+ "Your room is booked with booking Id: "+bookingId
				+"\nBooked From: "+startDate+"  Booked To: "+endDate
				+"\nTotal Amount to be Paid: Rs."+amount
				+"\n_____________________________________________________";
	}
	
	public String showBooking(){
		return "_____________________________________________________\n"
				+ "Booking Id: "+bookingId
				+"\nBooked From: "+startDate+"  Booked To: "+endDate
				+"\nTotal Amount to be Paid: Rs."+amount
				+"\nNo Of Adults: "+adultCount+"\tNo of Children: "+childrenCount
				+"\n_____________________________________________________";
	}

	//getters and setters....
	public String getBooking_id() {
		return bookingId;
	}

	public void setBooking_id(String booking_id) {
		this.bookingId = booking_id;
	}

	public String getRoom_id() {
		return roomId;
	}

	public void setRoom_id(String room_id) {
		this.roomId = room_id;
	}

	public String getUser_id() {
		return userId;
	}

	public void setUser_id(String user_id) {
		this.userId = user_id;
	}

	public Date getBooked_from() {
		return startDate;
	}

	public void setBooked_from(Date booked_from) {
		this.startDate = booked_from;
	}

	public Date getBooked_to() {
		return endDate;
	}

	public void setBooked_to(Date booked_to) {
		this.endDate = booked_to;
	}

	public Integer getNo_of_adults() {
		return adultCount;
	}

	public void setNo_of_adults(Integer no_of_adults) {
		this.adultCount = no_of_adults;
	}

	public Integer getNo_of_children() {
		return childrenCount;
	}

	public void setNo_of_children(Integer no_of_children) {
		this.childrenCount = no_of_children;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}
}
