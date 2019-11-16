package com.crm.linkman.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.common.domain.PageBean;
import com.crm.linkman.domain.LinkMan;
import com.crm.user.domain.User;
/**
 * ��������ϵ�˵�ҵ���߼���Ľӿ���
 * @author ����
 *
 */
public interface LinkManService {
	
	//���ݵ�ǰ����Ŀͻ�������ҳ��ѯ������Ŀͻ���������ϵ�˵���Ϣ
	PageBean<LinkMan> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize, User user);
	//�����û�
	void save(LinkMan linkMan);
	//����id�ҳ�Ҫ���в�������ϵ��ʵ��
	LinkMan findById(Integer lkm_id);
	//����ʵ��
	void edit(LinkMan linkMan);
	//ɾ��ʵ��
	void delete(LinkMan linkMan);
	//���ݿͻ�id�����ϵ��
	PageBean<LinkMan> findByCust(DetachedCriteria dc, Integer currPage, Integer pageSize,Integer cust_id);

}
