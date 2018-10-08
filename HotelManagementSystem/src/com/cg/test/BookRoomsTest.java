package com.cg.test;

import java.sql.Date;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.entities.BookingDetails;
import com.cg.exception.BookingsNotFoundException;
import com.cg.exception.RoomsNotFoundException;
import com.cg.service.UserServiceImpl;

public class BookRoomsTest {
  static UserServiceImpl userSer = null;
  static BookingDetails bookingDetails = null;
  
  @BeforeClass
  public static void setUp()
  {
	  userSer=new UserServiceImpl();
	  bookingDetails = new BookingDetails();
      bookingDetails.setBooking_id("dmy");
      bookingDetails.setRoom_id("dmy");
      bookingDetails.setUser_id("dummy");
      bookingDetails.setBooked_from(Date.valueOf("1996-10-15"));
      bookingDetails.setBooked_to(Date.valueOf("1996-10-16"));
      bookingDetails.setNo_of_adults(0);
      bookingDetails.setNo_of_children(0);
      bookingDetails.setAmount(0f);
  }
  @Test
  public void testBookRoom() 
  {
	  
	  try {
		  System.out.println(userSer.viewBookingStatus("dmy"));
		Assert.assertEquals(bookingDetails, userSer.viewBookingStatus("dmy"));
	} catch (BookingsNotFoundException  e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
