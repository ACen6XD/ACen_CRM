package com.crm.basedict.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.basedict.domain.BaseDict;
import com.crm.common.domain.PageBean;
/**
 * 该类是数据字典层的业务逻辑层接口
 * @author 岑洛彬
 *
 */
public interface BaseDictService {
	/**
	 * 根据机会来源查找数据字典的类别
	 * @param 无
	 * @return 数据字典集合
	 * @return
	 */
	List<BaseDict> findSource();
	/**
	 * 根据机会描述来源查找数据字典的类别
	 * @param 无
	 * @return 数据字典集合
	 * @return
	 */
	List<BaseDict> findChanceComm();
	/**
	 * 根据用户权限来源查找数据字典的类别
	 * @param 无
	 * @return 数据字典集合
	 * @return
	 */
	List<BaseDict> findPermission();
	/**
	 * 根据类别代码来源查找数据字典的类别
	 * @param 无
	 * @return 数据字典集合
	 * @return
	 */
	List<BaseDict> findByTypeCode(String typeCode);
	/**
	 * 根据id来源查找数据字典的类别
	 * @param 无
	 * @return 数据字典集合
	 * @return
	 */
	BaseDict findById(String dict_id);
	/**
	 * 根据分页信息来源查找数据字典的类别
	 * @param 离线查询 ，首页，每页显示的量
	 * @return 分页实体
	 * @return
	 */
	PageBean<BaseDict> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize);
	/**
	 * 查找所有类别名称
	 * @param 无
	 * @return 数据字典集合
	 * @return
	 */
	List<String> findAllTypeName();
	/**
	 * 修改实体
	 * @param 要修改的实体
	 * @return 无
	 * @return
	 */
	void edit(BaseDict baseDict);
	/**
	 * 新增实体
	 * @param 要增加的实体
	 * @return 无
	 * @return
	 */
	void save(BaseDict baseDict);
	/**
	 * 删除数据
	 * @param 要删除的实体
	 * @return 无
	 * @return
	 */
	void delete(BaseDict baseDict);
}
