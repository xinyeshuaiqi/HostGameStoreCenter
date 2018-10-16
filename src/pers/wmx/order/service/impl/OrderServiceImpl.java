package pers.wmx.order.service.impl;

import pers.wmx.order.dao.OrderDao;
import pers.wmx.order.domain.Order;
import pers.wmx.order.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	
	public void create(Order order) {
		this.orderDao.save(order);
		
	}


	
	public void modifyOrderState(String r6_Order) {
		int id=Integer.parseInt(r6_Order);
		
		Order order=orderDao.findById(id);
		order.setPaystate(1);
		
		orderDao.update(order);
	}

	
	
}
