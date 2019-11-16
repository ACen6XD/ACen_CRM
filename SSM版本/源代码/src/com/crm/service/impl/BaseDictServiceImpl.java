package com.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.mapper.BaseDictMapper;
import com.crm.pojo.BaseDict;
import com.crm.service.BaseDictService;
/**
 * 该类是业务逻辑层的实现类
 * @author 岑洛彬
 *
 */
@Service
public class BaseDictServiceImpl implements BaseDictService {
	/**
	 * 注入持久层对象
	 */
	@Autowired
	private BaseDictMapper baseDictMapper;
	
	/**
	 * 实现接口中的方法
	 */
	public List<BaseDict> findByTypeCode(String string) {
		return baseDictMapper.findByTypeCode(string);
	}
}
