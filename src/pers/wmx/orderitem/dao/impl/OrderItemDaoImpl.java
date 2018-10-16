package pers.wmx.orderitem.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import pers.wmx.orderitem.dao.OrderItemDao;
import pers.wmx.orderitem.domain.OrderItem;

public class OrderItemDaoImpl extends HibernateDaoSupport implements OrderItemDao{

	@Override
	public void add(OrderItem o) {
		this.getHibernateTemplate().save(o);
		
	}



}	
