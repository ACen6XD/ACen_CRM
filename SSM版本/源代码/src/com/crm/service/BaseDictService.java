package com.crm.service;

import java.util.List;

import com.crm.pojo.BaseDict;

/**
 * 该类是数据字典的业务逻辑层接口
 * @author 岑洛彬
 *
 */
public interface BaseDictService {
	/**
	 * 根据类别代码查找项目名称
	 * @param string
	 * @return
	 */
	List<BaseDict> findByTypeCode(String string);

}
