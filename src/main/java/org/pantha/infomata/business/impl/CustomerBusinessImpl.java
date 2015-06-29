package org.pantha.infomata.business.impl;

import java.util.Date;

import org.pantha.infomata.business.CustomerBusiness;
import org.pantha.infomata.model.Customer;
import org.pantha.infomata.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerBusiness")
public class CustomerBusinessImpl implements CustomerBusiness {
	
	@Autowired
	private CustomerRepository customerRepository;
	
    public Customer getCustomer(String customerId) {
        Customer customer=customerRepository.findOne(customerId);
        return customer;
    }
	
    public Customer saveCustomer(Customer customer) {
    	customer.setCreatedOn(new Date());
    	customer.setModifiedOn(new Date());
		return customerRepository.save(customer);
    }

    public Customer updateCustomer(String customerId, Customer customer)  {
    	Customer updateCustomer = customerRepository.findOne(customerId);
    	if(customer.getFirstName()!=null){
    		updateCustomer.setFirstName(customer.getFirstName());
    	}
    	if(customer.getLastName()!=null){
    		updateCustomer.setLastName(customer.getLastName());
    	}
    	if(customer.getOrders().size()>0){
    		updateCustomer.setOrders(customer.getOrders());
    	}
    	updateCustomer.setModifiedOn(new Date());
		return customerRepository.save(updateCustomer);
    }
	
    public void deleteCustomer(String customerId) {
    	customerRepository.delete(customerId);
    }
	
}
