package org.pantha.infomata.repository;

import org.pantha.infomata.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

}
