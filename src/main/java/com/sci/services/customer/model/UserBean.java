/**
 * @author Jaya Prakash Manne
 *
 */
package com.sci.services.customer.model;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable {
	private static final long serialVersionUID = 3757693366713304267L;
	private String userId; 
	private String firstName; 
	private String lastName; 
	private String middleName; 
	private String activeFlag; 
	
	private String username;
	private String password;
	 
	private String email;
	private String phone;
	private String fax;
	private String roleId;
	private AddressBean address;
	private Integer customerId;
	private Date customerDob;
	private String customerIdNum;
	private String customerActiveFlag;
	
	
	public Date getCustomerDob() {
		return customerDob;
	}
	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}
	public String getCustomerIdNum() {
		return customerIdNum;
	}
	public void setCustomerIdNum(String customerIdNum) {
		this.customerIdNum = customerIdNum;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
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

	
	  public String getUsername() { return username; }
	  public void  setUsername(String username) { this.username = username; } 
	  public String  getPassword() { return password; } 
	  public void setPassword(String password) {
	  this.password = password; }
	 
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
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerActiveFlag() {
		return customerActiveFlag;
	}
	public void setCustomerActiveFlag(String customerActiveFlag) {
		this.customerActiveFlag = customerActiveFlag;
	}
}