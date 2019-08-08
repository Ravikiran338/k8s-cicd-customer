/**
 * @author Jaya Prakash Manne
 *
 */
package com.sci.services.customer.model;

import java.io.Serializable;
import java.util.Date;

public class UserPojo implements Serializable {
	private static final long serialVersionUID = -2202360592597576258L;
	private String userId; 
	private String firstName; 
	private String lastName; 
	private String middleName; 
	private String activeFlag; 
	private String lastModified;
	
	  private String username; private String password;
	 
	private String email;
	private String phone;
	private String fax;
	private String addressId;
	private String roleId;
	
	private Integer customerId;
	private Date customerDOB;
	private String customerIdNumber;
	private String customerActiveFlag;
	
	private AddressBean address;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
	}

	
	  public String getUsername() { return username; } public void
	  setUsername(String username) { this.username = username; } public String
	  getPassword() { return password; } public void setPassword(String password) {
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
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
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
	public Date getCustomerDOB() {
		return customerDOB;
	}
	public void setCustomerDOB(Date customerDOB) {
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