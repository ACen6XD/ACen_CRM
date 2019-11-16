package com.crm.common.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.sale.domain.SaleChance;

/**
 * ����������dao���ģ����
 * @author ����
 *
 */
public interface BaseDao<T> {
	Integer count(DetachedCriteria dc);

	List<T> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize);

	void add(T t);

	T findById(Serializable sale_id);

	void delete(T t);

	void edit(T t);
	
	void merge(T t);
}
