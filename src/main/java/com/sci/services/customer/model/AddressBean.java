/**
 * @author Jaya Prakash Manne
 *
 */
package com.sci.services.customer.model;

import java.io.Serializable;

public class AddressBean implements Serializable {
	private static final long serialVersionUID = 1008629583153330455L;
	private Integer addressDetailsId;
	private String buildingName;
	private String street;
	private String city;
	private String state;
	private String activeFlag;
	
	public Integer getAddressDetailsId() {
		return addressDetailsId;
	}
	public void setAddressDetailsId(Integer addressDetailsId) {
		this.addressDetailsId = addressDetailsId;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
}
