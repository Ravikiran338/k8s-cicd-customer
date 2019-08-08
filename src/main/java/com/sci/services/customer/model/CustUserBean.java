package com.sci.services.customer.model;

import java.io.Serializable;

public class CustUserBean implements Serializable {
	private static final long serialVersionUID = -5622741359067091919L;
	private Integer customerId;
	private Integer userId;
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
}
