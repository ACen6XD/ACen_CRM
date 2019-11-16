package com.crm.sale.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.dao.BaseDao;
import com.crm.sale.domain.SaleVist;
import com.crm.user.domain.User;
/**
 * �����ǿͻ����ʼ�¼�ĳ־ò�Ľӿ���
 * @author ����
 *
 */
public interface SaleVistDao extends BaseDao<SaleVist>{

	Integer countByUser(DetachedCriteria dc, User user);

	List<SaleVist> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user);

}
