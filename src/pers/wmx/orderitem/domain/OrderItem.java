package pers.wmx.orderitem.domain;

import pers.wmx.order.domain.Order;
import pers.wmx.product.domain.Product;

public class OrderItem {
	//�����һ�����һ
	//ÿһ����������һ����Ʒ��
	
	private Integer id;
	private Order order;//����
	private Product product; //��Ʒ
	private int buynum; //��������
	
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
