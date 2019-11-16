package com.crm.sale.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.crm.common.domain.PageBean;
import com.crm.sale.dao.SaleChanceDao;
import com.crm.sale.domain.SaleChance;
import com.crm.sale.service.SaleChanceService;
/**
 * ���������ۻ����ҵ���߼����ʵ����
 * @author ����
 *
 */
@Transactional
public class SaleChanceServiceImpl implements SaleChanceService {
	//����ע��
	private SaleChanceDao saleChanceDao;
	public void setSaleChanceDao(SaleChanceDao saleChanceDao) {
		this.saleChanceDao = saleChanceDao;
	}
	
	//��ѯÿҳ����Ϣ
	public PageBean<SaleChance> findByPage(DetachedCriteria dc,
			Integer currPage, Integer pageSize) {
		//�½�һ��ʵ�������洢��Ӧ��Ϣ
		PageBean<SaleChance> pageBean = new PageBean<SaleChance>();
		//�趨��ʼҳ��
		pageBean.setCurrPage(currPage);
		//ÿҳ��ʾ������
		pageBean.setPageSize(pageSize);
		//ʵ���м�¼����
		pageBean.setTotalSize(saleChanceDao.countNullSaleChance(dc));
		//ʵ����ÿҳ��ʾ������
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
