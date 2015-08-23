package com.xebia.spring4_XTR.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xebia.spring4_XTR.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
