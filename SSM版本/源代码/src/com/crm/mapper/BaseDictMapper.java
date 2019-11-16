package com.crm.mapper;

import java.util.List;

import com.crm.pojo.BaseDict;

/**
 * 数据字典类的接口类
 * @author 岑洛彬
 *
 */
public interface BaseDictMapper {
	List<BaseDict> findByTypeCode(String dict_type_code);
}
