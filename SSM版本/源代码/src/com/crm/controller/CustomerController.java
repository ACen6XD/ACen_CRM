package com.crm.controller;

import java.util.List;




import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.pojo.BaseDict;
import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;
import com.crm.service.BaseDictService;
import com.crm.service.CustomerService;
import com.crm.utils.Page;
/**
 * 该类是客户信息请求处理
 * @author 岑洛彬
 *
 */
@Controller
@RequestMapping("customer")
public class CustomerController {
	
	/**
	 * 注入业务逻辑层属性
	 */
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	/**
	 * 注入配置文件中的值 
	 */
	@Value(value="${customer_source_type}")
	private String customer_source_type;
	
	@Value(value="${customer_industry_type}")
	private String customer_industry_type;
	
	@Value(value="${customer_level_type}")
	private String customer_level_type;
	
	/**
	 * 主页显示列表以及返回查询信息
	 * @param model
	 * @param qo
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model model,QueryVo qo){
		//加载客户来源的下拉列表
		List<BaseDict> sourceType= baseDictService.findByTypeCode(customer_source_type);
		//加载客户类别的下拉列表
		List<BaseDict> industryType= baseDictService.findByTypeCode(customer_industry_type);
		//加载客户级别的下拉列表
		List<BaseDict> levelType= baseDictService.findByTypeCode(customer_level_type);
		
		//根据前端传来的综合条件进行查询
		Page<Customer> page = customerService.findByTypeCode(qo);
		
		//传值到页面
		model.addAttribute("sourceType", sourceType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		model.addAttribute("page",page);
		return "customer";
	}
	
	/**
	 * 点击修改后显示要修改的用户的信息
	 * @return
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Customer edit(Integer id,Model model){
		//加载客户来源的下拉列表
		List<BaseDict> sourceType= baseDictService.findByTypeCode(customer_source_type);
		//加载客户类别的下拉列表
		List<BaseDict> industryType= baseDictService.findByTypeCode(customer_industry_type);
		//加载客户级别的下拉列表
		List<BaseDict> levelType= baseDictService.findByTypeCode(customer_level_type);
		//传值到页面
		model.addAttribute("sourceType", sourceType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		Customer customer = customerService.findById(id);
		return customer;
	}
	
	/**
	 * 点击更新之后进行更新
	 * @param customer
	 */
	@RequestMapping("update")
	public String update(Customer customer){
		customerService.update(customer);
		return "redirect:/customer/list.action";
	}
	
	/**
	 * 点击删除后进行删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(Integer id){
		String msg = "1";
		try {
			customerService.delete(id);
		} catch (Exception e) {
			msg = "0";
		}
		return msg;
	}
}
