package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.OtherPatientDAO;
import com.ecomm.entity.OtherPatient;

public class OtherPatientDAOTest 
{
static OtherPatientDAO otherPatientDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
		otherPatientDAO = (OtherPatientDAO)context.getBean("otherPatientDAO");
	}
	
	@Ignore
	@Test
	public void addOtherPatientTest()
	{
		OtherPatient otherPatient = new OtherPatient();
		
		otherPatient.setPatientId("CP1002");
		otherPatient.setPatientName("Rahul Salunkhe");
		otherPatient.setPatientAge(22);
		otherPatient.setPatientAdmitDate("05-06-2021");
		otherPatient.setRelativeMobNo("8345455353");
		otherPatient.setPatientAddress("Vishwas Nagar Solapur");
		
		assertTrue("Problem occured while adding other patient:",otherPatientDAO.addOtherPatient(otherPatient));

	}
	
	@Ignore
	@Test
	public void updateOtherPatientTest()
	{
		OtherPatient otherPatient = otherPatientDAO.getOtherPatient("CP1001");
		otherPatient.setPatientAdmitDate("02-06-2021");
		otherPatient.setPatientAddress("Vishwas Nagar Solapur");
		
		assertTrue("Propblem occured while updating other patient:",otherPatientDAO.updateOtherPatient(otherPatient));
	}
	
	@Ignore
	@Test
	public void deleteOtherPatientTest()
	{
		OtherPatient otherPatient = otherPatientDAO.getOtherPatient("CP1001");
		
		assertTrue("Problem occured while deleting other patient:",otherPatientDAO.deleteOtherPatient(otherPatient));
	}
	
	@Ignore
	@Test
	public void getOtherPatientsTest()
	{
		List<OtherPatient> otherPatientList = otherPatientDAO.getOtherPatients();
		
		assertTrue("Problem occured while retriving list:",otherPatientList.size()>0);
		
		for(OtherPatient otherPatient:otherPatientList)
		{
			System.out.println("Patient ID : "+otherPatient.getPatientId());
			System.out.println("Patient Name : "+otherPatient.getPatientName());
		}
	}
	
	@Ignore
	@Test
	public void getOtherPatientTest()
	{
		OtherPatient otherPatient = otherPatientDAO.getOtherPatient("CP1001");
		
		System.out.println("Patient ID : "+otherPatient.getPatientId());
		System.out.println("Patient Name : "+otherPatient.getPatientName());
	}
}
