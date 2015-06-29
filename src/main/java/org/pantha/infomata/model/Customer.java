package org.pantha.infomata.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customer")
public class Customer implements Serializable{

	private static final long serialVersionUID = -7531225083160938540L;

	@Id
	@Field("customer_id")
	private String customerId;
	@Field("first_name")
	private String firstName;
	@Field("last_name")
	private String lastName;
	@Field("created_on")
	private Date createdOn;
	@Field("modified_on")
	private Date modifiedOn;
	@Field("customer_orders")
	private List<String> orders =  new ArrayList<String>();
	
	public Customer(){}
	
	public Customer(String firstName, String lastName, Date createdOn, Date modifiedOn, List<String> orders){
		this.firstName=firstName;
		this.lastName=lastName;
		this.createdOn=createdOn;
		this.modifiedOn=modifiedOn;
		this.orders = orders;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public List<String> getOrders() {
		return orders;
	}

	public void setOrders(List<String> orders) {
		this.orders = orders;
	}
	
}
