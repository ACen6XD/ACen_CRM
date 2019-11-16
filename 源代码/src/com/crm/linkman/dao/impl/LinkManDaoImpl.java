package com.crm.linkman.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.crm.common.dao.impl.BaseDaoImpl;
import com.crm.linkman.dao.LinkManDao;
import com.crm.linkman.domain.LinkMan;
import com.crm.user.domain.User;
/**
 * 该类是联系人持久层的实现类
 * @author 岑洛彬
 *
 */
public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao{

	public LinkManDaoImpl() {
		super(LinkMan.class);
		// TODO Auto-generated constructor stub
	}
	
	public Integer countByUser(DetachedCriteria dc, User user) {
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq("lkm_user.user_id", user.getUser_id()));
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}

	public List<LinkMan> findByPage(DetachedCriteria dc, int i,
			Integer pageSize, User user) {
		dc.setProjection(null);
		dc.add(Restrictions.eq("lkm_user.user_id", user.getUser_id()));
		return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(dc, i, pageSize);
	}


	public Integer countByCust(DetachedCriteria dc, Integer cust_id) {
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq("lkm_customer.cust_id", cust_id));
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}

	public List<LinkMan> findByCust(DetachedCriteria dc, int i,
			Integer pageSize, Integer cust_id) {
		dc.setProjection(null);
		dc.add(Restrictions.eq("lkm_customer.cust_id", cust_id));
		return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(dc, i, pageSize);
	}


}
