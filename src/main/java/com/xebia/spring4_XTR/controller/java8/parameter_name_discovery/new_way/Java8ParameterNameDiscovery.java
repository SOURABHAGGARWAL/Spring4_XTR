package com.xebia.spring4_XTR.controller.java8.parameter_name_discovery.new_way;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.spring4_XTR.exception.CustomerException;
import com.xebia.spring4_XTR.model.Customer;
import com.xebia.spring4_XTR.service.CustomerService;

@RestController
@RequestMapping("/api/java8parameternamediscovery")
public class Java8ParameterNameDiscovery {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/accounts/{customerId}")
	public Customer getCustomer(@PathVariable String customerId) throws CustomerException{
		return customerService.getCustomer(customerId);
	}
}
