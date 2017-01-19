package com.psl.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity(name="facility")
@Table(name="facility",  uniqueConstraints = {
        @UniqueConstraint(columnNames = "FACILITY_ID")})
public class Facility {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FACILITY_ID", unique=true, nullable=false)
	private int id;	
	@Column(name = "NAME", unique = false, nullable = false, length = 100)
	private String name;
	@Column(name = "ADDRESS", unique = false, nullable = false)
	private String address;
	@Column(name = "CITY", unique = false, nullable = false, length = 100)
	private String city;
	@Column(name = "STATE", unique = false, nullable = false, length = 100)
	private String state;
	@Column(name = "ZIP", unique = false, nullable = false, length = 100)
	private String zip;
	
	@ManyToMany(mappedBy="facilities")
	private List<UserBean> users = new ArrayList<>();
	
	
	public Facility() {
		super();
	}

	public Facility(String name, String address, String city, String state, String zip, List<UserBean> users) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.users = users;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<UserBean> getUsers() {
		return users;
	}

	public void setUsers(List<UserBean> users) {
		this.users = users;
	}

	
	
	
	
}