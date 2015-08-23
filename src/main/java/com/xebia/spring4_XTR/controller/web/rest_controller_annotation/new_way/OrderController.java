package com.xebia.spring4_XTR.controller.web.rest_controller_annotation.new_way;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.spring4_XTR.exception.CustomerException;
import com.xebia.spring4_XTR.exception.OrderException;
import com.xebia.spring4_XTR.model.Order;
import com.xebia.spring4_XTR.service.CustomerService;
import com.xebia.spring4_XTR.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController{

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * @param orderId
	 * @return
	 * @throws OrderException
	 */
	@RequestMapping(method = RequestMethod.GET)
    public Order getOrder(String orderId) throws OrderException {
		return orderService.getOrder(orderId);
    }
	
    /**
     * @param order
     * @return
     * @throws OrderException
     * @throws CustomerException
     */
    @RequestMapping(method=RequestMethod.POST)
    public Order saveOrder(@RequestBody Order order) throws OrderException, CustomerException{
		return orderService.saveOrder(order);
    }
	
	/**
	 * @param orderId
	 * @param order
	 * @return
	 * @throws OrderException
	 */
	@RequestMapping(method = RequestMethod.PUT)
    public Order updateOrder(String orderId, @RequestBody Order order) throws OrderException {
		return orderService.updateOrder(orderId, order);
    }
	
	/**
	 * @param orderId
	 * @throws OrderException
	 * @throws CustomerException
	 */
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteOrder(String orderId) throws OrderException, CustomerException {
		orderService.deleteOrder(orderId);
	}
	
}
