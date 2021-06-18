package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserDetailDAO;
import com.ecomm.entity.UserDetail;

public class UserDetailDAOTest 
{
	static UserDetailDAO userDetailDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
		userDetailDAO=(UserDetailDAO)context.getBean("userDetailDAO");
	}
	
	@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail user = new UserDetail();
		
		user.setUsername("Madhav");
		user.setName("Madhav Raul");
		user.setGender("Male");
		user.setContactNumber("9168114086");
		user.setEmailId("madhav@gmail.com");
		user.setAddress("Solapur");
		user.setEnabled(true);
		user.setPassword("12345");
		user.setrPassword("12345");
		user.setRole("ROLE_DOCTOR");
		
		assertTrue("Problem occured while Registering User:",userDetailDAO.registerUser(user));	
	}
}
