package com.document.model;

 

public class DeliveryPartnerDTO {

 
	public int id;
	 
	private String driverName;
	 
	private String transportname;
	 
	private int age;
	
	private Double amountsum;
	
	private String workingarea;
	 
	private String quantity;
	 
	private String modeofConnection;
	
	private String workingHour;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getTransportname() {
		return transportname;
	}

	public void setTransportname(String transportname) {
		this.transportname = transportname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Double getAmountsum() {
		return amountsum;
	}

	public void setAmountsum(Double amountsum) {
		this.amountsum = amountsum;
	}


	public String getWorkingarea() {
		return workingarea;
	}


	public void setWorkingarea(String workingarea) {
		this.workingarea = workingarea;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getModeofConnection() {
		return modeofConnection;
	}


	public void setModeofConnection(String modeofConnection) {
		this.modeofConnection = modeofConnection;
	}


	public String getWorkingHour() {
		return workingHour;
	}


	public void setWorkingHour(String workingHour) {
		this.workingHour = workingHour;
	}
	
}
