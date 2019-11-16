package com.crm.sale.dao.impl;

import java.util.List;

import com.crm.common.dao.impl.BaseDaoImpl;
import com.crm.sale.dao.SalePlanDao;
import com.crm.sale.domain.SalePlan;
/**
 * �����ǿͻ���������־ò��ʵ����
 * @author ����
 *
 */
public class SalePlanDaoImpl extends BaseDaoImpl<SalePlan> implements SalePlanDao {

	public SalePlanDaoImpl() {
		super(SalePlan.class);
	}
	
	//�������ۻ����id��ѯ�ͻ���¼
	public List<SalePlan> findByChanceId(Integer sale_id) {
		return (List<SalePlan>) this.getHibernateTemplate().find("from SalePlan where plan_salechance.sale_id = ? ", sale_id);
	}

}
