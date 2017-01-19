package com.psl.model;


import java.util.Date;
import javax.persistence.*;


public class Patient {
	

	private int id;
	private String firstName;	
	private String lastName;	
	private Date admitDate;
	private Date dischargeDate;
	private String deleted;
	private Facility facility;
	
	public Patient(String firstName, String lastName, Date admitDate, Date dischargeDate, String deleted,
			Facility facility) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.admitDate = admitDate;
		this.dischargeDate = dischargeDate;
		this.deleted = deleted;
		this.facility = facility;
	}

	public Patient() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(Date admitDate) {
		this.admitDate = admitDate;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}	
	
}