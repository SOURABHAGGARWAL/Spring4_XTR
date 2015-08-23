package com.xebia.spring4_XTR.controller.java8.optional.new_way;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.spring4_XTR.exception.CustomerException;
import com.xebia.spring4_XTR.model.Customer;
import com.xebia.spring4_XTR.service.CustomerService;

@RestController
@RequestMapping("/api/java8optionalsupportfornullsafety")
public class Java8OptionalSupportForNullSafety {
	
	@Autowired
	private Optional<CustomerService> customerServiceOptional;
	
	@RequestMapping("/accounts/{customerId}")
	public String getCustomer(@PathVariable String customerId) throws CustomerException{
		if(customerServiceOptional.isPresent()){
			CustomerService customerService = customerServiceOptional.get();
			Optional<Customer> optional = customerService.findByCustomerID(customerId);
			if(optional.isPresent()) {
			   Customer customer = optional.get();
			   return customer.getFirstName() + " " + customer.getLastName();
			} else{
				return "No Customer with ID";
			}
		} else{
			return "Service not present";
		}
	}
}
