package com.cg.entities;
import java.sql.Date;
public class BookingDetails {

	private String booking_id;
	private String room_id;
	private String user_id;
	private Date booked_from;
	private Date booked_to;
	private Integer no_of_adults;
	private Integer no_of_children;
	private Float amount;
	
	//constructor parameterized and non parameterized....
	public BookingDetails(String booking_id, String room_id, String user_id,
			Date booked_from, Date booked_to, Integer no_of_adults,
			Integer no_of_children, Float amount) {
		super();
		this.booking_id = booking_id;
		this.room_id = room_id;
		this.user_id = user_id;
		this.booked_from = booked_from;
		this.booked_to = booked_to;
		this.no_of_adults = no_of_adults;
		this.no_of_children = no_of_children;
		this.amount = amount;
	}

	public BookingDetails() {
		super();
	}

	//to string function....
	@Override
	public String toString() {
		return "BookingDetails [booking_id=" + booking_id + ", room_id="
				+ room_id + ", user_id=" + user_id + ", booked_from="
				+ booked_from + ", booked_to=" + booked_to + ", no_of_adults="
				+ no_of_adults + ", no_of_children=" + no_of_children
				+ ", amount=" + amount + "]";
	}

	//getters and setters....
	public String getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getBooked_from() {
		return booked_from;
	}

	public void setBooked_from(Date booked_from) {
		this.booked_from = booked_from;
	}

	public Date getBooked_to() {
		return booked_to;
	}

	public void setBooked_to(Date booked_to) {
		this.booked_to = booked_to;
	}

	public Integer getNo_of_adults() {
		return no_of_adults;
	}

	public void setNo_of_adults(Integer no_of_adults) {
		this.no_of_adults = no_of_adults;
	}

	public Integer getNo_of_children() {
		return no_of_children;
	}

	public void setNo_of_children(Integer no_of_children) {
		this.no_of_children = no_of_children;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}
}
