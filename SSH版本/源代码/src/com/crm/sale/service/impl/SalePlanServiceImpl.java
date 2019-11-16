package com.crm.sale.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.crm.sale.dao.SalePlanDao;
import com.crm.sale.domain.SalePlan;
import com.crm.sale.service.SalePlanService;
/**
 * 该类是销售开发计划的业务逻辑层的实现类
 * @author 岑洛彬
 *
 */
@Transactional
public class SalePlanServiceImpl implements SalePlanService {
	/**
	 * 依赖注入
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
