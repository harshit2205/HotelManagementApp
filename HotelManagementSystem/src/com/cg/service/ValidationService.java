package com.cg.service;

import java.sql.Date;


public interface ValidationService 
{
	public boolean passwordValidation(String str);
	public boolean userNameValidation(String str);
	public boolean phoneValidation(String str);
	public boolean emailValidation(String str);
	public boolean dateValidation(Date date);
	public boolean datesValidation(Date from_date,Date to_date);
	public boolean personsValidation(int adult,int children);
	public boolean priceValidation(Float price);
	public boolean cityValidation(String city);
	public boolean ratingValidation(int rating);
}
