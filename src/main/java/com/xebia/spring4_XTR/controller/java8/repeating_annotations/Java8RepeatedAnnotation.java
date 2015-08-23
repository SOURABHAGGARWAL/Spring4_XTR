package com.xebia.spring4_XTR.controller.java8.repeating_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.spring4_XTR.exception.OrderException;

@RestController
@RequestMapping("/api/java8mutipleannotation")
@PropertySource("classpath:/repeating_annotations/property_file1.properties")
@PropertySource("classpath:/repeating_annotations/property_file2.properties")
@PropertySource("classpath:/repeating_annotations/property_file3.properties")
@PropertySource("classpath:/repeating_annotations/property_file4.properties")
public class Java8RepeatedAnnotation {

	@Autowired
	private Environment env;
	
	/**
	 * @param orderId
	 * @return
	 * @throws OrderException
	 */
	@RequestMapping(value= "/getproperty/{property}", method = RequestMethod.GET)
	public String getProperty(@PathVariable String property){
		return env.getProperty(property);
	}
}
