package com.xebia.spring4_XTR.controller.web.rest_controller_annotation.new_way;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.spring4_XTR.exception.CustomerException;
import com.xebia.spring4_XTR.exception.OrderException;
import com.xebia.spring4_XTR.model.Customer;
import com.xebia.spring4_XTR.model.Order;
import com.xebia.spring4_XTR.service.CustomerService;

// call with http://localhost:9090/api/webrestcontrollerannotation?customerId=5590e16144ae3e640e1950da
@RestController
@RequestMapping("/api/webrestcontrollerannotation")
public class WebRestControllerAnnotation{

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
