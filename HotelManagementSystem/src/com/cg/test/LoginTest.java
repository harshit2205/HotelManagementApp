package com.cg.test;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.entities.Users;
import com.cg.exception.UserNotFoundException;
import com.cg.service.UserServiceImpl;

public class LoginTest {
	static UserServiceImpl userSer = null;
	static Users dummyUser = null;
	
	
	@BeforeClass
	public static void setUp()
	{
		userSer = new UserServiceImpl();
		dummyUser = new Users();
		dummyUser.setUser_id("dummy");
		dummyUser.setPassword("dummy");
		dummyUser.setRole("user");
		dummyUser.setUser_name("Dummy");
		dummyUser.setMobile_no("0000000000");
		dummyUser.setPhone("0000000000");
		dummyUser.setAddress("dummy");
		dummyUser.setEmail("dummy@dummy.com");
   	
	}
	
    @Test
    public void testDummyLogin()
    { 
    	try {
			Assert.assertEquals(dummyUser, userSer.LoginUser("Dummy", "dummy"));
		} catch (UserNotFoundException e) {
			System.out.println(e);
		}
    }
    @Test(expected = UserNotFoundException.class)
    public void testInvalidLogin() throws UserNotFoundException
    {
    	Assert.assertEquals(dummyUser, userSer.LoginUser("test", "test123"));
    }
    
}
