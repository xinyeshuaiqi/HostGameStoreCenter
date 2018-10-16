package pers.wmx.product.dao;

import java.util.List;

import pers.wmx.product.domain.Product;

public interface ProductDao {

	List<Product> findAll();

	void add(Product product);

	void delete(Product product);

	Product findById(Integer id);

	void update(Product product);

	int getCount(String condition, Object[] params);

	List<Product> findAll(String condition, Object[] params, int startIndex, int pageSize);

}
