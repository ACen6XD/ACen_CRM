package com.crm.sale.dao;

import java.util.List;

import com.crm.common.dao.BaseDao;
import com.crm.sale.domain.SalePlan;
/**
 * �����ǿͻ������ƻ�����־ò�Ľӿ���
 * @author ����
 *
 */
public interface SalePlanDao extends BaseDao<SalePlan> {

	List<SalePlan> findByChanceId(Integer sale_id);

}
