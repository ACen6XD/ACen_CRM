package com.crm.sale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.crm.common.dao.impl.BaseDaoImpl;
import com.crm.sale.dao.SaleVistDao;
import com.crm.sale.domain.SaleVist;
import com.crm.user.domain.User;
/**
 * 该类是客户访问记录持久层的实现类
 * @author 岑洛彬
 *
 */
public class SaleVistDaoImpl extends BaseDaoImpl<SaleVist> implements SaleVistDao{

	public SaleVistDaoImpl() {
		super(SaleVist.class);
		// TODO Auto-generated constructor stub
	}

	public Integer countByUser(DetachedCriteria dc, User user) {
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq("sv_user_id.user_id", user.getUser_id()));
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}

	public List<SaleVist> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user) {
		dc.setProjection(null);
		dc.add(Restrictions.eq("sv_user_id.user_id", user.getUser_id()));
		return (List<SaleVist>) this.getHibernateTemplate().findByCriteria(dc, (currPage-1)*pageSize, pageSize);
	}

}
