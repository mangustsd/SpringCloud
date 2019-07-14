package org.oleg.taco.dao.interfaces;

import org.oleg.taco.entity.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository 
		extends CrudRepository<Order, Long> {

}
