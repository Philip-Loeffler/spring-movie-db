package com.bmdb.business;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String username;
	private String password;
	private String firstName;
	private String lastname;
	private String phoneNumber;
	private String email;
	private double collectionValue;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String username, String password, String firstName, String lastname, String phoneNumber,
			String email, double collectionValue) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.collectionValue = collectionValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getCollectionValue() {
		return collectionValue;
	}

	public void setCollectionValue(double collectionValue) {
		this.collectionValue = collectionValue;
	}
	
	
}
