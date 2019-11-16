package com.crm.user.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.crm.common.domain.PageBean;
import com.crm.sale.domain.SaleChance;
import com.crm.user.dao.UserDao;
import com.crm.user.domain.User;
import com.crm.user.service.UserService;
/**
 * 该类是用户业务逻辑层的实现类
 * @author 岑洛彬
 *
 */
@Transactional
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 业务逻辑层实现的方法
	 */
	//注册用户
	public void add(User user) {
		userDao.add(user);
	}
	//通过登入信息查找
	public User login(User user) {
		return userDao.login(user);
	}
	//通过登入名查找
	public User findByLoginName(String user_loginname) {
		return userDao.findByLoginName(user_loginname);
	}
	//通过权限查找
	public List<User> findByPermis(String permis) {
		return userDao.findByPermis(permis);
	}
	
	//通过id查找用户
	public User findById(Integer user_id) {
		return userDao.findById(user_id);
	}
	//按分页查找出所有用户
	public PageBean<User> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize) {
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		pageBean.setList(userDao.findByPage(dc, currPage, pageSize));
		pageBean.setTotalSize(userDao.count(dc));
		return pageBean;
	}
	//修改用户
	public void edit(User user) {
		userDao.edit(user);
	}
	//删除用户
	public void delete(User user) {
		userDao.delete(user);
	}

	
}
