package com.crm.sale.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.dao.BaseDao;
import com.crm.sale.domain.SaleChance;
/**
 * 该类是客户销售机会持久层的接口类
 * @author 岑洛彬
 *
 */
public interface SaleChanceDao extends BaseDao<SaleChance> {

	List<SaleChance> findNullSaleChanceByPage(DetachedCriteria dc,
			Integer currPage, Integer pageSize);

	Integer countNullSaleChance(DetachedCriteria dc);

	Integer countSaleChanceById(DetachedCriteria dc, Integer integer);

	List<SaleChance> findByPerm(DetachedCriteria dc, Integer currPage,
			Integer pageSize, Integer integer);

}
