package org.pantha.infomata.controller;

import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import com.xebia.spring4_XTR.CustomerInfomataApplication;
import com.xebia.spring4_XTR.exception.CustomerException;
import com.xebia.spring4_XTR.exception.OrderException;
import com.xebia.spring4_XTR.model.Customer;
import com.xebia.spring4_XTR.model.Order;
import com.xebia.spring4_XTR.service.CustomerService;
import com.xebia.spring4_XTR.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CustomerInfomataApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0") 
public class OrderControllerTest extends RestAssured {
	
	@Autowired
    CustomerService customerService;
	@Autowired
    OrderService orderService;
	Customer customer;
	Order order;
	@Value("${local.server.port}")
    int port;
	String mockedCustomerId="558fdca444aef92825354745";
	String mockedOrderId="558fdca444aef92825356789";
	double amount=24.56;
	Date currentDate = new Date();
	
	@Before
    public void setUp() throws OrderException, CustomerException {
		customer = new Customer("firstName","lastName", currentDate, currentDate, null);
		customer.setCustomerId(mockedCustomerId);
		
		order = new Order("SKUNAME", mockedCustomerId ,"PRODUCTNAME", currentDate, currentDate, amount);
		order.setOrderId(mockedOrderId);
		
		customerService.saveCustomer(customer);
		orderService.saveOrder(order);
		
        RestAssured.port = port;
   	}
	
	@Test
    public void getOrderTest() {
        String orderId = order.getOrderId();
        when().get("/api/order?orderId={orderId}", orderId).
		then().
		statusCode(HttpStatus.OK.value()).
		body("sku", Matchers.is("SKUNAME"))
		.body("orderId", Matchers.is(orderId))
		.body("productName", Matchers.is("PRODUCTNAME"));
    }

	
	@Test
	public void updateOrderWithoutBodyTest() {
		String orderId = order.getOrderId();
		when().put("/api/order?orderId={orderId}", orderId).then().statusCode(HttpStatus.BAD_REQUEST.value());
	}

}
