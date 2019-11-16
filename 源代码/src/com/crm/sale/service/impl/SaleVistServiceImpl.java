package com.crm.sale.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.crm.common.domain.PageBean;
import com.crm.sale.dao.SaleVistDao;
import com.crm.sale.domain.SaleVist;
import com.crm.sale.service.SaleVistService;
import com.crm.user.domain.User;
/**
 * �����ǿͻ����ʼ�¼��ҵ���߼����ʵ����
 * @author ����
 *
 */
@Transactional
public class SaleVistServiceImpl implements SaleVistService{
	/**
	 * ����ע��
	 */
	private SaleVistDao saleVistDao;
	public void setSaleVistDao(SaleVistDao saleVistDao) {
		this.saleVistDao = saleVistDao;
	}
	/**
	 * ���ҵ�ǰ�û��µĿͻ����ʼ�¼���������ڷ�ҳʵ����
	 */
	public PageBean<SaleVist> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user) {
		PageBean<SaleVist> p = new PageBean<SaleVist>();
		p.setCurrPage(currPage);
		p.setPageSize(pageSize);
		p.setTotalSize(saleVistDao.countByUser(dc,user));
		p.setList(saleVistDao.findByPage(dc, currPage, pageSize,user));
		return p;
	}
	/**
	 * �����û�
	 */
	public void add(SaleVist saleVist) {
		saleVistDao.add(saleVist);
	}
	/**
	 * ����id�ҳ��û�
	 */
	public SaleVist findById(Integer sv_id) {
		return saleVistDao.findById(sv_id);
	}
	/**
	 * �޸�����
	 */
	public void update(SaleVist saleVist) {
		saleVistDao.edit(saleVist);
	}
	/**
	 * ɾ������
	 */
	public void delete(SaleVist saleVist) {
		saleVistDao.delete(saleVist);
	} 
	
}
