package org.pantha.infomata.service;

import org.pantha.infomata.exception.CustomerException;
import org.pantha.infomata.exception.OrderException;
import org.pantha.infomata.model.Order;

public interface OrderService {
	
    public Order getOrder(String orderId) throws OrderException;
	
    public Order saveOrder(Order order) throws OrderException, CustomerException;
	
    public Order updateOrder(String orderId, Order order) throws OrderException;
	
    public void deleteOrder(String orderId) throws OrderException, CustomerException;
	
}
