package com.crm.sale.dao.impl;

import java.util.List;

import com.crm.common.dao.impl.BaseDaoImpl;
import com.crm.sale.dao.SalePlanDao;
import com.crm.sale.domain.SalePlan;
/**
 * 该类是客户开发机会持久层的实现类
 * @author 岑洛彬
 *
 */
public class SalePlanDaoImpl extends BaseDaoImpl<SalePlan> implements SalePlanDao {

	public SalePlanDaoImpl() {
		super(SalePlan.class);
	}
	
	//根据销售机会的id查询客户记录
	public List<SalePlan> findByChanceId(Integer sale_id) {
		return (List<SalePlan>) this.getHibernateTemplate().find("from SalePlan where plan_salechance.sale_id = ? ", sale_id);
	}

}
