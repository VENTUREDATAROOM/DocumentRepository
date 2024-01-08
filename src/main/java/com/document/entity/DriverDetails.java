package com.document.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driver_details_with_vechile")
public class DriverDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "driver_id")
	private Long driverId;

	@Column(name = "driver_name")
	private String driverName;

	@Column(name = "driver_vechile_name")
	private String dVechileName;

	@Column(name = "quantity_of_vegetable")
	private String quantityOfVegetables;

	@Column(name = "no_of_count")
	private int roundCount;

	@Column(name = "area_of_driver")
	private String driverArea;

	@Column(name = "vechile_owner_name")
	private String vechileOwnerName;

	@Column(name = "driver_ph_no")
	private String driverNumber;

	@Column(name = "user_code")
	private String userCode;

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getdVechileName() {
		return dVechileName;
	}

	public void setdVechileName(String dVechileName) {
		this.dVechileName = dVechileName;
	}

	public String getQuantityOfVegetables() {
		return quantityOfVegetables;
	}

	public void setQuantityOfVegetables(String quantityOfVegetables) {
		this.quantityOfVegetables = quantityOfVegetables;
	}

	public int getRoundCount() {
		return roundCount;
	}

	public void setRoundCount(int roundCount) {
		this.roundCount = roundCount;
	}

	public String getDriverArea() {
		return driverArea;
	}

	public void setDriverArea(String driverArea) {
		this.driverArea = driverArea;
	}

	public String getVechileOwnerName() {
		return vechileOwnerName;
	}

	public void setVechileOwnerName(String vechileOwnerName) {
		this.vechileOwnerName = vechileOwnerName;
	}

	public String getDriverNumber() {
		return driverNumber;
	}

	public void setDriverNumber(String driverNumber) {
		this.driverNumber = driverNumber;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Override
	public String toString() {
		return "DriverDetails [driverName=" + driverName + ", dVechileName=" + dVechileName + ", quantityOfVegetables="
				+ quantityOfVegetables + ", roundCount=" + roundCount + ", driverArea=" + driverArea
				+ ", vechileOwnerName=" + vechileOwnerName + ", driverNumber=" + driverNumber + ", userCode=" + userCode
				+ "]";
	}

	public DriverDetails(String driverName, String dVechileName, String quantityOfVegetables, int roundCount,
			String driverArea, String vechileOwnerName, String driverNumber, String userCode) {
		super();
		this.driverName = driverName;
		this.dVechileName = dVechileName;
		this.quantityOfVegetables = quantityOfVegetables;
		this.roundCount = roundCount;
		this.driverArea = driverArea;
		this.vechileOwnerName = vechileOwnerName;
		this.driverNumber = driverNumber;
		this.userCode = userCode;
	}

	public DriverDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
