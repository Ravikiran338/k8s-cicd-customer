/**
 * @author Jaya Prakash Manne
 *
 */
package com.sci.services.customer.repository;

import com.sci.services.customer.model.CustUserBean;
import com.sci.services.customer.model.Customer;
import com.sci.services.customer.model.CustomerDetails;
import com.sci.services.customer.model.Status;
import com.sci.services.customer.model.UserBean;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
	
	/*
	 * public Flux<Customer> getAllCustomers();
	 * 
	 * public Mono<Status> createCustomer(Mono<UserBean> monoUser);
	 * 
	 * public Flux<CustomerDetails> getCustomer(Integer customerId);
	 * 
	 * public Mono<Status> deactivateCustomer(Mono<CustUserBean> monoCustUserBean);
	 * 
	 * public Mono<Status> updateCustomer(Mono<UserBean> monoUser);
	 */
	public Flux<Customer> getAll();
	
	//public Flux<CustomerDetails> getAllCustomers();
	
	public Mono<Status> createCustomer(Mono<UserBean> monoUser);
	
	public Flux<Customer> getCustomer(Integer customerId);
	
	//public Mono<Status> deactivateCustomer(Mono<CustUserBean> monoCustUserBean);
	
	public Mono<Status> updateCustomer(Mono<UserBean> monoUser);
	
}
