package org.pantha.infomata.business.impl;

import java.util.Date;

import org.pantha.infomata.business.OrderBusiness;
import org.pantha.infomata.model.Order;
import org.pantha.infomata.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderBusiness")
public class OrderBusinessImpl implements OrderBusiness {
	
	@Autowired
	private OrderRepository orderRepository;
	
    public Order getOrder(String orderId) {
        Order order=orderRepository.findOne(orderId);
        return order;
    }
	
    public Order saveOrder(Order order) {
    	order.setOrderDate(new Date());
    	order.setOrderModifiedDate(new Date());
		return orderRepository.save(order);
    }

    public Order updateOrder(String orderId, Order order) {
    	Order updateOrder = orderRepository.findOne(orderId);
    	updateOrder.setOrderModifiedDate(new Date());
		return orderRepository.save(updateOrder);
    }
	
    public void deleteOrder(String orderId) {
		orderRepository.delete(orderId);
    }
	
}
