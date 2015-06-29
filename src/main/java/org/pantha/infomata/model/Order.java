package org.pantha.infomata.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "orders")
public class Order implements Serializable{

	private static final long serialVersionUID = -8436520874124694997L;
	
	@Id 
	@Field("order_id")
	private String orderId;
	@Field("sku")
	private String sku;
	@Field("customer_id")
	private String customerId;
	@Field(value = "product_name")
	private String productName;
	@Field("order_date")
	private Date orderDate;
	@Field("order_modified_date")
	private Date orderModifiedDate;
	@Field("order_amount")
	private double orderAmount;
	
	public Order(){}
	
	public Order(String sku, String customerId, String productName, Date orderDate, Date orderModifiedDate, double orderAmount){
		this.sku=sku;
		this.customerId=customerId;
		this.productName=productName;
		this.orderDate=orderDate;
		this.orderModifiedDate=orderModifiedDate;
		this.orderAmount=orderAmount;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderModifiedDate() {
		return orderModifiedDate;
	}
	public void setOrderModifiedDate(Date orderModifiedDate) {
		this.orderModifiedDate = orderModifiedDate;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
}
