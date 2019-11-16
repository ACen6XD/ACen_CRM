package com.crm.basedict.dao;
/**
 * 该类是数据字典的持久层接口
 */
import java.util.List;

import com.crm.basedict.domain.BaseDict;
import com.crm.common.dao.BaseDao;

public interface BaseDictDao extends BaseDao<BaseDict>{

	List<BaseDict> findSource();

	List<BaseDict> findChanceComm();

	List<BaseDict> findPermission();

	List<BaseDict> findByTypeCode(String typeCode);

	List<String> findAllTypeName();

}
