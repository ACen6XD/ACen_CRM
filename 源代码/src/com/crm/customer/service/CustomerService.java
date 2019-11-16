package com.crm.customer.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.domain.PageBean;
import com.crm.customer.domain.Customer;
import com.crm.user.domain.User;
/**
 * �����ǿͻ����ҵ���߼����ʵ����
 * @author ����
 *
 */
public interface CustomerService {
	//�����ͻ�
	void add(Customer customer);
	//�ҵ���ǰ�û�����Ŀͻ��Լ���ҳ��Ϣ
	PageBean<Customer> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user);
	//����id�ҳ��û�
	Customer findById(Integer cust_id);
	//���¿ͻ�
	void edit(Customer customer);
	//ɾ���ͻ�
	void delete(Customer customer);
	//���ݵ�ǰ�û��ҳ�����������Ŀͻ�
	List<Customer> findByUser(User user);
}
