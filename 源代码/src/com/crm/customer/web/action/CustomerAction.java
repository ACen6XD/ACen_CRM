package com.crm.customer.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.basedict.domain.BaseDict;
import com.crm.basedict.service.BaseDictService;
import com.crm.common.domain.PageBean;
import com.crm.customer.domain.Customer;
import com.crm.customer.service.CustomerService;
import com.crm.linkman.domain.LinkMan;
import com.crm.sale.domain.SaleChance;
import com.crm.sale.service.SaleChanceService;
import com.crm.user.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 该类是客户类的表现层的action类
 * @author 岑洛彬
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	/**
	 * 模型驱动来封装数据
	 */
	private Customer customer = new Customer();
	public Customer getModel() {
		return customer;
	}
	/**
	 * 依赖注入
	 */
	private CustomerService customerService;//客户管理业务层逻辑
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	private SaleChanceService saleChanceService;//销售机会层业务逻辑
	public void setSaleChanceService(SaleChanceService saleChanceService) {
		this.saleChanceService = saleChanceService;
	}
	private BaseDictService baseDictService;//数据字典层业务逻辑
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	private Integer currPage = 1;//当前页
	private Integer pageSize = 3;//每页显示的数据量
	public void setCurrPage(Integer currPage) {
		if(currPage == 0)
			currPage = 1;
		this.currPage = currPage;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize == 0)
			pageSize = 3;
		this.pageSize = pageSize;
	}
	//获取当前登入用户 
	private User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
	private Integer sale_id;//开发成功的销售机会的id
	public Integer getSale_id() {
		return sale_id;
	}
	
	public void setSale_id(Integer sale_id) {
		this.sale_id = sale_id;
	}
	
	/*
	 * ---------------分割线(以下是action中各个方法具体的实现)-------------------
	 */
	

	/**
	 * 确定点击添加详细客户信息后，进入添加界面
	 */
	public String addUI(){
		//从数据字典中获取客户来源的下拉列表
		List<BaseDict> custSourceList = baseDictService.findByTypeCode("1");
		//从数据字典中获取客户级别的下拉列表
		List<BaseDict> custLevelList = baseDictService.findByTypeCode("4");
		//从数据字典中获取客户所属行业的下拉列表
		List<BaseDict> custIndurstyList = baseDictService.findByTypeCode("5");
		//从数据字典中获取客户所属地区的下拉列表
		List<BaseDict> custAreaList = baseDictService.findByTypeCode("6");
		//获取到开发成功的销售机会的实体
		SaleChance saleChance = saleChanceService.findById(sale_id);
		//从开发成功的销售机会的实体中获取客户名称和客户来源
		customer.setCust_name(saleChance.getSale_name());
		customer.setCust_source(saleChance.getBaseDictSource());
		//同时设置客户创建的时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		customer.setCust_date(df.format(new Date()));
		//设置客户负责人,即当前登入的用户
		customer.setCust_respman(user);
		//手动压入值栈内
		ActionContext.getContext().getValueStack().set("saleChance",saleChance);
		ActionContext.getContext().getValueStack().set("custSourceList",custSourceList);
		ActionContext.getContext().getValueStack().set("custLevelList",custLevelList);
		ActionContext.getContext().getValueStack().set("custAreaList",custAreaList);
		ActionContext.getContext().getValueStack().set("custIndurstyList",custIndurstyList);
		return "addUI";
	}
	/**
	 * 点击提交后,添加该客户的信息
	 */
	public String add(){
		//通过id获取到开发成功的销售机会的实体
		SaleChance saleChance = saleChanceService.findById(sale_id);
		//从开发成功的销售机会的实体中获取客户来源
		customer.setCust_source(saleChance.getBaseDictSource());
		//设置客户负责人,即当前登入的用户
		customer.setCust_respman(user);
		//往客户表中存入详细客户信息
		customerService.add(customer);
		//删除销售机会中的完成开发的数据
		saleChanceService.delete(saleChance);
		return "addSuccess";
	}
	/**
	 * 点击客户基础管理显示出当前账户下的客户
	 */
	public String findByPage(){
		//从数据字典中获取客户来源的下拉列表
		List<BaseDict> custSourceList = baseDictService.findByTypeCode("1");
		//从数据字典中获取客户级别的下拉列表
		List<BaseDict> custLevelList = baseDictService.findByTypeCode("4");
		//从数据字典中获取客户所属行业的下拉列表
		List<BaseDict> custIndurstyList = baseDictService.findByTypeCode("5");
		//从数据字典中获取客户所属地区的下拉列表
		List<BaseDict> custAreaList = baseDictService.findByTypeCode("6");
		//新建一个分页实体，用于存放列表页中的分页信息
		PageBean<Customer> pageBean = new PageBean<Customer>();
		//新建一个离线查询
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//判断前端是否有需要查询的值传入
		if(customer.getCust_name()!=null && !"".equals(customer.getCust_name())){
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		if(customer.getCust_area()!=null){
			if(customer.getCust_area().getDict_id()!=null&& !"".equals(customer.getCust_area().getDict_id())){
				dc.add(Restrictions.eq("cust_area.dict_id", customer.getCust_area().getDict_id()));
			}
		}
		if(customer.getCust_level()!=null){
			if(customer.getCust_level().getDict_id()!=null&& !"".equals(customer.getCust_level().getDict_id())){
				dc.add(Restrictions.eq("cust_level.dict_id", customer.getCust_level().getDict_id()));
			}
		}
		if(customer.getCust_source()!=null){
			if(customer.getCust_source().getDict_id()!=null&& !"".equals(customer.getCust_source().getDict_id())){
				dc.add(Restrictions.eq("cust_source.dict_id", customer.getCust_source().getDict_id()));
			}
		}
		if(customer.getCust_indursty()!=null){
			if(customer.getCust_indursty().getDict_id()!=null&& !"".equals(customer.getCust_indursty().getDict_id())){
				dc.add(Restrictions.eq("cust_indursty.dict_id", customer.getCust_indursty().getDict_id()));
			}
		}
		//调用业务层逻辑给分页实体赋值
		pageBean = customerService.findByPage(dc,currPage,pageSize,user);
		//判断首页有查询输入
		//手动压入值栈
		ActionContext.getContext().getValueStack().push(pageBean);
		ActionContext.getContext().getValueStack().set("custSourceList",custSourceList);
		ActionContext.getContext().getValueStack().set("custLevelList",custLevelList);
		ActionContext.getContext().getValueStack().set("custIndurstyList",custIndurstyList);
		ActionContext.getContext().getValueStack().set("custAreaList",custAreaList);
		return "findSuccess";
	}
	/**
	 * 点击修改后进入修改界面
	 */
	public String editUI(){
		//从数据字典中获取客户来源的下拉列表
		List<BaseDict> custSourceList = baseDictService.findByTypeCode("1");
		//从数据字典中获取客户级别的下拉列表
		List<BaseDict> custLevelList = baseDictService.findByTypeCode("4");
		//从数据字典中获取客户所属行业的下拉列表
		List<BaseDict> custIndurstyList = baseDictService.findByTypeCode("5");
		//从数据字典中获取客户所属地区的下拉列表
		List<BaseDict> custAreaList = baseDictService.findByTypeCode("6");
		//根据传递进来的cust_id获取要修改的用户的所有信息
		customer = customerService.findById(customer.getCust_id());
		//手动压入值栈
		ActionContext.getContext().getValueStack().push(customer);
		ActionContext.getContext().getValueStack().set("custSourceList",custSourceList);
		ActionContext.getContext().getValueStack().set("custLevelList",custLevelList);
		ActionContext.getContext().getValueStack().set("custIndurstyList",custIndurstyList);
		ActionContext.getContext().getValueStack().set("custAreaList",custAreaList);
		return "editUI";
	}
	
	/**
	 * 点击修改之后
	 */
	public String edit(){
		//customer = customerService.findById(customer.getCust_id());
		customer.setCust_respman(user);
		//调用业务层逻辑更新用户
		customerService.edit(customer);
		return "editSuccess";
	}
	/**
	 * 点击删除之后删除这条数据
	 */
	public String delete(){
		//调用业务层逻辑删除用户
		customerService.delete(customer);
		return "deleteSuccess";
	}
	/**
	 * 点击查看详细信息进入信息查看界面
	 */
	public String checkUI(){
		//从数据字典中获取客户来源的下拉列表
		List<BaseDict> custSourceList = baseDictService.findByTypeCode("1");
		//从数据字典中获取客户级别的下拉列表
		List<BaseDict> custLevelList = baseDictService.findByTypeCode("4");
		//从数据字典中获取客户所属行业的下拉列表
		List<BaseDict> custIndurstyList = baseDictService.findByTypeCode("5");
		//从数据字典中获取客户所属地区的下拉列表
		List<BaseDict> custAreaList = baseDictService.findByTypeCode("6");
		//根据传递进来的cust_id获取要修改的用户的所有信息
		customer = customerService.findById(customer.getCust_id());
		//手动压入值栈
		ActionContext.getContext().getValueStack().push(customer);
		ActionContext.getContext().getValueStack().set("custSourceList",custSourceList);
		ActionContext.getContext().getValueStack().set("custLevelList",custLevelList);
		ActionContext.getContext().getValueStack().set("custIndurstyList",custIndurstyList);
		ActionContext.getContext().getValueStack().set("custAreaList",custAreaList);
		return "checkUI";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
