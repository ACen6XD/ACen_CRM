package com.crm.sale.service;

import java.util.List;

import com.crm.sale.domain.SalePlan;
/**
 *  该类是销售开发计划的业务逻辑层的接口类
 * @author 岑洛彬
 *
 */
public interface SalePlanService {
	//增加数据
	void add(SalePlan salePlan);
	//通过销售机会的id来获取销售计划
	List<SalePlan> findByChanceId(Integer sale_id);
	//通过id获取数据
	SalePlan findById(Integer plan_id);
	//删除数据
	void delete(SalePlan delSalePlan);
	//更新数据
	void update(SalePlan salePlan);

}
