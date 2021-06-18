package com.ecomm.dao;

import java.util.List;

import com.ecomm.entity.CoronaPatient;

public interface CoronaPatientDAO 
{
	public boolean addCoronaPatient(CoronaPatient coronaPatient);
	public boolean deleteCoronaPatient(CoronaPatient coronaPatient);
	public boolean updateCoronaPatient(CoronaPatient coronaPatient);
	public List<CoronaPatient> getCoronaPatients();
	public CoronaPatient getCoronaPatient(String patientId);
}
