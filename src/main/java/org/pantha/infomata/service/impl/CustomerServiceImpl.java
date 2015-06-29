package org.pantha.infomata.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.pantha.infomata.business.CustomerBusiness;
import org.pantha.infomata.exception.CustomerException;
import org.pantha.infomata.exception.OrderException;
import org.pantha.infomata.model.Customer;
import org.pantha.infomata.model.Order;
import org.pantha.infomata.service.CustomerService;
import org.pantha.infomata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerBusiness customerBusiness;
	
	@Autowired
	private OrderService orderService;
	
    public Customer getCustomer(String customerId) throws CustomerException {
    	try{
    		return customerBusiness.getCustomer(customerId);
    	} catch(Exception e){
    		throw new CustomerException("Not able to get customer with customerId = "+customerId);
    	}
    }
	
    public Customer saveCustomer(Customer customer) throws CustomerException {
    	try{
    		return customerBusiness.saveCustomer(customer);
    	} catch(Exception e){
    		throw new CustomerException("Not able to save customer with name = "+customer.getFirstName());
    	}
    }
	
    public Customer updateCustomer(String customerId, Customer customer) throws CustomerException {
    	try{
    		return customerBusiness.updateCustomer(customerId, customer);
    	} catch(Exception e){
    		throw new CustomerException("Not able to update customer with customerId = "+customerId);
    	}
    }
	
    public void deleteCustomer(String customerId) throws CustomerException {
    	try{
    		customerBusiness.deleteCustomer(customerId);
    	} catch(Exception e){
    		throw new CustomerException("Uable to delte customer with customerId = "+customerId);
    	}
    }
    
    public List<Order> getCustomerOrders(String customerId) throws OrderException, CustomerException{
    	List<Order> orderList = new ArrayList<Order>();
    	Customer customer = customerBusiness.getCustomer(customerId);
    	if(customer==null){
    		throw new CustomerException("Uable to get customer with customerId = "+customerId);
    	}
    	for (String orderId : customer.getOrders()) {
    		Order order = orderService.getOrder(orderId);
    		orderList.add(order);
		}
    	return orderList;
    }
	
}
