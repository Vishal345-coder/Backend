package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.entity.OtherPatient;

@Repository("otherPatientDAO")
@Transactional
public class OtherPatientDAOImpl implements OtherPatientDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addOtherPatient(OtherPatient otherPatient) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(otherPatient);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deleteOtherPatient(OtherPatient otherPatient) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(otherPatient);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean updateOtherPatient(OtherPatient otherPatient) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(otherPatient);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<OtherPatient> getOtherPatients() 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from OtherPatient");
		List<OtherPatient> otherPatientList = query.list();
		session.close();
		return otherPatientList;
	}

	@Override
	public OtherPatient getOtherPatient(String patientId) 
	{
		Session session = sessionFactory.openSession();
		OtherPatient otherPatient = (OtherPatient)session.get(OtherPatient.class, patientId);
		session.close();
		return otherPatient;
	}
}
