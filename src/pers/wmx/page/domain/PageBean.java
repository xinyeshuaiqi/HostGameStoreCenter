package pers.wmx.page.domain;

import java.util.List;

public class PageBean <T>{
	//������
	private int currentPage;  //��ǰҳ
	private int count;        //�ܼ�¼��
	private int pageSize;     //ҳ���¼����
	
	//������
	private int startIndex;   //��ʼ����
	private int totalPage;    //��ҳ��
	
	//��ҳ���� 
	private List<T> data;     //ÿҳװ������
	
	public PageBean(int currentPage, int count, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.count = count;
		this.pageSize = pageSize;
		
		//����
		
		//��ʼ����
		this.startIndex=(this.currentPage-1)*this.pageSize;
		
		//�ܷ�ҳ
		this.totalPage=(this.count+this.pageSize-1)/this.pageSize;
	
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}


		
}
