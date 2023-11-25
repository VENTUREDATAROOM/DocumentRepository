package com.document.model;

public class VegetableDetailsDTO2 {

	public Long vegId;

	private String vegetableName;

	// private MultipartFile image;

	private String[] pic;
	private String timeperiod;

	private String vegetableValidity;

	private String coldStorageRequirement;

	private String kahaSetAtiHai;

	private String availability;

	private String userCode;

	public String[] getPic() {
		return pic;
	}

	public void setPic(String[] pic) {
		this.pic = pic;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Long getVegId() {
		return vegId;
	}

	public void setVegId(Long vegId) {
		this.vegId = vegId;
	}

	public String getVegetableName() {
		return vegetableName;
	}

	public void setVegetableName(String vegetableName) {
		this.vegetableName = vegetableName;
	}

	public String getTimeperiod() {
		return timeperiod;
	}

	public void setTimeperiod(String timeperiod) {
		this.timeperiod = timeperiod;
	}

	public String getVegetableValidity() {
		return vegetableValidity;
	}

	public void setVegetableValidity(String vegetableValidity) {
		this.vegetableValidity = vegetableValidity;
	}

	public String getColdStorageRequirement() {
		return coldStorageRequirement;
	}

	public void setColdStorageRequirement(String coldStorageRequirement) {
		this.coldStorageRequirement = coldStorageRequirement;
	}

	public String getKahaSetAtiHai() {
		return kahaSetAtiHai;
	}

	public void setKahaSetAtiHai(String kahaSetAtiHai) {
		this.kahaSetAtiHai = kahaSetAtiHai;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	/*
	 * public MultipartFile getImage() { return image; }
	 *
	 * public void setImage(MultipartFile image) { this.image = image; }
	 *
	 * public byte[] getPic() { return pic; }
	 *
	 * public void setPic(byte[] pic) { this.pic = pic; }
	 */

}
