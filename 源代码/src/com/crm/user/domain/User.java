package com.crm.user.domain;

import java.util.Set;

import com.crm.basedict.domain.BaseDict;
import com.crm.customer.domain.Customer;
import com.crm.sale.domain.SaleChance;
import com.crm.sale.domain.SaleVist;

/**
 * �������û���ʵ����
 * CREATE TABLE `crm_sys_user` (
  `user_id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '�û����',
  `user_loginname` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '�û�����',
  `user_password` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '�û�����',
  `user_realname` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '�û���ʵ����',
  `user_permission` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '�û�Ȩ��',
  `user_belong` bigint(15) COLLATE utf8_bin DEFAULT NULL COMMENT '�û������ϼ�',
 * @author ����
 *
 */
public class User {
	private Integer user_id;//�û�id
	private String user_loginname;//�û�������
	private String user_password;//�û���������
	private String user_realname;//�û���ʵ����
	private BaseDict baseDictPermission;//�û�Ȩ��
	private String user_phone;//�û��������ϼ�
	private Set<Customer> customerSet;
	private Set<SaleChance> saleChanceSet;
	private Set<SaleChance> saleChanceBuildSet;
	private Set<SaleVist> userSaleVistSet;
	
	public Set<SaleVist> getUserSaleVistSet() {
		return userSaleVistSet;
	}
	public void setUserSaleVistSet(Set<SaleVist> userSaleVistSet) {
		this.userSaleVistSet = userSaleVistSet;
	}
	public Set<SaleChance> getSaleChanceBuildSet() {
		return saleChanceBuildSet;
	}
	public void setSaleChanceBuildSet(Set<SaleChance> saleChanceBuildSet) {
		this.saleChanceBuildSet = saleChanceBuildSet;
	}
	public Set<Customer> getCustomerSet() {
		return customerSet;
	}
	public void setCustomerSet(Set<Customer> customerSet) {
		this.customerSet = customerSet;
	}
	public Set<SaleChance> getSaleChanceSet() {
		return saleChanceSet;
	}
	public void setSaleChanceSet(Set<SaleChance> saleChanceSet) {
		this.saleChanceSet = saleChanceSet;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_loginname() {
		return user_loginname;
	}
	public void setUser_loginname(String user_loginname) {
		this.user_loginname = user_loginname;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_realname() {
		return user_realname;
	}
	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}
	public BaseDict getBaseDictPermission() {
		return baseDictPermission;
	}
	public void setBaseDictPermission(BaseDict baseDictPermission) {
		this.baseDictPermission = baseDictPermission;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
	
}
