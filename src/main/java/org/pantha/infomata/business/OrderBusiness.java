package org.pantha.infomata.business;

import org.pantha.infomata.model.Order;

public interface OrderBusiness {
	
    public Order getOrder(String orderId);
	
    public Order saveOrder(Order order);
	
    public Order updateOrder(String orderId, Order order);
	
    public void deleteOrder(String orderId);
	
}
