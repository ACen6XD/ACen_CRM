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
 * 该类是联系人的业务逻辑层的实现类
 * @author 岑洛彬
 *
 */
@Transactional
public class LinkManServiceImpl implements LinkManService {
	/**
	 * 依赖注入
	 */
	private LinkManDao linkManDao;
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	/**
	 * 查找所有的联系人
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
	 * 新增联系人
	 */
	public void save(LinkMan linkMan) {
		linkManDao.add(linkMan);
	}
	/**
	 * 根据id找出要进行操作的联系人实体
	 */
	public LinkMan findById(Integer lkm_id) {
		return linkManDao.findById(lkm_id);
	}
	/**
	 * 更新数据
	 */
	public void edit(LinkMan linkMan) {
		linkManDao.edit(linkMan);
	}
	/**
	 * 删除实体
	 */
	public void delete(LinkMan linkMan) {
		linkManDao.delete(linkMan);
	}
	/**
	 * 根据客户id查出联系人
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
