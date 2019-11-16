package com.crm.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm.common.dao.BaseDao;
/**
 * ����������ģ�����ʵ����
 * @author ����
 *
 * @param <T>
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;
	public BaseDaoImpl(Class clazz){
		this.clazz = clazz;
	}
	//��ȡ���м�¼����
	public Integer count(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}
	
	//��ȡÿһҳ��ʾ������
	public List<T> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize) {
		dc.setProjection(null);
		return (List<T>) this.getHibernateTemplate().findByCriteria(dc,(currPage-1)* pageSize, pageSize);
	}
	
	//���������
	public void add(T t) {
		this.getHibernateTemplate().save(t);
		
	}
	//����id�ҳ�����
	public T findById(Serializable sale_id) {
		return (T) this.getHibernateTemplate().get(clazz, sale_id);
	}
	//ɾ��ָ��������
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
		
	}
	//�޸�ָ��������
	public void edit(T t) {
		this.getHibernateTemplate().update(t);
	}
	//����ʵ�壬������ݿ���û�����ʵ���id��������
	public void merge(T t) {
		this.getHibernateTemplate().merge(t);
	}
	
}
