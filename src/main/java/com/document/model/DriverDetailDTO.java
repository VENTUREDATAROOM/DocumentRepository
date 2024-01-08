package com.document.model;

public class DriverDetailDTO {

	private Long id;

	private String driverName;

	private String dVechileName;

	private String quantityOfVegetables;

	private int roundCount;

	private String driverArea;

	private String vechileOwnerName;

	private String driverNumber;

	private String userCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

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

}
