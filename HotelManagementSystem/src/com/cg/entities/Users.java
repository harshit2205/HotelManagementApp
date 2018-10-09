package com.cg.entities;

public class Users {

	private String userId;  //user_id
	private String password;  //password
	private String role; //role
	private String userName;  //user_name
	private String mobileNo;  //mobile_no
	private String phone;  //phone
	private String address;  //address
	private String email;  //email
	
	//constructors parameterized and non parameterized constructor....
	public Users(String user_id, String password, String role,
			String user_name, String mobile_no, String phone, String address,
			String email) {
		super();
		this.userId = user_id;
		this.password = password;
		this.role = role;
		this.userName = user_name;
		this.mobileNo = mobile_no;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	public Users() {
		super();
	}

	//to String function.....
	@Override
	public String toString() {
		return "USERNAME " + userName.toUpperCase()+"\n"
				+ "\nmobile_no : " + mobileNo 
				+ "\nphone : " + phone
				+ "\nemail : " + email +"\n";
	}

	public String getUser_id() {
		return userId;
	}

	public void setUser_id(String user_id) {
		this.userId = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUser_name() {
		return userName;
	}

	public void setUser_name(String user_name) {
		this.userName = user_name;
	}

	public String getMobile_no() {
		return mobileNo;
	}

	public void setMobile_no(String mobile_no) {
		this.mobileNo = mobile_no;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
