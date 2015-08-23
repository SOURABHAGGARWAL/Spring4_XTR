package com.xebia.spring4_XTR.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.spring4_XTR.business.CityBusiness;
import com.xebia.spring4_XTR.exception.CityException;
import com.xebia.spring4_XTR.model.City;
import com.xebia.spring4_XTR.service.CityService;
import com.xebia.spring4_XTR.service.CustomerService;

@Service("cityService")
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityBusiness cityBusiness;
	
	@Autowired
	private CustomerService customerService;
	
    public City getCity(Long cityId) throws CityException {
		try{
			return cityBusiness.getCity(cityId);
		}catch(Exception e){
			e.printStackTrace();
			throw new CityException("Unable to get city with cityId = "+cityId); 
		}
    }
	
    public City saveCity(City city) throws CityException {
    	City citySaved = null;
    	try{
    		citySaved = cityBusiness.saveCity(city);
    	} catch(Exception e){
    		throw new CityException("Unable to save city!"); 
    	}
    	return citySaved;
    }
	
    public City updateCity(Long cityId, City city) throws CityException {
		try{
			return cityBusiness.updateCity(cityId, city);
		}catch(Exception e){
			throw new CityException("Fail to update city!");
		}
    }
	
    public void deleteCity(Long cityId) throws CityException {
		City city = cityBusiness.getCity(cityId);
		if(city==null){
			cityBusiness.deleteCity(cityId);
			throw new CityException("City Not Found!"); 
		}
    }

	@Override
	public List<City> getAllCitiesLamda() throws CityException {
		List<City> cities = cityBusiness.getAllCitiesLamda();
		if(cities==null || cities.size()==0){
			throw new CityException("No city found!"); 
		}
		return cities;
	}

	@Override
	public List<City> getAllCitiesInnerClass() throws CityException {
		List<City> cities = cityBusiness.getAllCitiesInnerClass();
		if(cities==null || cities.size()==0){
			throw new CityException("No city found!"); 
		}
		return cities;
	}
	
}
