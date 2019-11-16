package com.crm.sale.domain;

import java.util.Date;
import java.util.Set;

import com.crm.basedict.domain.BaseDict;
import com.crm.user.domain.User;

/**
 * ���ۻ����ʵ��
 * @author ����
  `sale_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '���',
  `sale_source` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '������Դ',
  `sale_name` varchar(45) NOT NULL COMMENT '�ͻ�����',
  `sale_rate` bigint(10) NOT NULL COMMENT '�ɹ�����',
  `sale_comm` varchar(55) NOT NULL COMMENT '��Ҫ',
  `sale_linkman` varchar(45) DEFAULT NULL COMMENT '��ϵ��',
  `sale_linkphone` varchar(45) DEFAULT NULL COMMENT '��ϵ�绰',
  `sale_chancecomm` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��������',
  `sale_buildman` varchar(45) NOT NULL COMMENT '������',
  `sale_date` date NOT NULL COMMENT '����ʱ��',
  `sale_respman` varchar(45) DEFAULT NULL COMMENT 'ָ�ɵ���',
  `sale_respdate` date DEFAULT NULL COMMENT 'ָ��ʱ��',


 */
public class SaleChance {
	private Integer sale_id;//���ۼ�¼id
	private BaseDict baseDictSource;//������Դ
	private String sale_name;//�ͻ�����
	private Integer sale_rate;//�ɹ�����
	private String sale_comm;//��Ҫ
	private String sale_linkman;//��ϵ��
	private String sale_linkphone;//��ϵ�绰
	private BaseDict baseDictChanceComm;//��������
	private User sale_buildman;//������
	private String sale_date;//����ʱ��
	private User sale_respman;//ָ�ɵ���
	private String sale_respdate;//ָ��ʱ��
	private String sale_status;//����״̬
	private Set<SalePlan> salePlan;//�����ƻ��ļ���
	public Set<SalePlan> getSalePlan() {
		return salePlan;
	}
	public void setSalePlan(Set<SalePlan> salePlan) {
		this.salePlan = salePlan;
	}
	public String getSale_status() {
		return sale_status;
	}
	public void setSale_status(String sale_status) {
		this.sale_status = sale_status;
	}
	public Integer getSale_id() {
		return sale_id;
	}
	public void setSale_id(Integer sale_id) {
		this.sale_id = sale_id;
	}
	public BaseDict getBaseDictSource() {
		return baseDictSource;
	}
	public void setBaseDictSource(BaseDict baseDictSource) {
		this.baseDictSource = baseDictSource;
	}
	public String getSale_name() {
		return sale_name;
	}
	public void setSale_name(String sale_name) {
		this.sale_name = sale_name;
	}
	public Integer getSale_rate() {
		return sale_rate;
	}
	public void setSale_rate(Integer sale_rate) {
		this.sale_rate = sale_rate;
	}
	public String getSale_comm() {
		return sale_comm;
	}
	public void setSale_comm(String sale_comm) {
		this.sale_comm = sale_comm;
	}
	public String getSale_linkman() {
		return sale_linkman;
	}
	public void setSale_linkman(String sale_linkman) {
		this.sale_linkman = sale_linkman;
	}
	public String getSale_linkphone() {
		return sale_linkphone;
	}
	public void setSale_linkphone(String sale_linkphone) {
		this.sale_linkphone = sale_linkphone;
	}
	public BaseDict getBaseDictChanceComm() {
		return baseDictChanceComm;
	}
	public void setBaseDictChanceComm(BaseDict baseDictChanceComm) {
		this.baseDictChanceComm = baseDictChanceComm;
	}
	
	public String getSale_date() {
		return sale_date;
	}
	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}
	public User getSale_buildman() {
		return sale_buildman;
	}
	public void setSale_buildman(User sale_buildman) {
		this.sale_buildman = sale_buildman;
	}
	public User getSale_respman() {
		return sale_respman;
	}
	public void setSale_respman(User sale_respman) {
		this.sale_respman = sale_respman;
	}
	public String getSale_respdate() {
		return sale_respdate;
	}
	public void setSale_respdate(String sale_respdate) {
		this.sale_respdate = sale_respdate;
	}
	
	
	
}
