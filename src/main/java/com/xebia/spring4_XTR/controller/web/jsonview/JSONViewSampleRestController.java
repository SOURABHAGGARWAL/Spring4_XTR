/**
 * 
 */
package com.xebia.spring4_XTR.controller.web.jsonview;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.xebia.spring4_XTR.exception.CustomerException;
import com.xebia.spring4_XTR.exception.OrderException;
import com.xebia.spring4_XTR.model.Customer;
import com.xebia.spring4_XTR.model.View;
import com.xebia.spring4_XTR.service.CustomerService;

/**
 * @author user
 * 
 * http://localhost:9090/api/JSONViewSampleRestController/Ravi
 * http://localhost:9090/api/JSONViewSampleRestController/byName
 *
 */

@RestController
@RequestMapping("/api/JSONViewSampleRestController")
public class JSONViewSampleRestController {
	@Autowired
	private CustomerService customerService;

	/**
	 * @param orderId
	 * @return
	 * @throws OrderException
	 * @throws CustomerException 
	 */
	@JsonView(View.Summary.class)
	@RequestMapping(value = "{firstName}", produces = "application/json")
    public List<Customer> findEmployeeDetail(String firstName) throws OrderException, CustomerException {
		Customer customer = createCustomer("1","Ravi","Sharma");
		customerService.saveCustomer(customer);
		customer = createCustomer("2","Ravi","Goyal");
		customerService.saveCustomer(customer);
		customer = createCustomer("3","Ravi","Gole");
		customerService.saveCustomer(customer);
		return customerService.findByCustomerName("Ravi");
    }

	private Customer createCustomer(String id, String fName, String lName) {
		Customer customer = new Customer();
		customer.setCustomerId(id);
		customer.setFirstName(fName);
		customer.setLastName(lName);
		List<String> orders = new  ArrayList<String>();
		orders.add("Order1");
		orders.add("Order2");
		orders.add("Order3");
		customer.setOrders(orders);
		
		return customer;
	}
	
	@RequestMapping(value = "/byName", produces = "application/json")
    public List<Customer> findEmployeeDetailWithoutJSONView(String firstName) throws OrderException, CustomerException {
		return customerService.findByCustomerName("Ravi");
    }
	
	
	
}
