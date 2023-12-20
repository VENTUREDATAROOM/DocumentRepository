package com.document.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "API_USERS")

public class GdmsApiUsers {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "FLG_OF_USER")
	private String flgOfUser;
	@Column(name = "DATE_OF_USERCREATION")
	private LocalDate dateOfCreation;
	@Id
	@Column(name = "mobile_no")
	private String mobileNo;// mobile no
	@Column(name = "email")
	private String email;
	@Column(name="aadhar_no")
	private String aadharNumber;
	@Column(name = "user_status")
	private String userstatus;// email
	@Column(name="company_name")
	private String companyName;// company name
	

	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFlgOfUser() {
		return flgOfUser;
	}

	public void setFlgOfUser(String flgOfUser) {
		this.flgOfUser = flgOfUser;
	}

	public LocalDate getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(LocalDate dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getCompanyName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCompanyName(String companyName) {
		// TODO Auto-generated method stub
		this.companyName=companyName;
	}
	public String getAadharNumber()
	{
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

}
