package com.crm.test;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crm.common.domain.PageBean;
import com.crm.linkman.domain.LinkMan;
import com.crm.linkman.service.LinkManService;
import com.crm.sale.service.SaleChanceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class LinkManTest {
	@Resource(name="linkManService")
	private LinkManService lms;
	
	@Test
	public void demo1(){
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		PageBean<LinkMan> bean = lms.findByCust(dc, 0, 3, 7);
		System.out.println(bean.getList().get(0).getLkm_name());
	}
}
