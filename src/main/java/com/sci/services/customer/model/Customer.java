/**
 * @author Jaya Prakash Manne
 *
 */
package com.sci.services.customer.model;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
	private static final long serialVersionUID = 2127901216436755353L;
	private Integer customerId;
	private Integer userId;
	private String customerIdNum;
	private String activeFlag;
	private String firstName;
	private String lastName;
	private String middleName;
	private Integer roleId;
	private String email;
	private String phone;
	private String buildingName;
	private String streetName;
	private String city;
	private String state;
	private Date customerDob;
	private LoginInfoBean userLoginInfo;
	
	
	public LoginInfoBean getUserLoginInfo() {
		return userLoginInfo;
	}
	public void setUserLoginInfo(LoginInfoBean userLoginInfo) {
		this.userLoginInfo = userLoginInfo;
	}
	private AddressBean address;
	
	public AddressBean getAddress() {
		return address;
	}
	public Date getCustomerDob() {
		return customerDob;
	}
	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCustomerIdNum() {
		return customerIdNum;
	}
	public void setCustomerIdNum(String customerIdNum) {
		this.customerIdNum = customerIdNum;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
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
	public void setAddress(AddressBean address) {
	this.address = address;
		
	}
}
