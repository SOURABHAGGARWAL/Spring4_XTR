package com.xebia.spring4_XTR.business;

import java.util.List;
import java.util.Optional;

import com.xebia.spring4_XTR.model.Customer;

public interface CustomerBusiness {
	
    public Customer getCustomer(String customerId);
	
    public Customer saveCustomer(Customer customer);
	
    public Customer updateCustomer(String customerId, Customer customer) ;
	
    public void deleteCustomer(String customerId) ;

	public Optional<Customer> findByCustomerID(String customerId);

	public List<Customer> findByCustomerName(String firstName);
	
}
