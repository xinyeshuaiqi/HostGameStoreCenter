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
		//1.1 拼凑查询条件
		StringBuilder builder = new StringBuilder();
		//1.2 拼凑实际参数 , 可以重复，顺序 --> List
		List<Object> paramsList = new ArrayList<Object>();
		
		//2 过滤条件
		// 2.1 类别
		if(StringUtils.isNotBlank(product.getCategory())){
			builder.append(" and category like ? ");
			paramsList.add("%"+product.getCategory()+"%");
		}
		
		// 2.2简介
		if(StringUtils.isNotBlank(product.getDescription())){
			builder.append(" and description like ? ");
			paramsList.add("%"+product.getDescription()+"%");
		}
		
		// 2.3 总学时：
		if(StringUtils.isNotBlank(product.getMinPrice())){
			builder.append(" and price >= ? ");
			paramsList.add(Double.parseDouble(product.getMinPrice()));
		}
		if(StringUtils.isNotBlank(product.getMaxPrice())){
			builder.append(" and price <= ? ");
			paramsList.add(Double.parseDouble(product.getMaxPrice()));
		}
		
		
		
		//3 使用
		// 条件 , 格式：" and ..? and ..."
		String condition = builder.toString();
		// 实际参数
		Object[] params = paramsList.toArray();
		
		//总记录数
		int count=this.productDao.getCount(condition,params);
		
		//创建对象
		PageBean<Product> pageBean=new PageBean<>(currentPage, count, pageSize);
		
		//分页数据
		List<Product> data=productDao.findAll(condition, params,pageBean.getStartIndex(),pageSize);
		pageBean.setData(data);
		
		return pageBean;

		
	}
	
	
}
