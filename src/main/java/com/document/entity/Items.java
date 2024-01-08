package com.document.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "basic_details")
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;

	@Column(name = "name")
	private String name;

	@Column(name = "mobile_no")
	private String mobileno;

	@Column(name = "area")
	private String area;

	@Column(name = "Name_of_vegatable")
	private String vegname;

	@Column(name = "eager_to_mandi")
	private String interestedToMandi;

	@Column(name = "expense_on_visits")
	private Double visitingExpenditure;

	@Column(name = "charges_of_broker")
	private Double brokerCharge;

	@Column(name = "tranport_name_with_timing")
	private String transportNameWithTiming;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getVegname() {
		return vegname;
	}

	public void setVegname(String vegname) {
		this.vegname = vegname;
	}

	public String getInterestedToMandi() {
		return interestedToMandi;
	}

	public void setInterestedToMandi(String interestedToMandi) {
		this.interestedToMandi = interestedToMandi;
	}

	public Double getVisitingExpenditure() {
		return visitingExpenditure;
	}

	public void setVisitingExpenditure(Double visitingExpenditure) {
		this.visitingExpenditure = visitingExpenditure;
	}

	public Double getBrokerCharge() {
		return brokerCharge;
	}

	public void setBrokerCharge(Double brokerCharge) {
		this.brokerCharge = brokerCharge;
	}

	public String getTransportNameWithTiming() {
		return transportNameWithTiming;
	}

	public void setTransportNameWithTiming(String transportNameWithTiming) {
		this.transportNameWithTiming = transportNameWithTiming;
	}

	@Override
	public String toString() {
		return "Items [name=" + name + ", mobileno=" + mobileno + ", area=" + area + ", vegname=" + vegname
				+ ", interestedToMandi=" + interestedToMandi + ", visitingExpenditure=" + visitingExpenditure
				+ ", brokerCharge=" + brokerCharge + ", transportNameWithTiming=" + transportNameWithTiming + "]";
	}

	public Items(@NotNull String name, String mobileno, String area, String vegname, String interestedToMandi,
			Double visitingExpenditure, Double brokerCharge, String transportNameWithTiming) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.area = area;
		this.vegname = vegname;
		this.interestedToMandi = interestedToMandi;
		this.visitingExpenditure = visitingExpenditure;
		this.brokerCharge = brokerCharge;
		this.transportNameWithTiming = transportNameWithTiming;
	}

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

}
