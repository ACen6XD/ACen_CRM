package com.crm.customer.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.dao.BaseDao;
import com.crm.customer.domain.Customer;
import com.crm.user.domain.User;
/**
 * 该类是客户类的持久层接口类
 * @author 岑洛彬
 *
 */
public interface CustomerDao extends BaseDao<Customer> {

	Integer countByUser(DetachedCriteria dc, User user);

	List<Customer> findByUser(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user);

	List<Customer> findByUser(User user);

}
