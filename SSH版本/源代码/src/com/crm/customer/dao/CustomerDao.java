package com.crm.customer.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.dao.BaseDao;
import com.crm.customer.domain.Customer;
import com.crm.user.domain.User;
/**
 * �����ǿͻ���ĳ־ò�ӿ���
 * @author ����
 *
 */
public interface CustomerDao extends BaseDao<Customer> {

	Integer countByUser(DetachedCriteria dc, User user);

	List<Customer> findByUser(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user);

	List<Customer> findByUser(User user);

}
