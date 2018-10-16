package pers.wmx.order.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pers.wmx.order.dao.OrderDao;
import pers.wmx.order.domain.Order;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
		
	}

	
	public Order findById(int id) {
		
		return this.getHibernateTemplate().get(Order.class, id);
	}


	@Override
	public void update(Order order) {
		this.getHibernateTemplate().update(order);
		
	}
	
}
