package com.crm.sale.dao;

import java.util.List;

import com.crm.common.dao.BaseDao;
import com.crm.sale.domain.SalePlan;
/**
 * 该类是客户开发计划机会持久层的接口类
 * @author 岑洛彬
 *
 */
public interface SalePlanDao extends BaseDao<SalePlan> {

	List<SalePlan> findByChanceId(Integer sale_id);

}
