/**
 * @author Jaya Prakash Manne
 *
 */
package com.sci.services.customer.model;

import java.io.Serializable;

public class CustomerDetails implements Serializable{
	private static final long serialVersionUID = 3488725287289742313L;
	private Integer userId;
	private String firstName; 
	private String lastName; 
	private String middleName; 
	private String activeFlag; 
	
	private Integer userLoginId;
	private Integer roleId;
	private String username;
	private String password;
	
	private AddressBean address;
	
	private Integer userDetailsId;
	private String email;
	private String phone;
	private String fax;
	
	private Integer customerId;
	private String customerDOB;
	private String customerIdNumber;
	private String customerActiveFlag;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public Integer getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(Integer userLoginId) {
		this.userLoginId = userLoginId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
	}
	public Integer getUserDetailsId() {
		return userDetailsId;
	}
	public void setUserDetailsId(Integer userDetailsId) {
		this.userDetailsId = userDetailsId;
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
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerDOB() {
		return customerDOB;
	}
	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}
	public String getCustomerIdNumber() {
		return customerIdNumber;
	}
	public void setCustomerIdNumber(String customerIdNumber) {
		this.customerIdNumber = customerIdNumber;
	}
	public String getCustomerActiveFlag() {
		return customerActiveFlag;
	}
	public void setCustomerActiveFlag(String customerActiveFlag) {
		this.customerActiveFlag = customerActiveFlag;
	}
}
