package com.xebia.spring4_XTR.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.spring4_XTR.business.CityBusiness;
import com.xebia.spring4_XTR.exception.CityException;
import com.xebia.spring4_XTR.model.City;
import com.xebia.spring4_XTR.repository.CityRepositoryService;

@Service("cityBusiness")
public class CityBusinessImpl implements CityBusiness {
	
	@Autowired
	private CityRepositoryService cityRepositoryService;
	
	@Override
    public City getCity(Long cityId) {
        City city=cityRepositoryService.findOne(cityId);
        return city;
    }
	
    @Override
    public City saveCity(City city) {
		return cityRepositoryService.save(city);
    }

    @Override
    public City updateCity(Long cityId, City city) {
    	City updateCity = cityRepositoryService.findOne(cityId);
		return cityRepositoryService.save(updateCity);
    }
	
    @Override
    public void deleteCity(Long cityId) {
		cityRepositoryService.delete(cityId);
    }

	@Override
	public List<City> getAllCitiesLamda() throws CityException {
		return cityRepositoryService.getAllCitiesLamda();
	}

	@Override
	public List<City> getAllCitiesInnerClass() throws CityException {
		return cityRepositoryService.getAllCitiesInnerClass();
	}
	
}
