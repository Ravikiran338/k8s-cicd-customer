package com.sci.services.util;

import com.sci.services.customer.model.Status;

/**
 * @author Jaya Prakash Manne
 *
 */
public class CustomerServiceUtil {
	
	private static CustomerServiceUtil customerServiceUtil = null;

	private CustomerServiceUtil() {

	}
	public static CustomerServiceUtil getInstance() {
		if (customerServiceUtil == null){
			customerServiceUtil = new CustomerServiceUtil();
		}
		return customerServiceUtil;
	}
	
	/**
	 * @param statusCode
	 * @param statusDesc
	 */
	public Status prepareStatus(String statusCode,String statusDesc) {
		Status status = new Status();
		status.setStatusCode(statusCode);
		status.setStatusDesc(statusDesc);
		return status;
	} 
}
