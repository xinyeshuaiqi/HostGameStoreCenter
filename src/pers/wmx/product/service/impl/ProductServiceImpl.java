package pers.wmx.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


import pers.wmx.page.domain.PageBean;
import pers.wmx.product.dao.ProductDao;
import pers.wmx.product.domain.Product;
import pers.wmx.product.service.ProductService;

public class ProductServiceImpl implements ProductService{
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

		
	@Override
	public List<Product> findAll() {
		
		return productDao.findAll();
	}



	@Override
	public void add(Product product) {
		productDao.add(product);
		
	}


	@Override
	public void delete(Product product) {
		productDao.delete(product);
		
	}


	@Override
	public Product findById(Integer id) {
		
		return productDao.findById(id);
	}


	@Override
	public void edit(Product product) {
		productDao.update(product);
		
	}


	@Override
	public PageBean<Product> findAll(Product product, int currentPage, int pageSize) {
		//1.1 ƴ�ղ�ѯ����
		StringBuilder builder = new StringBuilder();
		//1.2 ƴ��ʵ�ʲ��� , �����ظ���˳�� --> List
		List<Object> paramsList = new ArrayList<Object>();
		
		//2 ��������
		// 2.1 ���
		if(StringUtils.isNotBlank(product.getCategory())){
			builder.append(" and category like ? ");
			paramsList.add("%"+product.getCategory()+"%");
		}
		
		// 2.2���
		if(StringUtils.isNotBlank(product.getDescription())){
			builder.append(" and description like ? ");
			paramsList.add("%"+product.getDescription()+"%");
		}
		
		// 2.3 ��ѧʱ��
		if(StringUtils.isNotBlank(product.getMinPrice())){
			builder.append(" and price >= ? ");
			paramsList.add(Double.parseDouble(product.getMinPrice()));
		}
		if(StringUtils.isNotBlank(product.getMaxPrice())){
			builder.append(" and price <= ? ");
			paramsList.add(Double.parseDouble(product.getMaxPrice()));
		}
		
		
		
		//3 ʹ��
		// ���� , ��ʽ��" and ..? and ..."
		String condition = builder.toString();
		// ʵ�ʲ���
		Object[] params = paramsList.toArray();
		
		//�ܼ�¼��
		int count=this.productDao.getCount(condition,params);
		
		//��������
		PageBean<Product> pageBean=new PageBean<>(currentPage, count, pageSize);
		
		//��ҳ����
		List<Product> data=productDao.findAll(condition, params,pageBean.getStartIndex(),pageSize);
		pageBean.setData(data);
		
		return pageBean;

		
	}
	
	
}
