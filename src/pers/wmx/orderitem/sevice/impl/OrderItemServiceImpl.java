package pers.wmx.orderitem.sevice.impl;


import pers.wmx.orderitem.dao.OrderItemDao;
import pers.wmx.orderitem.domain.OrderItem;
import pers.wmx.orderitem.sevice.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService{
	OrderItemDao orderItemDao;

	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

	@Override
	public void createOrderItem(OrderItem o) {
		orderItemDao.add(o);
		
	}
	
	
}
