package org.pantha.infomata.service;

import java.util.List;

import org.pantha.infomata.exception.CustomerException;
import org.pantha.infomata.exception.OrderException;
import org.pantha.infomata.model.Customer;
import org.pantha.infomata.model.Order;

public interface CustomerService {
	
    public Customer getCustomer(String customerId) throws CustomerException;
	
    public Customer saveCustomer(Customer customer) throws CustomerException;
	
    public Customer updateCustomer(String customerId, Customer customer) throws CustomerException ;
	
    public void deleteCustomer(String customerId) throws CustomerException ;

    public List<Order> getCustomerOrders(String customerId) throws OrderException, CustomerException;
}
