package com.crm.sale.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.dao.BaseDao;
import com.crm.sale.domain.SaleVist;
import com.crm.user.domain.User;
/**
 * 该类是客户访问记录的持久层的接口类
 * @author 岑洛彬
 *
 */
public interface SaleVistDao extends BaseDao<SaleVist>{

	Integer countByUser(DetachedCriteria dc, User user);

	List<SaleVist> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user);

}
