package com.ecomm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CoronaPatient 
{
	@Id
	String patientId;
	
	String patientName;
	int patientAge;
	String patientAdmitDate;
	String relativeMobNo;
	String patientAddress;
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientAdmitDate() {
		return patientAdmitDate;
	}
	public void setPatientAdmitDate(String patientAdmitDate) {
		this.patientAdmitDate = patientAdmitDate;
	}
	public String getRelativeMobNo() {
		return relativeMobNo;
	}
	public void setRelativeMobNo(String relativeMobNo) {
		this.relativeMobNo = relativeMobNo;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
}
