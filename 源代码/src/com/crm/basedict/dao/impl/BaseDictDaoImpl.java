package com.crm.basedict.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.crm.basedict.dao.BaseDictDao;
import com.crm.basedict.domain.BaseDict;
import com.crm.common.dao.impl.BaseDaoImpl;
/**
 * 该类是数据字典持久层的实现类
 * @author 岑洛彬
 *
 */
public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	public BaseDictDaoImpl() {
		super(BaseDict.class);
		// TODO Auto-generated constructor stub
	}

	public List<BaseDict> findSource() {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ?", "1");
	}

	public List<BaseDict> findChanceComm() {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ?", "2");
	}

	public List<BaseDict> findPermission() {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ?", "3");
	}

	public List<BaseDict> findByTypeCode(String typeCode) {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ?", typeCode);
	}

	public List<String> findAllTypeName() {
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		//根据数据目录名称找出不同的数据
		dc.setProjection(Projections.distinct(Projections.property("dict_type_name")));
		List<String> baseDictList = (List<String>) this.getHibernateTemplate().findByCriteria(dc);
		return baseDictList;
	}

}
