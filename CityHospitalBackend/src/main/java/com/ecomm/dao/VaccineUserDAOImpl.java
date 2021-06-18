package com.ecomm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.entity.VaccineUser;

@Repository("vaccineUserDAO")
@Transactional
public class VaccineUserDAOImpl implements VaccineUserDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerVaccineUser(VaccineUser vaccineUser) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(vaccineUser);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean updateVaccineUser(VaccineUser vaccineUser) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(vaccineUser);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public VaccineUser getVaccineUser(String aadharNumber) 
	{
		Session session = sessionFactory.openSession();
		VaccineUser vaccineUser = (VaccineUser)session.get(VaccineUser.class,aadharNumber);
		session.close();
		return vaccineUser;
	}
}
