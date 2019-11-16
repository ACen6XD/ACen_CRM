package com.crm.linkman.domain;

import com.crm.customer.domain.Customer;
import com.crm.user.domain.User;

/**
 * 该类是联系人的实体类
 * CREATE TABLE `crm_cm_linkman` (
  `lkm_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '联系人id',
  `lkm_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人姓名',
  `lkm_gender` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人性别',
  `lkm_position` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人职位',
  `lkm_mobile` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人电话',
  `lkm_email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人电话',
  `lkm_qq` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人qq',
  `lkm_como` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系人备注',
  `lkm_cust_id` bigint(10) DEFAULT NULL COMMENT '所属客户',
  PRIMARY KEY (`lkm_id`),
  KEY `FK_linkman001_idx` (`lkm_cust_id`),
  CONSTRAINT `FK_linkman001` FOREIGN KEY (`lkm_cust_id`) REFERENCES `crm_cm_customer` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

 * @author 岑洛彬
 *
 */
public class LinkMan {
	private Integer lkm_id;
	private String lkm_name;
	private String lkm_gender;
	private String lkm_position;
	private String lkm_mobile;
	private String lkm_email;
	private String lkm_qq;
	private String lkm_como;
	private Customer lkm_customer;
	private User lkm_user;
	
	public User getLkm_user() {
		return lkm_user;
	}
	public void setLkm_user(User lkm_user) {
		this.lkm_user = lkm_user;
	}
	public Integer getLkm_id() {
		return lkm_id;
	}
	public void setLkm_id(Integer lkm_id) {
		this.lkm_id = lkm_id;
	}
	public String getLkm_name() {
		return lkm_name;
	}
	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}
	public String getLkm_gender() {
		return lkm_gender;
	}
	public void setLkm_gender(String lkm_gender) {
		this.lkm_gender = lkm_gender;
	}
	public String getLkm_position() {
		return lkm_position;
	}
	public void setLkm_position(String lkm_position) {
		this.lkm_position = lkm_position;
	}
	public String getLkm_mobile() {
		return lkm_mobile;
	}
	public void setLkm_mobile(String lkm_mobile) {
		this.lkm_mobile = lkm_mobile;
	}
	public String getLkm_email() {
		return lkm_email;
	}
	public void setLkm_email(String lkm_email) {
		this.lkm_email = lkm_email;
	}
	public String getLkm_qq() {
		return lkm_qq;
	}
	public void setLkm_qq(String lkm_qq) {
		this.lkm_qq = lkm_qq;
	}
	public String getLkm_como() {
		return lkm_como;
	}
	public void setLkm_como(String lkm_como) {
		this.lkm_como = lkm_como;
	}
	public Customer getLkm_customer() {
		return lkm_customer;
	}
	public void setLkm_customer(Customer lkm_customer) {
		this.lkm_customer = lkm_customer;
	}
	
}
