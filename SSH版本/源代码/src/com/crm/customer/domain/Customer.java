package com.crm.customer.domain;

import java.util.Set;

import com.crm.basedict.domain.BaseDict;
import com.crm.linkman.domain.LinkMan;
import com.crm.sale.domain.SaleChance;
import com.crm.sale.domain.SaleVist;
import com.crm.user.domain.User;

/**
 * �ͻ����ʵ����
 * @author ����
 *CREATE TABLE `crm_cm_customer` (
  `cust_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '�ͻ�id',
  `cust_name` bigint(10) DEFAULT NULL COMMENT '�ͻ�����',
  `cust_level` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�ͻ�����',
  `cust_source` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�ͻ���Դ',
  `cust_indursty` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�ͻ�������ҵ',
  `cust_phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�ͻ��绰',
  `cust_address` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�ͻ���ַ',
  `cust_mail` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�ͻ�����',
  `cust_comm` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�ͻ���ע',
  `cust_code` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�ͻ�Ӫҵִ��ע���',
  `cust_money` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'ע���ʽ�',
  `cust_registman` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '����',
  `cust_yearmoney` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '��Ӫҵ��',
  `cust_bank` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '��������',
  `cust_bankid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '�����˺�',
 

 */
public class Customer {
	private Integer cust_id;//�ͻ�id
	private String cust_name;//��Ӧ�����ۻ����л�ȡ�Ŀͻ�����
	private BaseDict cust_level;//�������ֵ��л�ȡ�ͻ��ȼ�
	private BaseDict cust_source;//��Ӧ�ӻ�����Դ�л�ȡ������Ϣ
	private BaseDict cust_indursty;//�������ֵ��л�ȡ�ͻ�������ҵ
	private String cust_date;//�ͻ�ע������
	private String cust_phone;//��˾�绰
	private String cust_address;//��˾��ַ
	private String cust_mail;//��˾����
	private String cust_comm;//��˾��ע
	private String cust_code;//�ͻ�Ӫҵִ��ע���
	private String cust_money;//ע���ʽ�
	private String cust_registman;//����
	private String cust_yearmoney;//��Ӫҵ��
	private String cust_bank;//��������
	private String cust_bankid;//�����˺�
	private User cust_respman;//�ͻ�������
	private BaseDict cust_area;//�ͻ�����
	private Set<LinkMan> linkManSet;
	private Set<SaleVist> saleVistSet;
	public Set<SaleVist> getSaleVistSet() {
		return saleVistSet;
	}
	public void setSaleVistSet(Set<SaleVist> saleVistSet) {
		this.saleVistSet = saleVistSet;
	}
	public Set<LinkMan> getLinkManSet() {
		return linkManSet;
	}
	public void setLinkManSet(Set<LinkMan> linkManSet) {
		this.linkManSet = linkManSet;
	}
	public BaseDict getCust_area() {
		return cust_area;
	}
	public void setCust_area(BaseDict cust_area) {
		this.cust_area = cust_area;
	}
	public User getCust_respman() {
		return cust_respman;
	}
	public void setCust_respman(User cust_respman) {
		this.cust_respman = cust_respman;
	}
	public String getCust_date() {
		return cust_date;
	}
	public void setCust_date(String cust_date) {
		this.cust_date = cust_date;
	}
	public Integer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public BaseDict getCust_source() {
		return cust_source;
	}
	public void setCust_source(BaseDict cust_source) {
		this.cust_source = cust_source;
	}
	public BaseDict getCust_level() {
		return cust_level;
	}
	public void setCust_level(BaseDict cust_level) {
		this.cust_level = cust_level;
	}
	
	public BaseDict getCust_indursty() {
		return cust_indursty;
	}
	public void setCust_indursty(BaseDict cust_indursty) {
		this.cust_indursty = cust_indursty;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public String getCust_mail() {
		return cust_mail;
	}
	public void setCust_mail(String cust_mail) {
		this.cust_mail = cust_mail;
	}
	public String getCust_comm() {
		return cust_comm;
	}
	public void setCust_comm(String cust_comm) {
		this.cust_comm = cust_comm;
	}
	public String getCust_code() {
		return cust_code;
	}
	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}
	public String getCust_money() {
		return cust_money;
	}
	public void setCust_money(String cust_money) {
		this.cust_money = cust_money;
	}
	public String getCust_registman() {
		return cust_registman;
	}
	public void setCust_registman(String cust_registman) {
		this.cust_registman = cust_registman;
	}
	public String getCust_yearmoney() {
		return cust_yearmoney;
	}
	public void setCust_yearmoney(String cust_yearmoney) {
		this.cust_yearmoney = cust_yearmoney;
	}
	public String getCust_bank() {
		return cust_bank;
	}
	public void setCust_bank(String cust_bank) {
		this.cust_bank = cust_bank;
	}
	public String getCust_bankid() {
		return cust_bankid;
	}
	public void setCust_bankid(String cust_bankid) {
		this.cust_bankid = cust_bankid;
	}
	
}
