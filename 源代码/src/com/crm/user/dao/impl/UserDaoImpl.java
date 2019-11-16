package com.crm.user.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.common.dao.impl.BaseDaoImpl;
import com.crm.user.dao.UserDao;
import com.crm.user.domain.User;
/**
 * 该类是用户持久层的实现类
 * @author 岑洛彬
 *
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public UserDaoImpl() {
		super(User.class);
	}
	/**
	 * 判断登入用户是否存在在数据库内
	 */
	public User login(User user) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_loginname", user.getUser_loginname()));
		dc.add(Restrictions.eq("user_password", user.getUser_password()));
		dc.add(Restrictions.eq("baseDictPermission.dict_id", user.getBaseDictPermission().getDict_id()));
		List<User> loginUser = (List<User>) this.getHibernateTemplate().findByCriteria(dc);
		if(loginUser.size() != 0)
			return loginUser.get(0);
		return null;
	}
	/**
	 * 判断注册用户是否存在在数据库内
	 */
	public User findByLoginName(String user_loginname) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_loginname = ?", user_loginname);
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	public List<User> findByPermis(String permis) {
		return (List<User>) this.getHibernateTemplate().find("from User where baseDictPermission.dict_id = ?", permis);
	}

}
