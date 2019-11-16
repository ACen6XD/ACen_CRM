package com.crm.sale.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.domain.PageBean;
import com.crm.sale.domain.SaleChance;
/**
 * 该类是销售机会的业务逻辑层的接口类
 * @author 岑洛彬
 *
 */
public interface SaleChanceService {
	//查询每页的信息
	PageBean<SaleChance> findByPage(DetachedCriteria dc, 
			Integer currPage, Integer pageSize);

	void add(SaleChance saleChance);

	SaleChance findById(Integer sale_id);

	void delete(SaleChance newSaleChance);

	void edit(SaleChance saleChance);
	
	//在开发机会首页中根据当前的登入的客户经理显示属于他的销售机会
	PageBean<SaleChance> findPermisByPage(DetachedCriteria dc,
			Integer currPage, Integer pageSize, Integer integer);

}
