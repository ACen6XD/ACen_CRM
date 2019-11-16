package com.crm.sale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm.common.dao.impl.BaseDaoImpl;
import com.crm.sale.dao.SaleChanceDao;
import com.crm.sale.domain.SaleChance;
/**
 * 该类是客户销售机会持久层的实现类
 * @author 岑洛彬
 *
 */
public class SaleChanceDaoImpl extends BaseDaoImpl<SaleChance> implements SaleChanceDao {

	public SaleChanceDaoImpl() {
		super(SaleChance.class);
		
	}
	
	//找到没有被支配的记录的数据
	public List<SaleChance> findNullSaleChanceByPage(DetachedCriteria dc,
			Integer currPage, Integer pageSize) {
		dc.setProjection(null);
		dc.add(Restrictions.isNull("sale_respman.user_id"));
		List<SaleChance> saleChanceList = (List<SaleChance>) this.getHibernateTemplate().findByCriteria(dc, (currPage-1)*pageSize, pageSize);
		return saleChanceList;
	}
	
	//找到没有被支配的记录的数量
	public Integer countNullSaleChance(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.isNull("sale_respman.user_id"));
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return null;
	}
	
	//找到分配给指定客户经理的销售机会的记录数量
	public Integer countSaleChanceById(DetachedCriteria dc, Integer integer) {
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq("sale_respman.user_id", integer));
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}
	//找到分配给制定客户经理的销售机会
	public List<SaleChance> findByPerm(DetachedCriteria dc, Integer currPage,
			Integer pageSize, Integer integer) {
		dc.setProjection(null);
		dc.add(Restrictions.eq("sale_respman.user_id", integer));
		return (List<SaleChance>) this.getHibernateTemplate().findByCriteria(dc, (currPage-1)*pageSize, pageSize);
	}

//	public Integer count(DetachedCriteria dc) {
//		dc.setProjection(Projections.rowCount());
//		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
//		if(list.size() > 0 ){
//			return list.get(0).intValue();
//		}
//		return null;
//	}
//
//	public List<SaleChance> findByPage(DetachedCriteria dc, Integer currPage,
//			Integer pageSize) {
//		dc.setProjection(null);
//		dc.addOrder(Order.desc("sale_id"));
//		return (List<SaleChance>) this.getHibernateTemplate().findByCriteria(dc, (currPage-1)*pageSize, pageSize);
//	}
//
//	public void add(SaleChance saleChance) {
//		this.getHibernateTemplate().save(saleChance);
//		
//	}
//
//	public SaleChance findById(Integer sale_id) {
//		return this.getHibernateTemplate().get(SaleChance.class, sale_id);
//	}
//
//	public void delete(SaleChance newSaleChance) {
//		this.getHibernateTemplate().delete(newSaleChance);
//	}
//
//	public void edit(SaleChance saleChance) {
//		this.getHibernateTemplate().update(saleChance);
//		
//	}

}
