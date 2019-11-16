package com.crm.sale.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.domain.PageBean;
import com.crm.sale.domain.SaleChance;
/**
 * ���������ۻ����ҵ���߼���Ľӿ���
 * @author ����
 *
 */
public interface SaleChanceService {
	//��ѯÿҳ����Ϣ
	PageBean<SaleChance> findByPage(DetachedCriteria dc, 
			Integer currPage, Integer pageSize);

	void add(SaleChance saleChance);

	SaleChance findById(Integer sale_id);

	void delete(SaleChance newSaleChance);

	void edit(SaleChance saleChance);
	
	//�ڿ���������ҳ�и��ݵ�ǰ�ĵ���Ŀͻ�������ʾ�����������ۻ���
	PageBean<SaleChance> findPermisByPage(DetachedCriteria dc,
			Integer currPage, Integer pageSize, Integer integer);

}
