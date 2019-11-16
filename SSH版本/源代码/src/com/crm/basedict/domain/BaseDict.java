package com.crm.basedict.domain;

import java.util.Set;

import com.crm.customer.domain.Customer;
import com.crm.sale.domain.SaleChance;
import com.crm.user.domain.User;


/**
 * 数据字典的实体
 * @author 岑洛彬
 *
 */
public class BaseDict {
	private String dict_id;//编号
	private String dict_type_code;//数据字典类别代码
	private String dict_type_name;//数据字典类别名称
	private String dict_item_name;//数据字典项目名称
	private Set<Customer> cust_level;
	private Set<Customer> cust_source;
	private Set<Customer> cust_indursty;
	private Set<Customer> cust_area;
	private Set<SaleChance> baseDictSource;
	private Set<SaleChance> baseDictChanceComm;
	private Set<User> baseDictPermission;
	
	public Set<Customer> getCust_level() {
		return cust_level;
	}
	public void setCust_level(Set<Customer> cust_level) {
		this.cust_level = cust_level;
	}
	public Set<Customer> getCust_source() {
		return cust_source;
	}
	public void setCust_source(Set<Customer> cust_source) {
		this.cust_source = cust_source;
	}
	public Set<Customer> getCust_indursty() {
		return cust_indursty;
	}
	public void setCust_indursty(Set<Customer> cust_indursty) {
		this.cust_indursty = cust_indursty;
	}
	public Set<Customer> getCust_area() {
		return cust_area;
	}
	public void setCust_area(Set<Customer> cust_area) {
		this.cust_area = cust_area;
	}
	public Set<SaleChance> getBaseDictSource() {
		return baseDictSource;
	}
	public void setBaseDictSource(Set<SaleChance> baseDictSource) {
		this.baseDictSource = baseDictSource;
	}
	public Set<SaleChance> getBaseDictChanceComm() {
		return baseDictChanceComm;
	}
	public void setBaseDictChanceComm(Set<SaleChance> baseDictChanceComm) {
		this.baseDictChanceComm = baseDictChanceComm;
	}
	public Set<User> getBaseDictPermission() {
		return baseDictPermission;
	}
	public void setBaseDictPermission(Set<User> baseDictPermission) {
		this.baseDictPermission = baseDictPermission;
	}
	public String getDict_id() {
		return dict_id;
	}
	public void setDict_id(String dict_id) {
		this.dict_id = dict_id;
	}
	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	public String getDict_type_name() {
		return dict_type_name;
	}
	public void setDict_type_name(String dict_type_name) {
		this.dict_type_name = dict_type_name;
	}
	public String getDict_item_name() {
		return dict_item_name;
	}
	public void setDict_item_name(String dict_item_name) {
		this.dict_item_name = dict_item_name;
	}
	
}
