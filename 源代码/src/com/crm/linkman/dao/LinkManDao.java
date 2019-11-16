package com.crm.linkman.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.dao.BaseDao;
import com.crm.linkman.domain.LinkMan;
import com.crm.user.domain.User;
/**
 * ��������ϵ�˳־ò�Ľӿ���
 * @author ����
 *
 */
public interface LinkManDao extends BaseDao<LinkMan>{

	List<LinkMan> findByPage(DetachedCriteria dc, int i, Integer pageSize,
			User user);

	Integer countByUser(DetachedCriteria dc, User user);


	Integer countByCust(DetachedCriteria dc, Integer cust_id);

	List<LinkMan> findByCust(DetachedCriteria dc, int i, Integer pageSize,
			Integer cust_id);

}
