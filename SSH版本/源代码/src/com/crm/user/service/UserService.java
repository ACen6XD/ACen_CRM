package com.crm.user.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.domain.PageBean;
import com.crm.sale.domain.SaleChance;
import com.crm.user.domain.User;
/**
 * �������û�ҵ���߼���Ľӿ���
 * @author ����
 *
 */
public interface UserService {
	//ע�����û�
	void add(User user);
	//�û�����
	User login(User user);
	//����ע��id�ж��Ƿ���ڸ��˻�
	User findByLoginName(String user_loginname);
	//����Ȩ�޲����û�
	List<User> findByPermis(String permis);
	//����id�����û�
	User findById(Integer user_id);
	//����ҳ���ҳ������û�
	PageBean<User> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize);
	//�޸��û�
	void edit(User user);
	//ɾ���û�
	void delete(User user);
	

}
