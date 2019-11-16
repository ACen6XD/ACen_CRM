package com.crm.basedict.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.crm.basedict.dao.BaseDictDao;
import com.crm.basedict.domain.BaseDict;
import com.crm.basedict.service.BaseDictService;
import com.crm.common.domain.PageBean;
/**
 * �����������ֵ���ҵ���߼�ʵ�ֲ�
 * @author ����
 *
 */
@Transactional
public class BaseDictServiceImpl implements BaseDictService {
	//����ע��
	private BaseDictDao baseDictDao;
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}
	//���ó־ò�ķ���
	
	public List<BaseDict> findSource() {
		return baseDictDao.findSource();
	}
	public List<BaseDict> findChanceComm() {
		// TODO Auto-generated method stub
		return baseDictDao.findChanceComm();
	}

	public List<BaseDict> findPermission() {
		// TODO Auto-generated method stub
		return baseDictDao.findPermission();
	}

	public BaseDict findById(String dict_id) {
		// TODO Auto-generated method stub
		return baseDictDao.findById(dict_id);
	}

	public List<BaseDict> findByTypeCode(String typeCode) {
		return baseDictDao.findByTypeCode(typeCode);
	}

	public PageBean<BaseDict> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize) {
		PageBean<BaseDict> pageBean = new PageBean<BaseDict>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalSize(baseDictDao.count(dc));
		pageBean.setList(baseDictDao.findByPage(dc, currPage, pageSize));
		return pageBean;
	}
	
	//�ҳ����е��������
	public List<String> findAllTypeName() {
		return baseDictDao.findAllTypeName();
	}
	
	//�޸�
	public void edit(BaseDict baseDict) {
		baseDictDao.edit(baseDict);
	}
	//����
	public void save(BaseDict baseDict) {
		baseDictDao.add(baseDict);
	}
	//ɾ��
	public void delete(BaseDict baseDict) {
		baseDictDao.delete(baseDict);
	}
	
}
