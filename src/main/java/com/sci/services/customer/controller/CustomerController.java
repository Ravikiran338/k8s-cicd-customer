/**
 * @author Jaya Prakash Manne
 *
 */
package com.sci.services.customer.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sci.services.customer.model.Customer;
import com.sci.services.customer.model.CustomerDetails;
import com.sci.services.customer.model.Status;
import com.sci.services.customer.model.UserBean;
import com.sci.services.customer.repository.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService customerService;
	
	//=========================================================================
	
	@GetMapping("/")
	public Flux<Customer> getAllCustomers() {
		LOGGER.info("START of the method: getAllCustomers");
		return customerService.getAll();
	}
	
	//=========================================================================
	
	@GetMapping("/{customerId}")
	public Flux<Customer> getCustomerDetails(@PathVariable String customerId) {
		LOGGER.info("START of the method: getCustomerDetails, with the customerId : "+customerId);
		if(customerId != null && Integer.valueOf(customerId) > 0) {
			return customerService.getCustomer(Integer.valueOf(customerId));
		} else {
			return null;
			//return customerService.getAllCustomers();
		}
	}
	
	//=========================================================================
	
	@PostMapping
	public Mono<Status> createCustomer(@RequestBody UserBean userBean) {
		LOGGER.info("START of the method: createCustomer");
		userBean.setRoleId("3");
		Mono<UserBean> monoCustomerBean = Mono.just(userBean);
		return customerService.createCustomer(monoCustomerBean);
	}
	
	//=========================================================================
	
	/*@PostMapping("/delete")
	public Mono<Status> deactivateCustomer(@RequestBody CustUserBean custUserBean) {
		LOGGER.info("START of the method: deactivateCustomer");
		Mono<CustUserBean> monoCustomerUserBean = Mono.just(custUserBean);
		return customerService.deactivateCustomer(monoCustomerUserBean);
	}*/
	
	//=========================================================================
	
	@PutMapping
	public Mono<Status> updateCustomer(@RequestBody UserBean customer){
		Mono<UserBean> customerMono = Mono.just(customer);
		return customerService.updateCustomer(customerMono);	
	}
	
	//=========================================================================
}
