package org.pantha.infomata.business;

import org.pantha.infomata.model.Customer;

public interface CustomerBusiness {
	
    public Customer getCustomer(String customerId);
	
    public Customer saveCustomer(Customer customer);
	
    public Customer updateCustomer(String customerId, Customer customer) ;
	
    public void deleteCustomer(String customerId) ;
	
}
