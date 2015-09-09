package com.xebia.spring4_XTR.controller.web.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.spring4_XTR.exception.CustomerException;
import com.xebia.spring4_XTR.model.Customer;
import com.xebia.spring4_XTR.service.CustomerService;

// call with http://localhost:9090/api/exceptionAdviceRestcontroller/5590e16144ae3e640e1950da
@RestController
@RequestMapping("/api/exceptionAdviceRestcontroller")
public class ExceptionAdviceRestController{

	@Autowired
	private CustomerService customerService;
	
	/**
	 * @param <T>
	 * @param customerId
	 * @return
	 * @throws CustomerException
	 */
	@RequestMapping(value = "{articleId}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public <T> ResponseEntity<T>  getCustomer(String customerId) throws CustomerException {
		throw new IllegalArgumentException("[API] Getting exception problem.");
    }
}
