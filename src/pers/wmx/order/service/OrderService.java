package pers.wmx.order.service;

import pers.wmx.order.domain.Order;

public interface OrderService {

	void create(Order order);

	void modifyOrderState(String r6_Order);

	

}
