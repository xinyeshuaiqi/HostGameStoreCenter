package pers.wmx.orderitem.domain;

import pers.wmx.order.domain.Order;
import pers.wmx.product.domain.Product;

public class OrderItem {
	//多持有一，多对一
	//每一个订单项有一种商品里
	
	private Integer id;
	private Order order;//订单
	private Product product; //商品
	private int buynum; //购物数量
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
		
}
