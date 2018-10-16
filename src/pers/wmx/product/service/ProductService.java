package pers.wmx.product.service;

import java.util.List;

import pers.wmx.page.domain.PageBean;
import pers.wmx.product.domain.Product;

public interface ProductService {

	List<Product> findAll();

	void add(Product product);

	void delete(Product product);

	Product findById(Integer id);

	void edit(Product product);

	PageBean<Product> findAll(Product product, int currentPage, int pageSize);

	
	
}
