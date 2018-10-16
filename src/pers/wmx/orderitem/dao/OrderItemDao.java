package pers.wmx.orderitem.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pers.wmx.orderitem.domain.OrderItem;

public interface OrderItemDao{

	void add(OrderItem o);

	
	
}
