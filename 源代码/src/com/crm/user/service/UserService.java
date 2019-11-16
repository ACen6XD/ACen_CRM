package com.crm.user.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.domain.PageBean;
import com.crm.sale.domain.SaleChance;
import com.crm.user.domain.User;
/**
 * 该类是用户业务逻辑层的接口类
 * @author 岑洛彬
 *
 */
public interface UserService {
	//注册新用户
	void add(User user);
	//用户登入
	User login(User user);
	//根据注册id判断是否存在该账户
	User findByLoginName(String user_loginname);
	//根据权限查找用户
	List<User> findByPermis(String permis);
	//根据id查找用户
	User findById(Integer user_id);
	//按分页查找出所有用户
	PageBean<User> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize);
	//修改用户
	void edit(User user);
	//删除用户
	void delete(User user);
	

}
