package org.oleg.taco.dao.interfaces;

import org.oleg.taco.entity.Order;

public interface BasicOrderRepository {

	public Order save(Order order);
}
