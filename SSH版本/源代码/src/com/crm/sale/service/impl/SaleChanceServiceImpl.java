package com.crm.sale.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.crm.common.domain.PageBean;
import com.crm.sale.dao.SaleChanceDao;
import com.crm.sale.domain.SaleChance;
import com.crm.sale.service.SaleChanceService;
/**
 * 该类是销售机会的业务逻辑层的实现类
 * @author 岑洛彬
 *
 */
@Transactional
public class SaleChanceServiceImpl implements SaleChanceService {
	//依赖注入
	private SaleChanceDao saleChanceDao;
	public void setSaleChanceDao(SaleChanceDao saleChanceDao) {
		this.saleChanceDao = saleChanceDao;
	}
	
	//查询每页的信息
	public PageBean<SaleChance> findByPage(DetachedCriteria dc,
			Integer currPage, Integer pageSize) {
		//新建一个实体用来存储相应信息
		PageBean<SaleChance> pageBean = new PageBean<SaleChance>();
		//设定起始页码
		pageBean.setCurrPage(currPage);
		//每页显示的数量
		pageBean.setPageSize(pageSize);
		//实体中记录总数
		pageBean.setTotalSize(saleChanceDao.countNullSaleChance(dc));
		//实体中每页显示的数据
		pageBean.setList(saleChanceDao.findNullSaleChanceByPage(dc,currPage,pageSize));
		return pageBean;
	}

	public void add(SaleChance saleChance) {
		saleChanceDao.add(saleChance);
		
	}

	public SaleChance findById(Integer sale_id) {
		return saleChanceDao.findById(sale_id);
	}

	public void delete(SaleChance newSaleChance) {
		saleChanceDao.delete(newSaleChance);
		
	}

	public void edit(SaleChance saleChance) {
		saleChanceDao.edit(saleChance);
		
	}

	public PageBean<SaleChance> findPermisByPage(DetachedCriteria dc,
			Integer currPage, Integer pageSize, Integer integer) {
		PageBean<SaleChance> pageBean = new PageBean<SaleChance>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalSize(saleChanceDao.countSaleChanceById(dc,integer));
		pageBean.setList(saleChanceDao.findByPerm(dc,currPage,pageSize,integer));
		return pageBean;
	}
	
}
