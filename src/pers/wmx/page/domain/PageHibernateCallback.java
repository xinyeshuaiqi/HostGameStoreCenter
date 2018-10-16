package pers.wmx.page.domain;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {
	private String hql;
	private Object[] params;
	private int startIndex;
	private int pageSize;
	
	
	
	public PageHibernateCallback<T> setHql(String hql) {
		this.hql = hql;
		return this;
	}



	public PageHibernateCallback<T> setParams(Object[] params) {
		this.params = params;
		return this;
	}



	public PageHibernateCallback<T> setStartIndex(int startIndex) {
		this.startIndex = startIndex;
		return this;
	}



	public PageHibernateCallback<T> setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}



	@Override
	public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
		
		Query queryObject = session.createQuery(hql);
		
		
		for (int i = 0; i < params.length; i++) {
			queryObject.setParameter(i, params[i]);
		}
		
		//·ÖÒ³
		queryObject.setFirstResult(startIndex);
		queryObject.setMaxResults(pageSize);
		
		
		return queryObject.list();
	}

}
