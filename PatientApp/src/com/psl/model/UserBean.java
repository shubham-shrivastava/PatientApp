package com.psl.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;



@Entity(name="user_table")
@Table(name = "USER_TABLE", uniqueConstraints = {
        @UniqueConstraint(columnNames = "USER_ID"),
        @UniqueConstraint(columnNames = "EMAIL") })
public class UserBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private int id;
	
	@Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
	private String lastName;
	
	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	private String email;
	private String password;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="USER_FACILITY", joinColumns={@JoinColumn(referencedColumnName="USER_ID")}
    , inverseJoinColumns={@JoinColumn(referencedColumnName="FACILITY_ID")})
	private Collection<Facility> facilities = new ArrayList<Facility>();	
	
	@Transient
	private boolean valid;
	@Column(name="ROLE")
	private String role;
	
	@Column(name="STATUS")
	private String status;
	private boolean firstLogin;
	
	public UserBean(String firstName, String lastName, String email, String password, Collection<Facility> facilities,
			boolean valid, String role, String status, boolean firstLogin) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.facilities = facilities;
		this.valid = valid;
		this.role = role;
		this.status = status;
		this.firstLogin = firstLogin;
	}

	public UserBean() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(Collection<Facility> facilities) {
		this.facilities = facilities;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}
	
	
	

}
