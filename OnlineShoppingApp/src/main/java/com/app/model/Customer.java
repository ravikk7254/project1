package com.app.model;

public class Customer {
	

	private String email;
	private String fname;
	private String lname;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [email=" + email + ", fname=" + fname + ", lname=" + lname + ", password=" + password + "]";
	}
	public Customer(String email, String fname, String lname, String password) {
		super();
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
}
