/**
 * @author Jaya Prakash Manne
 *
 */
package com.sci.services.customer.model;

import java.io.Serializable;

public class CustomerBean implements Serializable {
	private static final long serialVersionUID = -8124829867157380524L;
	private Integer customerId;
	private String customerDOB;
	private String customerIdNumber;
	private String customerActiveFlag;
	private UserBean user;
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
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
}
