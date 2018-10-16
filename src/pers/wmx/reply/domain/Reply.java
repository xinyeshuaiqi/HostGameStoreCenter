package pers.wmx.reply.domain;

import java.util.Date;

import pers.wmx.product.domain.Product;
import pers.wmx.user.domain.User;


public class Reply {
	
	private Integer id;
	
	private String replyContent;	//�ظ�������
	
	private Date createDate;		//����ʱ��
	
	//���һ�� һ����ҿ��Զ�һ����Ʒ�ж������
	private Product product;
	private User user;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

			
}
