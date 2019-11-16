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
 * �������û�ҵ���߼����ʵ����
 * @author ����
 *
 */
@Transactional
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * ҵ���߼���ʵ�ֵķ���
	 */
	//ע���û�
	public void add(User user) {
		userDao.add(user);
	}
	//ͨ��������Ϣ����
	public User login(User user) {
		return userDao.login(user);
	}
	//ͨ������������
	public User findByLoginName(String user_loginname) {
		return userDao.findByLoginName(user_loginname);
	}
	//ͨ��Ȩ�޲���
	public List<User> findByPermis(String permis) {
		return userDao.findByPermis(permis);
	}
	
	//ͨ��id�����û�
	public User findById(Integer user_id) {
		return userDao.findById(user_id);
	}
	//����ҳ���ҳ������û�
	public PageBean<User> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize) {
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		pageBean.setList(userDao.findByPage(dc, currPage, pageSize));
		pageBean.setTotalSize(userDao.count(dc));
		return pageBean;
	}
	//�޸��û�
	public void edit(User user) {
		userDao.edit(user);
	}
	//ɾ���û�
	public void delete(User user) {
		userDao.delete(user);
	}

	
}
