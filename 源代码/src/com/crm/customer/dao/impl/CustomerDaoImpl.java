package com.crm.customer.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.crm.common.dao.impl.BaseDaoImpl;
import com.crm.customer.dao.CustomerDao;
import com.crm.customer.domain.Customer;
import com.crm.user.domain.User;
/**
 * 该类是客户类的持久层的实现类
 * @author 岑洛彬
 *
 */
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	public CustomerDaoImpl() {
		super(Customer.class);
	}
	/**
	 * 找出当前用户下的客户记录数
	 */
	public Integer countByUser(DetachedCriteria dc, User user) {
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq("cust_respman.user_id", user.getUser_id()));
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}
	/**
	 * 分页找出当前用户下的客户记录
	 */
	public List<Customer> findByUser(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user) {
		dc.setProjection(null);
		dc.add(Restrictions.eq("cust_respman.user_id", user.getUser_id()));
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(dc,(currPage-1)*pageSize,pageSize);
		return list;
	}
	/**
	 * 找出当前用户名下所有的客户
	 */
	public List<Customer> findByUser(User user) {
		return (List<Customer>) this.getHibernateTemplate().find("from Customer where cust_respman.user_id =? ", user.getUser_id());
	}

}
