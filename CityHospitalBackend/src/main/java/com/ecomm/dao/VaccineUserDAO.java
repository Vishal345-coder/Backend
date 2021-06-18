package com.ecomm.dao;

import com.ecomm.entity.VaccineUser;

public interface VaccineUserDAO 
{
	public boolean registerVaccineUser(VaccineUser vaccineUser);
	public boolean updateVaccineUser(VaccineUser vaccineUser);
	public VaccineUser getVaccineUser(String aadharNumber);
}
