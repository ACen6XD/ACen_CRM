package com.crm.common.domain;

import java.util.List;

/**
 * ��ҳ��ʵ����
 * @author ����
 *
 */
public class PageBean<T> {
	private Integer currPage;//��ǰҳ
	private Integer pageSize;//ÿҳ��ʾ������
	private Integer totalSize;//��¼����
	private Integer totalPage;//�ܵ�ҳ��
	private List<T> list;//ÿҳ��Ҫ��ʾ�ļ�������
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
