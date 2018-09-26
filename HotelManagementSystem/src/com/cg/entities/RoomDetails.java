package com.cg.entities;

import java.io.File;

public class RoomDetails {

	private String hotel_id;
	private String room_id;
	private String room_no;
	private String room_type;
	private float per_night_rate;
	private int availability;
	private File imageFile;
	
	//constructors parameterized and non parameterized....
	public RoomDetails(String hotel_id, String room_id, String room_no,
			String room_type, float per_night_rate, int availability,
			File imageFile) {
		super();
		this.hotel_id = hotel_id;
		this.room_id = room_id;
		this.room_no = room_no;
		this.room_type = room_type;
		this.per_night_rate = per_night_rate;
		this.availability = availability;
		this.imageFile = imageFile;
	}

	public RoomDetails() {
		super();
	}

	//to String function....
	@Override
	public String toString() {
		return "RoomDetails [hotel_id=" + hotel_id + ", room_id=" + room_id
				+ ", room_no=" + room_no + ", room_type=" + room_type
				+ ", per_night_rate=" + per_night_rate + ", availability="
				+ availability + ", imageFile=" + imageFile + "]";
	}

	//getters and setters.....
	public String getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public float getPer_night_rate() {
		return per_night_rate;
	}

	public void setPer_night_rate(float per_night_rate) {
		this.per_night_rate = per_night_rate;
	}

	public int isAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public File getImageFile() {
		return imageFile;
	}

	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}
	
	
	
}
