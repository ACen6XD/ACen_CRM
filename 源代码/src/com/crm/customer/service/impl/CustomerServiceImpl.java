package com.crm.customer.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.crm.common.domain.PageBean;
import com.crm.customer.dao.CustomerDao;
import com.crm.customer.domain.Customer;
import com.crm.customer.service.CustomerService;
import com.crm.user.domain.User;
/**
 * 该类是客户类的业务逻辑层的实现类
 * @author 岑洛彬
 *
 */
@Transactional
public class CustomerServiceImpl implements CustomerService{
	/**
	 * 依赖注入
	 */
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	//添加客户
	public void add(Customer customer) {
		customerDao.add(customer);
	}
	
	//找到当前用户负责的客户以及分页信息
	public PageBean<Customer> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		//设置当前页数
		pageBean.setCurrPage(currPage);
		//设置每页显示的量
		pageBean.setPageSize(pageSize);
		//设置数据总数
		pageBean.setTotalSize(customerDao.countByUser(dc,user));
		//设置每页显示的列表
		pageBean.setList(customerDao.findByUser(dc,currPage,pageSize,user));
		return pageBean;
	}

	public Customer findById(Integer cust_id) {
		return customerDao.findById(cust_id);
	}

	public void edit(Customer customer) {
		customerDao.merge(customer);
	}

	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	public List<Customer> findByUser(User user) {
		return customerDao.findByUser(user);
	}
	
}
