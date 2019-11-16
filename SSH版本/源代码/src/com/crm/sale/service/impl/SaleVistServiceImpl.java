package com.crm.sale.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.crm.common.domain.PageBean;
import com.crm.sale.dao.SaleVistDao;
import com.crm.sale.domain.SaleVist;
import com.crm.sale.service.SaleVistService;
import com.crm.user.domain.User;
/**
 * 该类是客户访问记录的业务逻辑层的实现类
 * @author 岑洛彬
 *
 */
@Transactional
public class SaleVistServiceImpl implements SaleVistService{
	/**
	 * 依赖注入
	 */
	private SaleVistDao saleVistDao;
	public void setSaleVistDao(SaleVistDao saleVistDao) {
		this.saleVistDao = saleVistDao;
	}
	/**
	 * 查找当前用户下的客户访问记录，并保存在分页实体中
	 */
	public PageBean<SaleVist> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user) {
		PageBean<SaleVist> p = new PageBean<SaleVist>();
		p.setCurrPage(currPage);
		p.setPageSize(pageSize);
		p.setTotalSize(saleVistDao.countByUser(dc,user));
		p.setList(saleVistDao.findByPage(dc, currPage, pageSize,user));
		return p;
	}
	/**
	 * 新增用户
	 */
	public void add(SaleVist saleVist) {
		saleVistDao.add(saleVist);
	}
	/**
	 * 根据id找出用户
	 */
	public SaleVist findById(Integer sv_id) {
		return saleVistDao.findById(sv_id);
	}
	/**
	 * 修改数据
	 */
	public void update(SaleVist saleVist) {
		saleVistDao.edit(saleVist);
	}
	/**
	 * 删除数据
	 */
	public void delete(SaleVist saleVist) {
		saleVistDao.delete(saleVist);
	} 
	
}
