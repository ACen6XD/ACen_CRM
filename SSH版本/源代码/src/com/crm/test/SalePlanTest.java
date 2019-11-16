package com.crm.test;

import javax.annotation.Resource;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crm.common.domain.PageBean;
import com.crm.sale.domain.SaleChance;
import com.crm.sale.domain.SalePlan;
import com.crm.sale.service.SaleChanceService;
import com.crm.sale.service.SalePlanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SalePlanTest {

	@Resource(name="saleChanceService")
	private SaleChanceService ss;
	@Resource(name="salePlanService")
	private SalePlanService ps;
	
	@Test
	public void demo1(){
		DetachedCriteria dc = DetachedCriteria.forClass(SaleChance.class);
		PageBean<SaleChance> pageBean = ss.findPermisByPage(dc, 0, 3, 2);
		for (SaleChance sc : pageBean.getList()) {
			System.out.println(sc.getSale_name());
		}
	}
	
	@Test
	public void demo2(){
		SalePlan s = new SalePlan();
		s.setPlan_date("111");
		s.setPlan_message("111");
		s.setPlan_result("sss");
		ps.add(s);
	}
}
