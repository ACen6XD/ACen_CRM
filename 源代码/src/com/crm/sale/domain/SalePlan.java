package com.crm.sale.domain;
/**
 * �����ƻ���ʵ����
 * @author ����
 *CREATE TABLE `crm_mm_saleplan` (
  `plan_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '�����ƻ�id',
  `plan_message` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�����ƻ�����',
  `plan_date` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�����ƻ�ʱ��',
  `plan_result` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '���',
  `plan_salechance` bigint(10) DEFAULT NULL COMMENT '��� ���ڵ����ۼƻ�',

 */
public class SalePlan {
	private Integer plan_id;//�����ƻ�id
	private String plan_message;//�����ƻ�����
	private String plan_date;//�����ƻ�ʱ��
	private String plan_result;//���
	private SaleChance plan_salechance;//��� ���ڵ����ۼƻ�
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	public String getPlan_message() {
		return plan_message;
	}
	public void setPlan_message(String plan_message) {
		this.plan_message = plan_message;
	}
	public String getPlan_date() {
		return plan_date;
	}
	public void setPlan_date(String plan_date) {
		this.plan_date = plan_date;
	}
	public String getPlan_result() {
		return plan_result;
	}
	public void setPlan_result(String plan_result) {
		this.plan_result = plan_result;
	}
	public SaleChance getPlan_salechance() {
		return plan_salechance;
	}
	public void setPlan_salechance(SaleChance plan_salechance) {
		this.plan_salechance = plan_salechance;
	}
	
}
