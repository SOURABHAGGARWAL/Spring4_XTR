package com.xebia.spring4_XTR.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.spring4_XTR.business.OrderBusiness;
import com.xebia.spring4_XTR.exception.CustomerException;
import com.xebia.spring4_XTR.exception.OrderException;
import com.xebia.spring4_XTR.model.Customer;
import com.xebia.spring4_XTR.model.Order;
import com.xebia.spring4_XTR.service.CustomerService;
import com.xebia.spring4_XTR.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderBusiness orderBusiness;
	
	@Autowired
	private CustomerService customerService;
	
    public Order getOrder(String orderId) throws OrderException {
		try{
			return orderBusiness.getOrder(orderId);
		}catch(Exception e){
			throw new OrderException("Unable to get order with orderId = "+orderId); 
		}
    }
	
    public Order saveOrder(Order order) throws OrderException, CustomerException {
    	Order customerOrder=null;
    	try{
			customerOrder = orderBusiness.saveOrder(order);
    	} catch(Exception e){
    		throw new OrderException("Unable to create order!"); 
    	}
    	Customer customer = customerService.getCustomer(order.getCustomerId());
			if(customer==null){
				throw new CustomerException("Customer Not Found!");
			}
    	List<String> orders= customer.getOrders();
    		orders.add(customerOrder.getOrderId());
    		customer.setOrders(orders);
    	customerService.updateCustomer(order.getCustomerId(), customer);
    	return customerOrder;
    }
	
    public Order updateOrder(String orderId, Order order) throws OrderException {
		try{
			if(order.getCustomerId()!=null || StringUtils.isNotEmpty(order.getCustomerId())){
				throw new OrderException("Change of customerId not permitted!"); 
			}
			return orderBusiness.updateOrder(orderId, order);
		}catch(Exception e){
			throw new OrderException("Fail to update order!");
		}
    }
	
    public void deleteOrder(String orderId) throws OrderException, CustomerException {
		Order order = orderBusiness.getOrder(orderId);
		if(order==null){
			throw new OrderException("Order Not Found!"); 
		}
		orderBusiness.deleteOrder(orderId);
		Customer customer = customerService.getCustomer(order.getCustomerId());
		if(customer==null){
			throw new CustomerException("Customer Not Found!");
		}
		List<String> orders = customer.getOrders();
			orders.remove(orderId);
		customer.setOrders(orders);
		try{
			customerService.updateCustomer(order.getCustomerId(), customer);
		}catch(Exception e){
			throw new CustomerException("Failed to update customer with order!");
		}
    }
	
}
