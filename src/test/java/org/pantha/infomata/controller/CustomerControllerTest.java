package org.pantha.infomata.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pantha.infomata.CustomerInfomataApplication;
import org.pantha.infomata.exception.CustomerException;
import org.pantha.infomata.model.Customer;
import org.pantha.infomata.model.Order;
import org.pantha.infomata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CustomerInfomataApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0") 
public class CustomerControllerTest extends RestAssured {
	
	@Autowired
    CustomerService customerService;
	Customer customer;
	Order order;
	@Value("${local.server.port}")
    int port;
	String mockedCustomerId="558fdca444aef92825354745";
	String mockedInvalidCustomerId="558fdca444aef92825354777";
	String mockedOrderId="558fdca444aef92825356789";
	double amount=24.56;
	Date currentDate = new Date();
	
	@Before
    public void setUp() throws CustomerException {
		order = new Order("SKUNAME", mockedCustomerId ,"PRODUCTNAME", currentDate, currentDate, amount);
		order.setOrderId(mockedOrderId);
		List<String> orders = new ArrayList<String>();
		orders.add(mockedOrderId);
		customer = new Customer("firstName","lastName", currentDate, currentDate, orders);
		customer.setCustomerId(mockedCustomerId);
		customerService.saveCustomer(customer);
		
        RestAssured.port = port;
   	}
	
	@Test
    public void getCustomerTest() {
        String customerId = customer.getCustomerId();
        
        when().get("/api/customer?customerId={customerId}", customerId).
		then().
		statusCode(HttpStatus.OK.value()).
		body("firstName", Matchers.is("firstName")).
		body("customerId", Matchers.is(customerId)).body("lastName", Matchers.is("lastName"));
    }
	
	@Test
    public void deleteCustomerTest() {
        String customerId = customer.getCustomerId();
        when().delete("/api/customer?customerId={customerId}", customerId).then().statusCode(HttpStatus.OK.value());
    }
	
	@Test
    public void updateCustomerTest() {
		  Customer updateCustomer = customer;
		  updateCustomer.setFirstName("updatedFirstName");
		  
		  String customerId = customer.getCustomerId();
		  
		  given().body(updateCustomer).contentType(ContentType.JSON)
		  .when().put("/api/customer?customerId={customerId}", customerId)
		  .then().statusCode(HttpStatus.OK.value())
		  .body("firstName", Matchers.is("updatedFirstName"))
		  .body("lastName", Matchers.is("lastName"));
	}
	
	@Test
	public void updateCustomerWithoutBodyTest() {
		String customerId = customer.getCustomerId();
		when().put("/api/customer?customerId={customerId}", customerId).then().statusCode(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	public void saveCustomerTest() {
		  given().body(customer).contentType(ContentType.JSON)
		  .when().post("/api/customer")
		  .then().statusCode(HttpStatus.OK.value())
		  .body("customerId", Matchers.is(mockedCustomerId))
		  .body("firstName", Matchers.is("firstName"))
		  .body("lastName", Matchers.is("lastName"))
		  .body("orders", Matchers.is(customer.getOrders()));
	}
	
	@Test
	public void saveCustomerOrderTest() {
		List<Order> orders = new ArrayList<Order>();
		orders.add(null);
		String customerId = customer.getCustomerId();
        when().get("/api/customer/orders?customerId={customerId}", customerId).
		then().
		statusCode(HttpStatus.OK.value()).
		body("orders", Matchers.is(orders));
	}
}
