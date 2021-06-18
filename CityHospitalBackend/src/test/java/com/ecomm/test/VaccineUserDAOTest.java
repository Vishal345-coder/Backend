package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.VaccineUserDAO;
import com.ecomm.entity.VaccineUser;

public class VaccineUserDAOTest 
{
	static VaccineUserDAO vaccineUserDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
	    vaccineUserDAO = (VaccineUserDAO)context.getBean("vaccineUserDAO");
	}
	
	@Ignore
	@Test
	public void registerVaccineUser()
	{
		VaccineUser vaccineUser = new VaccineUser();
		
		vaccineUser.setAadharNumber("916867686756");
		vaccineUser.setName("Vishal Gaikwad");
		vaccineUser.setMobNumber("8390655053");
		vaccineUser.setLocation("Mohol");
		vaccineUser.setVaccine("Covishield");
				
		assertTrue("Problem Occured while Registering User for Vaccination : ",vaccineUserDAO.registerVaccineUser(vaccineUser));
	}

}
