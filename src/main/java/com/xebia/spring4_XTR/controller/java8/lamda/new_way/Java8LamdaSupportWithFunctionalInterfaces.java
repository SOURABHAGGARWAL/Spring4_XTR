package com.xebia.spring4_XTR.controller.java8.lamda.new_way;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.spring4_XTR.exception.CityException;
import com.xebia.spring4_XTR.model.City;
import com.xebia.spring4_XTR.service.CityService;

@RestController
@RequestMapping("/api/java8lamdasupportwithfunctionalinterfaces")
public class Java8LamdaSupportWithFunctionalInterfaces {
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping("/getallcities")
	public List<City> getAllCitiesLamda() throws CityException{
		return cityService.getAllCitiesLamda();
	}
}
