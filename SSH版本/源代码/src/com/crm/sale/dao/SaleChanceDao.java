package com.crm.sale.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.dao.BaseDao;
import com.crm.sale.domain.SaleChance;
/**
 * �����ǿͻ����ۻ���־ò�Ľӿ���
 * @author ����
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
