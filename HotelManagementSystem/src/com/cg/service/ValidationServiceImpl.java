package com.cg.service;

import java.sql.Date;
import java.util.regex.Pattern;


public class ValidationServiceImpl implements ValidationService
{
	AdminServiceImpl admSer = null;
	public ValidationServiceImpl() {
		admSer = new AdminServiceImpl();
	}

	
	//these are generic functions for validation....
	@Override
	public boolean passwordValidation(String str)
	{
		String pswdPattern = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
		/*(?=.*[0-9])= a digit must occur at least once
			(?=.*[a-z])= a lower case letter must occur at least once
			(?=.*[A-Z])= an upper case letter must occur at least once
			(?=.*[@#$%^&+=])= a special character must occur at least once
			(?=\\S+$) =no whitespace allowed in the entire string
			.{8,}= at least 8 characters*/
		if(Pattern.matches(pswdPattern,str))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public boolean userNameValidation(String str)
	{
		String namePattern = "[A-Z][a-z]{1,20}";
		if(Pattern.matches(namePattern,str)){
			if(admSer.searchUser(str)) return false;
			else return true;
		}else return false;
	}

	@Override
	public boolean phoneValidation(String str)
	{
		String PhonePattern = "[0-9]{10}";
		if(Pattern.matches(PhonePattern,str))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean emailValidation(String str)
	{
		String EmailPattern = "[a-zA-Z0-9._%+-]+@[A-Za-z]+[.][A-Za-z]{1,3}";
		if(Pattern.matches(EmailPattern,str))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean dateValidation(Date date)
	{
		Date user_date = date;
		long Day = System.currentTimeMillis();
		Date c_date = new Date(Day);
		if(user_date.before(c_date))
		{
			return false;
		} 
		else 
		{
			return true;
		}

	}

	@Override
	public boolean datesValidation(Date from_date,Date to_date)
	{
		if(to_date.before(from_date))
		{
			return false;
		} 
		else 
		{
			return true;
		}

	}
	
	@Override
	public boolean personsValidation(int adult,int children)
	{
		int sum=adult+children;
		if(sum>=0 && sum <=3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean priceValidation(Float price)
	{
		if(price<0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}


	@Override
	public boolean cityValidation(String city) {
		String cityNamePattern = "[A-Z][a-z]{1,20}";
		if(Pattern.matches(cityNamePattern,city)){
			return true;
		}else return false;
	}


	@Override
	public boolean ratingValidation(int rating) {
		if(rating>=0 && rating<=5){
			return true;
		}
		return false;
	}

	
}

