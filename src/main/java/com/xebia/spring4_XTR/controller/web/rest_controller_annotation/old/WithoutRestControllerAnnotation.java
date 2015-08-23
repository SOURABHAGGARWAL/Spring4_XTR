package com.xebia.spring4_XTR.controller.web.rest_controller_annotation.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xebia.spring4_XTR.exception.CustomerException;
import com.xebia.spring4_XTR.model.Customer;
import com.xebia.spring4_XTR.service.CustomerService;

// call with http://localhost:9090/api/withoutrestcontrollerannotation?customerId=5590e16144ae3e640e1950da
@Controller
@RequestMapping("/api/withoutrestcontrollerannotation")
public class WithoutRestControllerAnnotation{

	@Autowired
	private CustomerService customerService;
	
	/**
	 * @param customerId
	 * @return
	 * @throws CustomerException
	 */
	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Customer getCustomer(String customerId) throws CustomerException {
        return customerService.getCustomer(customerId);
    }
	
}
