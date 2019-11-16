package com.crm.sale.service;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.domain.PageBean;
import com.crm.sale.domain.SaleVist;
import com.crm.user.domain.User;
/**
 *  该类是客户访问记录的业务逻辑层的接口类
 * @author 岑洛彬
 *
 */
public interface SaleVistService {

	PageBean<SaleVist> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user);

	void add(SaleVist saleVist);

	SaleVist findById(Integer sv_id);

	void update(SaleVist saleVist);

	void delete(SaleVist saleVist);

}
