package com.xebia.spring4_XTR.model;

import org.springframework.core.annotation.Order;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Component
@Order(value=2)
public class Manager implements Person{
	@Id 
	@Field("order_name")
	private String name = "Manager";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
