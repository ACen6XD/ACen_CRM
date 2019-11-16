package com.crm.common.domain;

import java.util.List;

/**
 * 分页的实体类
 * @author 岑洛彬
 *
 */
public class PageBean<T> {
	private Integer currPage;//当前页
	private Integer pageSize;//每页显示的数量
	private Integer totalSize;//记录总数
	private Integer totalPage;//总的页数
	private List<T> list;//每页需要显示的集合数据
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public Integer getTotalPage() {
		return (totalSize%pageSize==0)?totalSize/pageSize:totalSize/pageSize+1;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
