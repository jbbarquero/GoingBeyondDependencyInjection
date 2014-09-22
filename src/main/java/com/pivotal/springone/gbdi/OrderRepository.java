package com.pivotal.springone.gbdi;

import com.pivotal.springone.Order;

public interface OrderRepository {
	public Order findByOrderId(long id);
	public Order save(Order entity);
	public void delete(long id);
	public void delete(Order entity);
}
