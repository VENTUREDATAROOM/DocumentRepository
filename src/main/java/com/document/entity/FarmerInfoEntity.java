package com.document.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
 
@Entity
@Table(name="delvery_partners")
public class FarmerInfoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	 
	@Column(name="name_of_driver")
	private String driverName;
	
	@Column(name="name_of_transport")
	private String transportname;
	@Column(name="age")
	private int age;
	
	@Column(name="sum_of_amount")
	private Double amountsum;
	
	@Column(name="area_of_working")
	private String workingarea;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="mode_of_connection")
	private String modeofConnection;
	
	@Column(name="working_of_hours")
	private String workingHour;
	
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

	public Double getAmountsum() {
		return amountsum;
	}

	public void setAmountsum(Double amountsum) {
		this.amountsum = amountsum;
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

	@Override
	public String toString() {
		return "FarmerInfoEntity [driverName=" + driverName + ", transportname=" + transportname + ", age=" + age
				+ ", amountsum=" + amountsum + ", workingarea=" + workingarea + ", quantity=" + quantity
				+ ", modeofConnection=" + modeofConnection + ", workingHour=" + workingHour + "]";
	}

	public FarmerInfoEntity(String driverName, String transportname, int age, Double amountsum, String workingarea,
			String quantity, String modeofConnection, String workingHour) {
		super();
		this.driverName = driverName;
		this.transportname = transportname;
		this.age = age;
		this.amountsum = amountsum;
		this.workingarea = workingarea;
		this.quantity = quantity;
		this.modeofConnection = modeofConnection;
		this.workingHour = workingHour;
	}

	public FarmerInfoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}


