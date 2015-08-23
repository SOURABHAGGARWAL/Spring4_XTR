package com.xebia.spring4_XTR.service;

import java.util.List;

import com.xebia.spring4_XTR.exception.CityException;
import com.xebia.spring4_XTR.model.City;

public interface CityService {
	
    public City getCity(Long id) throws CityException;
	
    public City saveCity(City city) throws CityException;
	
    public City updateCity(Long id, City city) throws CityException;
	
    public void deleteCity(Long id) throws CityException;
    
    public List<City> getAllCitiesLamda() throws CityException;
    
    public List<City> getAllCitiesInnerClass() throws CityException;
    
}
