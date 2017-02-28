package com.apple.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class iPhone extends AppleDevice {

	@JsonProperty("_id")
	private String id;

	private String serialNumber;

	private Integer cameraMP;

	private Integer price;

	private String mfgYear;

	private Double weight;

	private Double displaySize;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getMfgYear() {
		return mfgYear;
	}

	public void setMfgYear(String mfgYear) {
		this.mfgYear = mfgYear;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(Double displaySize) {
		this.displaySize = displaySize;
	}

	public Integer getCameraMP() {
		return cameraMP;
	}

	public void setCameraMP(Integer cameraMP) {
		this.cameraMP = cameraMP;
	}

}
