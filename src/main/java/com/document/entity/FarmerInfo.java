package com.document.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farmer_info_with_veg")
public class FarmerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "farmer_id")
	private int farmerId;

	@Column(name = "user_code")
	private String userCode;

	@Column(name = "farmer_name")
	private String farmerName;

	@Column(name = "farmer_phone_no")
	private String phoneNumber;

	@Column(name = "selling_area")
	private String area;

	@Column(name = "current_vegetable")
	private String vegCurntCarrying;

	@Column(name = "quantity_of_vegetable")
	private String vegetableQuantity;

	@Column(name = "mandi_distance")
	private String distanceFromMandi;

	@Column(name = "name_of_transport")
	private String transportName;

	@Column(name = "counts_of_visits")
	private int farmerVisitingCount;

	@Column(name = "area_of_selling")
	private String sellingArea;

	@Column(name = "mandi_name")
	private String nameOfMandi;

	@Column(name = "vegetable_variety")
	private String varietyOfVegetables;

	@Column(name = "given_commision_by_farmer")
	private String amountOfCommision;

	@Column(name = "type_one_question")
	private String quest1;

	@Column(name = "type_two_question")
	private String quest2;

	@Column(name = "type_three_question")
	private String quest3;

	@Column(name = "type_four_question")
	private String quest4;

	public int getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getVegCurntCarrying() {
		return vegCurntCarrying;
	}

	public void setVegCurntCarrying(String vegCurntCarrying) {
		this.vegCurntCarrying = vegCurntCarrying;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getVegetableQuantity() {
		return vegetableQuantity;
	}

	public void setVegetableQuantity(String vegetableQuantity) {
		this.vegetableQuantity = vegetableQuantity;
	}

	public String getTransportName() {
		return transportName;
	}

	public void setTransportName(String transportName) {
		this.transportName = transportName;
	}

	public String getDistanceFromMandi() {
		return distanceFromMandi;
	}

	public void setDistanceFromMandi(String distanceFromMandi) {
		this.distanceFromMandi = distanceFromMandi;
	}

	public int getFarmerVisitingCount() {
		return farmerVisitingCount;
	}

	public void setFarmerVisitingCount(int farmerVisitingCount) {
		this.farmerVisitingCount = farmerVisitingCount;
	}

	public String getSellingArea() {
		return sellingArea;
	}

	public void setSellingArea(String sellingArea) {
		this.sellingArea = sellingArea;
	}

	public String getNameOfMandi() {
		return nameOfMandi;
	}

	public void setNameOfMandi(String nameOfMandi) {
		this.nameOfMandi = nameOfMandi;
	}

	public String getVarietyOfVegetables() {
		return varietyOfVegetables;
	}

	public void setVarietyOfVegetables(String varietyOfVegetables) {
		this.varietyOfVegetables = varietyOfVegetables;
	}

	public String getAmountOfCommision() {
		return amountOfCommision;
	}

	public void setAmountOfCommision(String amountOfCommision) {
		this.amountOfCommision = amountOfCommision;
	}

	public String getQuest1() {
		return quest1;
	}

	public void setQuest1(String quest1) {
		this.quest1 = quest1;
	}

	public String getQuest2() {
		return quest2;
	}

	public void setQuest2(String quest2) {
		this.quest2 = quest2;
	}

	public String getQuest3() {
		return quest3;
	}

	public void setQuest3(String quest3) {
		this.quest3 = quest3;
	}

	public String getQuest4() {
		return quest4;
	}

	public void setQuest4(String quest4) {
		this.quest4 = quest4;
	}

	@Override
	public String toString() {
		return "FarmerInfo [phoneNumber=" + phoneNumber + ", area=" + area + ", vegetableQuantity=" + vegetableQuantity
				+ ", transportName=" + transportName + ", distanceFromMandi=" + distanceFromMandi
				+ ", farmerVisitingCount=" + farmerVisitingCount + ", sellingArea=" + sellingArea + ", nameOfMandi="
				+ nameOfMandi + ", varietyOfVegetables=" + varietyOfVegetables + ", amountOfCommision="
				+ amountOfCommision + ", quest1=" + quest1 + ", quest2=" + quest2 + ", quest3=" + quest3 + ", quest4="
				+ quest4 + "]";
	}

	public FarmerInfo(String phoneNumber, String area, String vegetableQuantity, String transportName,
			String distanceFromMandi, int farmerVisitingCount, String sellingArea, String nameOfMandi,
			String varietyOfVegetables, String amountOfCommision, String quest1, String quest2, String quest3,
			String quest4) {
		super();
		this.phoneNumber = phoneNumber;
		this.area = area;
		this.vegetableQuantity = vegetableQuantity;
		this.transportName = transportName;
		this.distanceFromMandi = distanceFromMandi;
		this.farmerVisitingCount = farmerVisitingCount;
		this.sellingArea = sellingArea;
		this.nameOfMandi = nameOfMandi;
		this.varietyOfVegetables = varietyOfVegetables;
		this.amountOfCommision = amountOfCommision;
		this.quest1 = quest1;
		this.quest2 = quest2;
		this.quest3 = quest3;
		this.quest4 = quest4;
	}

	public FarmerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
