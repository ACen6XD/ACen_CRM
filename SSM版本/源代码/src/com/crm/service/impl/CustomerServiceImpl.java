package com.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.mapper.CustomerMapper;
import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;
import com.crm.service.CustomerService;
import com.crm.utils.Page;
/**
 * 客户的业务逻辑层实现类
 * @author 岑洛彬
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	//注入持久层
	@Autowired
	private CustomerMapper customerMapper;
	
	/**
	 * 实现接口未实现的方法
	 */
	public Page<Customer> findByTypeCode(QueryVo qo) {
		//新建一个分页实体
		Page<Customer> page = new Page<Customer>();
		//为实体设置当前页
		page.setPage(qo.getPage());
		//为实体设置每页显示数据量
		page.setSize(qo.getRows());
		//为实体设置记录总数
		page.setTotal(customerMapper.countByQueryVo(qo));
		//为实体设置每页显示的客户信息
		page.setRows(customerMapper.findByQueryVo(qo));
		return page;
	}

	public Customer findById(Integer id) {
		return customerMapper.findById(id);
	}

	public void update(Customer customer) {
		
		customerMapper.update(customer);
	}

	public void delete(Integer id) {
		customerMapper.delete(id);
	}

}
