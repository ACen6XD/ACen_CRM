package com.crm.user.dao;

import java.util.List;

import com.crm.common.dao.BaseDao;
import com.crm.user.domain.User;
/**
 * �������û��־ò�Ľӿ���
 * @author ����
 *
 */
public interface UserDao extends BaseDao<User>{

	User login(User user);

	User findByLoginName(String user_loginname);

	List<User> findByPermis(String permis);

}
