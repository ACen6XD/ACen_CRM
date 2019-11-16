package com.crm.sale.service;

import java.util.List;

import com.crm.sale.domain.SalePlan;
/**
 *  ���������ۿ����ƻ���ҵ���߼���Ľӿ���
 * @author ����
 *
 */
public interface SalePlanService {
	//��������
	void add(SalePlan salePlan);
	//ͨ�����ۻ����id����ȡ���ۼƻ�
	List<SalePlan> findByChanceId(Integer sale_id);
	//ͨ��id��ȡ����
	SalePlan findById(Integer plan_id);
	//ɾ������
	void delete(SalePlan delSalePlan);
	//��������
	void update(SalePlan salePlan);

}
