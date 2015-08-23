package com.xebia.spring4_XTR.controller.java8.optional.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.spring4_XTR.exception.CustomerException;
import com.xebia.spring4_XTR.model.Customer;
import com.xebia.spring4_XTR.service.CustomerService;


@RestController
@RequestMapping("/api/withoutoptionalsupport")
public class WithoutOptionalSupport {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/accounts/{customerId}")
	public String getCustomer(@PathVariable String customerId) throws CustomerException{
		Customer customer  = customerService.getCustomer(customerId);
		return customer.getFirstName() + " " + customer.getLastName();
	}
}
