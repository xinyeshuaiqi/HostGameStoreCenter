package pers.wmx.page.domain;

import java.util.List;

public class PageBean <T>{
	//基本项
	private int currentPage;  //当前页
	private int count;        //总记录数
	private int pageSize;     //页面记录条数
	
	//计算项
	private int startIndex;   //开始索引
	private int totalPage;    //总页数
	
	//分页数据 
	private List<T> data;     //每页装的数据
	
	public PageBean(int currentPage, int count, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.count = count;
		this.pageSize = pageSize;
		
		//计算
		
		//开始索引
		this.startIndex=(this.currentPage-1)*this.pageSize;
		
		//总分页
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
