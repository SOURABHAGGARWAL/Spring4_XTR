package com.xebia.spring4_XTR.controller.core.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.spring4_XTR.exception.CustomerException;
import com.xebia.spring4_XTR.model.Person;

// call with http://localhost:9090/api/OrderCoreAnnotation
@RestController
@RequestMapping("/api/OrderCoreAnnotation")
public class OrderCoreAnnotation{

	@Autowired
	List<Person> list;
	
	/**
	 * @param customerId
	 * @return
	 * @throws CustomerException
	 */
	@RequestMapping(method = RequestMethod.GET)
    public List<Person> getCustomer() throws CustomerException {
        return list;
    }
	
}
