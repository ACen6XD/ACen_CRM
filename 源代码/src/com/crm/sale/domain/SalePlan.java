package com.crm.sale.domain;
/**
 * 开发计划的实体类
 * @author 岑洛彬
 *CREATE TABLE `crm_mm_saleplan` (
  `plan_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '开发计划id',
  `plan_message` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '开发计划描述',
  `plan_date` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '开发计划时间',
  `plan_result` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '结果',
  `plan_salechance` bigint(10) DEFAULT NULL COMMENT '外键 属于的销售计划',

 */
public class SalePlan {
	private Integer plan_id;//开发计划id
	private String plan_message;//开发计划描述
	private String plan_date;//开发计划时间
	private String plan_result;//结果
	private SaleChance plan_salechance;//外键 属于的销售计划
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
