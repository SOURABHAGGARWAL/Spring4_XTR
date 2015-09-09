package com.xebia.spring4_XTR.service;

import java.util.List;
import java.util.Optional;

import com.xebia.spring4_XTR.exception.CustomerException;
import com.xebia.spring4_XTR.exception.OrderException;
import com.xebia.spring4_XTR.model.Customer;
import com.xebia.spring4_XTR.model.Order;

public interface CustomerService {
	
    public Customer getCustomer(String customerId) throws CustomerException;
	
    public Customer saveCustomer(Customer customer) throws CustomerException;
	
    public Customer updateCustomer(String customerId, Customer customer) throws CustomerException ;
	
    public void deleteCustomer(String customerId) throws CustomerException ;

    public List<Order> getCustomerOrders(String customerId) throws OrderException, CustomerException;

	public Optional<Customer> findByCustomerID(String customerId);
	

	public List<Customer> findByCustomerName(String firstName);
}
