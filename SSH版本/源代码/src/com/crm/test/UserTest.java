package com.crm.test;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crm.common.domain.PageBean;
import com.crm.sale.service.SaleChanceService;
import com.crm.user.domain.User;
import com.crm.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {
	@Resource(name="userService")
	private UserService ss;
	
	@Test
	public void demo1(){
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		PageBean<User> pageBean = ss.findByPage(dc, 0, 3);
		System.out.println(pageBean.getList().get(0).getUser_loginname());
	}
}
