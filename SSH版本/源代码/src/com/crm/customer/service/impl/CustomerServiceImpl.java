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
 * �����ǿͻ����ҵ���߼����ʵ����
 * @author ����
 *
 */
@Transactional
public class CustomerServiceImpl implements CustomerService{
	/**
	 * ����ע��
	 */
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	//��ӿͻ�
	public void add(Customer customer) {
		customerDao.add(customer);
	}
	
	//�ҵ���ǰ�û�����Ŀͻ��Լ���ҳ��Ϣ
	public PageBean<Customer> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		//���õ�ǰҳ��
		pageBean.setCurrPage(currPage);
		//����ÿҳ��ʾ����
		pageBean.setPageSize(pageSize);
		//������������
		pageBean.setTotalSize(customerDao.countByUser(dc,user));
		//����ÿҳ��ʾ���б�
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
