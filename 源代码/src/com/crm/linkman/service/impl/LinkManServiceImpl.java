package com.crm.linkman.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.crm.common.domain.PageBean;
import com.crm.linkman.dao.LinkManDao;
import com.crm.linkman.domain.LinkMan;
import com.crm.linkman.service.LinkManService;
import com.crm.user.domain.User;
/**
 * ��������ϵ�˵�ҵ���߼����ʵ����
 * @author ����
 *
 */
@Transactional
public class LinkManServiceImpl implements LinkManService {
	/**
	 * ����ע��
	 */
	private LinkManDao linkManDao;
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	/**
	 * �������е���ϵ��
	 */
	public PageBean<LinkMan> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user) {
		PageBean<LinkMan> pageBean = new PageBean<LinkMan>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalSize(linkManDao.countByUser(dc,user));
		pageBean.setList(linkManDao.findByPage(dc, (currPage-1)*pageSize, pageSize,user));
		return pageBean;
	}
	/**
	 * ������ϵ��
	 */
	public void save(LinkMan linkMan) {
		linkManDao.add(linkMan);
	}
	/**
	 * ����id�ҳ�Ҫ���в�������ϵ��ʵ��
	 */
	public LinkMan findById(Integer lkm_id) {
		return linkManDao.findById(lkm_id);
	}
	/**
	 * ��������
	 */
	public void edit(LinkMan linkMan) {
		linkManDao.edit(linkMan);
	}
	/**
	 * ɾ��ʵ��
	 */
	public void delete(LinkMan linkMan) {
		linkManDao.delete(linkMan);
	}
	/**
	 * ���ݿͻ�id�����ϵ��
	 */

	public PageBean<LinkMan> findByCust(DetachedCriteria dc,Integer currPage, Integer pageSize,
			Integer cust_id) {
		PageBean<LinkMan> pageBean = new PageBean<LinkMan>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalSize(linkManDao.countByCust(dc,cust_id));
		pageBean.setList(linkManDao.findByCust(dc, (currPage-1)*pageSize, pageSize,cust_id));
		return pageBean;
	}
	
}
