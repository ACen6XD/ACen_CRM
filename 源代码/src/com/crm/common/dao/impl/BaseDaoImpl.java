package com.crm.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm.common.dao.BaseDao;
/**
 * 该类是所有模板类的实现类
 * @author 岑洛彬
 *
 * @param <T>
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;
	public BaseDaoImpl(Class clazz){
		this.clazz = clazz;
	}
	//获取表中记录总数
	public Integer count(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}
	
	//获取每一页显示的数据
	public List<T> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize) {
		dc.setProjection(null);
		return (List<T>) this.getHibernateTemplate().findByCriteria(dc,(currPage-1)* pageSize, pageSize);
	}
	
	//添加新数据
	public void add(T t) {
		this.getHibernateTemplate().save(t);
		
	}
	//根据id找出数据
	public T findById(Serializable sale_id) {
		return (T) this.getHibernateTemplate().get(clazz, sale_id);
	}
	//删除指定的数据
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
		
	}
	//修改指定的数据
	public void edit(T t) {
		this.getHibernateTemplate().update(t);
	}
	//更新实体，如果数据库中没有这个实体的id则变成新增
	public void merge(T t) {
		this.getHibernateTemplate().merge(t);
	}
	
}
