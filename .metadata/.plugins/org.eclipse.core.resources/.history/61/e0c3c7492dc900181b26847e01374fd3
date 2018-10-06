package com.cg.service;

import java.sql.Date;
import java.util.regex.Pattern;

import com.cg.entities.BookingDetails;
import com.cg.entities.Hotel;
import com.cg.entities.Users;

public class ValidationServiceImpl implements ValidationService
{
	static final String VALIDATED = "Okay";

	@Override
	public String UserValidation(Users user) 
	{
		if(PasswordValidation(user.getPassword()))
		{
			if(NameValidation(user.getUser_name()))
			{
				if(PhoneValidation(user.getPhone()))
				{
					if(PhoneValidation(user.getMobile_no()))
					{
						if(EmailValidation(user.getEmail()))
						{
							return VALIDATED;
						}
						else
						{
							return "Enter a valid Email Address ";
						}
					}
					else
					{
						return "Enter a valid Mobile Number ";
					}
				}

				else
				{
					return "Enter a valid Phone Number ";			 			
				}
			}
			else
			{
				return "Enter name that starts with a capital letter ";
			}
		}
		else
		{
			return "Enter a Valid Password ";
		}
	}
	
	@Override
	public String HotelValidation(Hotel hotel) 
	{
		if(EmailValidation(hotel.getEmail()))
		{
			if(PhoneValidation(hotel.getPhone_no()))
			{
				if(PhoneValidation(hotel.getPhone_no()))
				{
					if(NameValidation(hotel.getHotel_name()))
					{
						return VALIDATED;
					}
					else
					{
						return "Enter name that starts with a capital letter";
					}
				}
				else
				{
					return "Enter a valid Phone Number ";
				}
			}
			else
			{
				return "Enter a valid Phone Number ";
			}
		}
		else
		{
			return "Enter a valid Email Address";
		}
	}

	@Override
	public String BookingDetailsValidation(BookingDetails bookD)
	{
		if(DatesValidation(bookD.getBooked_from(),bookD.getBooked_to()))
		{
			if(DateValidation(bookD.getBooked_from()))
			{
				if(PersonsValidation(bookD.getNo_of_adults(), bookD.getNo_of_children()))
				{
					return VALIDATED;
				}
				else
				{
					return "Number of persons limit exceeded";
				}
			}
			else
			{
				return "The date is older than current day";
			}
		}
		else
		{
			return "The 'TO' date is older than booked 'FROM' date";
		}
	}


	//these are generic functions for validation....

	public boolean PasswordValidation(String str)
	{
		String pswdPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
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

	public boolean NameValidation(String str)
	{
		String namePattern = "[A-Z][a-z]{1,20}";
		if(Pattern.matches(namePattern,str))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean PhoneValidation(String str)
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

	public boolean EmailValidation(String str)
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

	public boolean DateValidation(Date date)
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

	public boolean DatesValidation(Date from_date,Date to_date)
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
	
	public boolean PersonsValidation(int adult,int children)
	{
		int sum=adult+children;
		if(sum>=0 && sum <3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
}

