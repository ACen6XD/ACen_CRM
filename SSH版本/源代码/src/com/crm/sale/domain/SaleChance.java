package com.crm.sale.domain;

import java.util.Date;
import java.util.Set;

import com.crm.basedict.domain.BaseDict;
import com.crm.user.domain.User;

/**
 * 销售机会的实体
 * @author 岑洛彬
  `sale_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sale_source` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机会来源',
  `sale_name` varchar(45) NOT NULL COMMENT '客户名称',
  `sale_rate` bigint(10) NOT NULL COMMENT '成功几率',
  `sale_comm` varchar(55) NOT NULL COMMENT '概要',
  `sale_linkman` varchar(45) DEFAULT NULL COMMENT '联系人',
  `sale_linkphone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `sale_chancecomm` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机会描述',
  `sale_buildman` varchar(45) NOT NULL COMMENT '创建人',
  `sale_date` date NOT NULL COMMENT '创建时间',
  `sale_respman` varchar(45) DEFAULT NULL COMMENT '指派的人',
  `sale_respdate` date DEFAULT NULL COMMENT '指派时间',


 */
public class SaleChance {
	private Integer sale_id;//销售记录id
	private BaseDict baseDictSource;//机会来源
	private String sale_name;//客户名字
	private Integer sale_rate;//成功几率
	private String sale_comm;//概要
	private String sale_linkman;//联系人
	private String sale_linkphone;//联系电话
	private BaseDict baseDictChanceComm;//机会描述
	private User sale_buildman;//创建人
	private String sale_date;//创建时间
	private User sale_respman;//指派的人
	private String sale_respdate;//指派时间
	private String sale_status;//开发状态
	private Set<SalePlan> salePlan;//开发计划的集合
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
