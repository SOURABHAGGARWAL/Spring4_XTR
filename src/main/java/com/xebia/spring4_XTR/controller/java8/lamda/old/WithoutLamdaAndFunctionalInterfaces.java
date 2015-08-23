package com.xebia.spring4_XTR.controller.java8.lamda.old;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.spring4_XTR.exception.CityException;
import com.xebia.spring4_XTR.model.City;
import com.xebia.spring4_XTR.service.CityService;

@RestController
@RequestMapping("/api/withoutlamdaandfunctionalinterfaces")
public class WithoutLamdaAndFunctionalInterfaces {
	@Autowired
	private CityService cityService;
	
	@RequestMapping("/getallcities")
	public List<City> getAllCitiesInnerClass() throws CityException{
		return cityService.getAllCitiesInnerClass();
	}
}
