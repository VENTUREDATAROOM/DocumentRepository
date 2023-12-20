package com.document.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	
	private String Email;
	private String password;
	
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public JwtRequest( String email, String password) {
		
		this.setEmail(email);
		this.setPassword(password);
		
	}

	

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}