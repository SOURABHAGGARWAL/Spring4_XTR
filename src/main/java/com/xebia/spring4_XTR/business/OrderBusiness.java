package com.xebia.spring4_XTR.business;

import com.xebia.spring4_XTR.model.Order;

public interface OrderBusiness {
	
    public Order getOrder(String orderId);
	
    public Order saveOrder(Order order);
	
    public Order updateOrder(String orderId, Order order);
	
    public void deleteOrder(String orderId);
	
}
