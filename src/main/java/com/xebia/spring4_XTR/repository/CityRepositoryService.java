package com.xebia.spring4_XTR.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xebia.spring4_XTR.model.City;
import com.xebia.spring4_XTR.repository.core.CityRepository;

@Repository
public class CityRepositoryService {
	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CityRepository cityRepository;
	
	// using lamda expression in the row mapper functional interface for getting all product
	public List<City> getAllCitiesLamda(){
		List<City> listCity =  jdbcTemplate.query("SELECT * from customer_infomata.city", (rs, rowNum) -> {
		    Long id = rs.getLong("id");
		    String name = rs.getString("name");
		    String state = rs.getString("state");
		    String country = rs.getString("country");
	
		    City city = new City();
		    city.setId(id);
		    city.setName(name);
		    city.setState(state);
		    city.setCountry(country);
	
		    return city;
		});
		return listCity;
	}
	
	// using inner class for method arguments
	public List<City> getAllCitiesInnerClass(){
		List<City> listCity = jdbcTemplate.query("SELECT * from customer_infomata.city", new RowMapper<City>(){
			  @Override
			  public City mapRow(ResultSet rs, int rowNum) throws SQLException {
				    Long id = rs.getLong("id");
				    String name = rs.getString("name");
				    String state = rs.getString("state");
				    String country = rs.getString("country");
			
				    City city = new City();
				    city.setId(id);
				    city.setName(name);
				    city.setState(state);
				    city.setCountry(country);
			
				    return city;
				}
		});
		return listCity;
	}

	public City findOne(Long cityId) {
		return cityRepository.findOne(cityId);
	}

	public City save(City city) {
		return cityRepository.save(city);
	}

	public void delete(Long cityId) {
		cityRepository.delete(cityId);
	}

}
