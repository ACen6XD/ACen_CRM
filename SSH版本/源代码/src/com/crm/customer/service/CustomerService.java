package com.crm.customer.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.domain.PageBean;
import com.crm.customer.domain.Customer;
import com.crm.user.domain.User;
/**
 * 该类是客户类的业务逻辑层的实现类
 * @author 岑洛彬
 *
 */
public interface CustomerService {
	//新增客户
	void add(Customer customer);
	//找到当前用户负责的客户以及分页信息
	PageBean<Customer> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user);
	//根据id找出用户
	Customer findById(Integer cust_id);
	//更新客户
	void edit(Customer customer);
	//删除客户
	void delete(Customer customer);
	//根据当前用户找出所有他负责的客户
	List<Customer> findByUser(User user);
}
