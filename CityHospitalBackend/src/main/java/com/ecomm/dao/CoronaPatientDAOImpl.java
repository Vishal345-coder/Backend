package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.entity.CoronaPatient;

@Repository("coronaPatientDAO")
@Transactional
public class CoronaPatientDAOImpl implements CoronaPatientDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCoronaPatient(CoronaPatient coronaPatient) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(coronaPatient);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deleteCoronaPatient(CoronaPatient coronaPatient) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(coronaPatient);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean updateCoronaPatient(CoronaPatient coronaPatient) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(coronaPatient);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<CoronaPatient> getCoronaPatients() 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CoronaPatient");
		List<CoronaPatient> coronaPatientList = query.list();
		session.close();
		return coronaPatientList;
	}

	@Override
	public CoronaPatient getCoronaPatient(String patientId) 
	{
		Session session = sessionFactory.openSession();
		CoronaPatient coronaPatient = (CoronaPatient)session.get(CoronaPatient.class, patientId);
		session.close();
		return coronaPatient;
	}
}
