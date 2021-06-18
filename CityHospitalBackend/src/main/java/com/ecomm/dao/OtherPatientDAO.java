package com.ecomm.dao;

import java.util.List;

import com.ecomm.entity.OtherPatient;

public interface OtherPatientDAO 
{
	public boolean addOtherPatient(OtherPatient otherPatient);
	public boolean deleteOtherPatient(OtherPatient otherPatient);
	public boolean updateOtherPatient(OtherPatient otherPatient);
	public List<OtherPatient> getOtherPatients();
	public OtherPatient getOtherPatient(String patientId);
}
