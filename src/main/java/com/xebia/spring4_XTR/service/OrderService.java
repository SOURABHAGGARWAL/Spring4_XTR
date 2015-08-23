package com.xebia.spring4_XTR.service;

import com.xebia.spring4_XTR.exception.CustomerException;
import com.xebia.spring4_XTR.exception.OrderException;
import com.xebia.spring4_XTR.model.Order;

public interface OrderService {
	
    public Order getOrder(String orderId) throws OrderException;
	
    public Order saveOrder(Order order) throws OrderException, CustomerException;
	
    public Order updateOrder(String orderId, Order order) throws OrderException;
	
    public void deleteOrder(String orderId) throws OrderException, CustomerException;
	
}
