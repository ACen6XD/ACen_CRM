package com.crm.sale.service;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.domain.PageBean;
import com.crm.sale.domain.SaleVist;
import com.crm.user.domain.User;
/**
 *  �����ǿͻ����ʼ�¼��ҵ���߼���Ľӿ���
 * @author ����
 *
 */
public interface SaleVistService {

	PageBean<SaleVist> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user);

	void add(SaleVist saleVist);

	SaleVist findById(Integer sv_id);

	void update(SaleVist saleVist);

	void delete(SaleVist saleVist);

}
