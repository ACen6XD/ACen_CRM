package com.crm.sale.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.crm.sale.dao.SalePlanDao;
import com.crm.sale.domain.SalePlan;
import com.crm.sale.service.SalePlanService;
/**
 * ���������ۿ����ƻ���ҵ���߼����ʵ����
 * @author ����
 *
 */
@Transactional
public class SalePlanServiceImpl implements SalePlanService {
	/**
	 * ����ע��
	 */
	private SalePlanDao salePlanDao;
	public void setSalePlanDao(SalePlanDao salePlanDao) {
		this.salePlanDao = salePlanDao;
	}
	
	public void add(SalePlan salePlan) {
		salePlanDao.add(salePlan);
	}

	public List<SalePlan> findByChanceId(Integer sale_id) {
		return salePlanDao.findByChanceId(sale_id);
	}

	public SalePlan findById(Integer plan_id) {
		return salePlanDao.findById(plan_id);
	}

	public void delete(SalePlan delSalePlan) {
		salePlanDao.delete(delSalePlan);
	}

	public void update(SalePlan salePlan) {
		salePlanDao.merge(salePlan);
	}
	
}
