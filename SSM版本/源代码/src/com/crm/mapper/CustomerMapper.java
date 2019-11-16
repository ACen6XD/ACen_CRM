package com.crm.mapper;

import java.util.List;

import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;

/**
 * 客户的持久层接口类
 * @author 岑洛彬
 *
 */
public interface CustomerMapper {
	/**
	 * 根据综合条件查找客户信息
	 * @param qo
	 * @return
	 */
	List<Customer> findByQueryVo(QueryVo qo);
	
	/**
	 * 根据综合条件查询满足条件的记录总数
	 * @param qo
	 * @return
	 */
	int countByQueryVo(QueryVo qo);
	
	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	Customer findById(Integer id);
	
	/**
	 * 更新用户
	 * @param customer
	 */
	void update(Customer customer);

	/**
	 * 删除用户
	 * @param id
	 */
	void delete(Integer id);
}
