package org.pantha.infomata.controller;

import java.util.List;

import org.pantha.infomata.exception.CustomerException;
import org.pantha.infomata.exception.OrderException;
import org.pantha.infomata.model.Customer;
import org.pantha.infomata.model.Order;
import org.pantha.infomata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController{

	@Autowired
	private CustomerService customerService;
	
	/**
	 * @param customerId
	 * @return
	 * @throws CustomerException
	 */
	@RequestMapping(method = RequestMethod.GET)
    public Customer getCustomer(String customerId) throws CustomerException {
        return customerService.getCustomer(customerId);
    }
	
    /**
     * @param customer
     * @return
     * @throws CustomerException
     */
    @RequestMapping(method=RequestMethod.POST)
    public Customer saveCustomer(@RequestBody Customer customer) throws CustomerException {
    	return customerService.saveCustomer(customer);
    }
	
	/**
	 * @param customerId
	 * @param customer
	 * @return
	 * @throws CustomerException
	 */
	@RequestMapping(method = RequestMethod.PUT)
    public Customer updateCustomer(String customerId, @RequestBody Customer customer) throws CustomerException {
		return customerService.updateCustomer(customerId, customer);
    }
	
	/**
	 * @param customerId
	 * @throws CustomerException
	 */
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteCustomer(String customerId) throws CustomerException {
		customerService.deleteCustomer(customerId);
    }
	
	/**
	 * @param customerId
	 * @return
	 * @throws OrderException
	 * @throws CustomerException
	 */
	@RequestMapping(value="/orders", method = RequestMethod.GET)
    public List<Order> getCustomerOrders(String customerId) throws OrderException, CustomerException{
		return customerService.getCustomerOrders(customerId);
    }
	
}
