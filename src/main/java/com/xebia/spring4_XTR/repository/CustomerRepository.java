package com.xebia.spring4_XTR.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.xebia.spring4_XTR.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	  @Query("{'_id': ?0}")
	  Optional<Customer> findByCustomerID(String customerId);
}
