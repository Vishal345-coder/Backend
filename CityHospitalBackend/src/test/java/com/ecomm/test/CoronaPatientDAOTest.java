package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CoronaPatientDAO;
import com.ecomm.entity.CoronaPatient;

public class CoronaPatientDAOTest 
{	
	static CoronaPatientDAO coronaPatientDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
		coronaPatientDAO = (CoronaPatientDAO)context.getBean("coronaPatientDAO");
	}
	
		@Ignore
		@Test
		public void addCoronaPatientTest()
		{
			CoronaPatient coronaPatient = new CoronaPatient();
			
			coronaPatient.setPatientId("CP1002");
			coronaPatient.setPatientName("Vinod Bhange");
			coronaPatient.setPatientAge(45);
			coronaPatient.setPatientAdmitDate("02-04-2021");
			coronaPatient.setRelativeMobNo("8390655252");
			coronaPatient.setPatientAddress("Gandhi Nagar Solapur");
			
			assertTrue("Problem occured while adding corona patient:",coronaPatientDAO.addCoronaPatient(coronaPatient));
		}
		
		@Ignore
		@Test
		public void updateCoronaPatientTest()
		{
			CoronaPatient coronaPatient = coronaPatientDAO.getCoronaPatient("CP1002");
			coronaPatient.setPatientAdmitDate("01-04-2021");
			coronaPatient.setPatientAddress("Sat Rasta Solapur");
			
			assertTrue("Propblem occured while updating corona patient:",coronaPatientDAO.updateCoronaPatient(coronaPatient));
		}
		
		@Ignore
		@Test
		public void deleteCoronaPatientTest()
		{
			CoronaPatient coronaPatient = coronaPatientDAO.getCoronaPatient("CP1002");
			
			assertTrue("Problem occured while deleting corona patient:",coronaPatientDAO.deleteCoronaPatient(coronaPatient));
		}
		
		@Ignore
		@Test
		public void getCoronaPatientsTest()
		{
			List<CoronaPatient> coronaPatientList = coronaPatientDAO.getCoronaPatients();
			
			assertTrue("Problem occured while retriving list:",coronaPatientList.size()>0);
			
			for(CoronaPatient coronaPatient:coronaPatientList)
			{
				System.out.println("Patient ID : "+coronaPatient.getPatientId());
				System.out.println("Patient Name : "+coronaPatient.getPatientName());
			}
		}
		
		@Ignore
		@Test
		public void getCoronaPatientTest()
		{
			CoronaPatient coronaPatient = coronaPatientDAO.getCoronaPatient("CP1001");
			
			System.out.println("Patient ID : "+coronaPatient.getPatientId());
			System.out.println("Patient Name : "+coronaPatient.getPatientName());
		}
}
