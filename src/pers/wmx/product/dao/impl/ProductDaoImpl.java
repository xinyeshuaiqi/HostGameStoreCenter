package pers.wmx.product.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pers.wmx.page.domain.PageHibernateCallback;
import pers.wmx.product.dao.ProductDao;
import pers.wmx.product.domain.Product;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao{

	@Override
	public List<Product> findAll() {
		
		return (List<Product>) this.getHibernateTemplate().find("from Product");
	}

	@Override
	public void add(Product product) {
		this.getHibernateTemplate().save(product);
		
	}

	@Override
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
		
	}

	@Override
	public Product findById(Integer id) {
		
		return this.getHibernateTemplate().get(Product.class, id);
	
	}

	@Override
	public void update(Product product) {
		this.getHibernateTemplate().update(product);
		
	}

	@Override
	public int getCount(String condition, Object[] params) {
		String hql = "select count(p) from Product p where 1=1 " + condition;
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,params);
		return list.get(0).intValue();
	}
	

	@Override
	public List<Product> findAll(String condition, Object[] params, int startIndex, int pageSize) {
		String hql = "from Product where 1=1 " + condition;
		return (List<Product>) this.getHibernateTemplate().execute(new PageHibernateCallback<Product>().setHql(hql).setPageSize(pageSize).setParams(params).setStartIndex(startIndex));
	}

}
