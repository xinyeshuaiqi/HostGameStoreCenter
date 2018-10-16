package pers.wmx.order.dao;

import pers.wmx.order.domain.Order;

public interface OrderDao {

	void save(Order order);

	Order findById(int id);

	void update(Order order);

}
