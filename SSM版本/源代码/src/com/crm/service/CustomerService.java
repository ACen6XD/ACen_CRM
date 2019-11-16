package com.crm.service;

import java.util.List;

import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;
import com.crm.utils.Page;

/**
 * 该类是客户的业务逻辑层接口
 * @author 岑洛彬
 *
 */
public interface CustomerService {
	/**
	 * 根据综合条件分页查询客户
	 * @param string
	 * @return
	 */
	Page<Customer> findByTypeCode(QueryVo qo);
	
	/**
	 * 根据用户id查找用户
	 * @param id
	 * @return
	 */
	Customer findById(Integer id);
	
	/**
	 * 更新客户
	 * @param customer
	 */
	void update(Customer customer);
	
	/**
	 * 删除用户
	 * @param id
	 */
	void delete(Integer id);

}
