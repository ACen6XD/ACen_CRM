package com.crm.basedict.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.basedict.domain.BaseDict;
import com.crm.common.domain.PageBean;
/**
 * �����������ֵ���ҵ���߼���ӿ�
 * @author ����
 *
 */
public interface BaseDictService {
	/**
	 * ���ݻ�����Դ���������ֵ�����
	 * @param ��
	 * @return �����ֵ伯��
	 * @return
	 */
	List<BaseDict> findSource();
	/**
	 * ���ݻ���������Դ���������ֵ�����
	 * @param ��
	 * @return �����ֵ伯��
	 * @return
	 */
	List<BaseDict> findChanceComm();
	/**
	 * �����û�Ȩ����Դ���������ֵ�����
	 * @param ��
	 * @return �����ֵ伯��
	 * @return
	 */
	List<BaseDict> findPermission();
	/**
	 * ������������Դ���������ֵ�����
	 * @param ��
	 * @return �����ֵ伯��
	 * @return
	 */
	List<BaseDict> findByTypeCode(String typeCode);
	/**
	 * ����id��Դ���������ֵ�����
	 * @param ��
	 * @return �����ֵ伯��
	 * @return
	 */
	BaseDict findById(String dict_id);
	/**
	 * ���ݷ�ҳ��Ϣ��Դ���������ֵ�����
	 * @param ���߲�ѯ ����ҳ��ÿҳ��ʾ����
	 * @return ��ҳʵ��
	 * @return
	 */
	PageBean<BaseDict> findByPage(DetachedCriteria dc, Integer currPage,
			Integer pageSize);
	/**
	 * ���������������
	 * @param ��
	 * @return �����ֵ伯��
	 * @return
	 */
	List<String> findAllTypeName();
	/**
	 * �޸�ʵ��
	 * @param Ҫ�޸ĵ�ʵ��
	 * @return ��
	 * @return
	 */
	void edit(BaseDict baseDict);
	/**
	 * ����ʵ��
	 * @param Ҫ���ӵ�ʵ��
	 * @return ��
	 * @return
	 */
	void save(BaseDict baseDict);
	/**
	 * ɾ������
	 * @param Ҫɾ����ʵ��
	 * @return ��
	 * @return
	 */
	void delete(BaseDict baseDict);
}
