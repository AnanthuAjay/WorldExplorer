package com.ust.user.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String name;
	private String emailaddress;
	private String username;
	private String password;
	private String confirmpassword;
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
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
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
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public User(String name, String emailaddress, String username, String password, String confirmpassword) {
		super();
		this.name = name;
		this.emailaddress = emailaddress;
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}
	
	public User() {
		super();
	}
	
}
