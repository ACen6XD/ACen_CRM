package com.crm.sale.domain;

import java.util.Date;

import com.crm.customer.domain.Customer;
import com.crm.user.domain.User;

/**
 * 访问记录的实体类
 * CREATE TABLE `crm_cm_salevist` (
  `sv_id` bigint(15) NOT NULL COMMENT '客户访问记录id',
  `sv_cust_id` bigint(10) DEFAULT NULL COMMENT '访问的客户id',
  `sv_user_id` bigint(15) DEFAULT NULL COMMENT '去访问的用户id',
  `sv_date` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '访问日期',
  `sv_address` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '访问地址',
  `sv_sketch` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '访问概述',
  `sv_comm` varchar(75) COLLATE utf8_bin DEFAULT NULL COMMENT '访问详细描述',
  PRIMARY KEY (`sv_id`),
  KEY `FK_salevist001_idx` (`sv_cust_id`),
  KEY `FK_salevist002_idx` (`sv_user_id`),
  CONSTRAINT `FK_salevist001` FOREIGN KEY (`sv_cust_id`) REFERENCES `crm_cm_customer` (`cust_id`),
  CONSTRAINT `FK_salevist002` FOREIGN KEY (`sv_user_id`) REFERENCES `crm_sys_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

 * @author 岑洛彬
 *
 */
public class SaleVist {
	private Integer sv_id;
	private Date sv_date;
	private String sv_address;
	private String sv_sketch;
	private String sv_comm;
	private Customer sv_cust_id;
	private User sv_user_id;
	public Integer getSv_id() {
		return sv_id;
	}
	public void setSv_id(Integer sv_id) {
		this.sv_id = sv_id;
	}
	
	public Date getSv_date() {
		return sv_date;
	}
	public void setSv_date(Date sv_date) {
		this.sv_date = sv_date;
	}
	public String getSv_address() {
		return sv_address;
	}
	public void setSv_address(String sv_address) {
		this.sv_address = sv_address;
	}
	public String getSv_sketch() {
		return sv_sketch;
	}
	public void setSv_sketch(String sv_sketch) {
		this.sv_sketch = sv_sketch;
	}
	public String getSv_comm() {
		return sv_comm;
	}
	public void setSv_comm(String sv_comm) {
		this.sv_comm = sv_comm;
	}
	public Customer getSv_cust_id() {
		return sv_cust_id;
	}
	public void setSv_cust_id(Customer sv_cust_id) {
		this.sv_cust_id = sv_cust_id;
	}
	public User getSv_user_id() {
		return sv_user_id;
	}
	public void setSv_user_id(User sv_user_id) {
		this.sv_user_id = sv_user_id;
	}
	
}
