package com.crm.sale.web.action;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.common.domain.PageBean;
import com.crm.customer.domain.Customer;
import com.crm.customer.service.CustomerService;
import com.crm.sale.domain.SaleVist;
import com.crm.sale.service.SaleVistService;
import com.crm.user.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 该类是客户访问记录的表现层的action类
 * @author 岑洛彬
 *
 */
public class SaleVistAction extends ActionSupport implements ModelDriven<SaleVist>{
	/**
	 * 模型驱动
	 */
	private SaleVist saleVist = new SaleVist();
	public SaleVist getModel() {
		return saleVist;
	}
	/**
	 * 依赖注入
	 */
	private SaleVistService saleVistService;
	public void setSaleVistService(SaleVistService saleVistService) {
		this.saleVistService = saleVistService;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");//获取当前登入的用户
	private Integer currPage = 1;//获取前端传来的页面相关的值
	private Integer pageSize = 3 ;
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
	
	
	
	
	/*
	 * -----------------------------分割线-------------------------------
	 */
	
	/**
	 * 进入首页查看的方法
	 */
	public String findByPage(){
		//查找出改用户负责的所有客户
		List<Customer> custList = customerService.findByUser(user);
		//新建一个离线
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVist.class);
		//判断前端是否传递了查询值
		if(saleVist.getSv_cust_id()!=null){
			if(saleVist.getSv_cust_id().getCust_id()!=null && !"".equals(saleVist.getSv_cust_id().getCust_id())){
				dc.add(Restrictions.eq("sv_cust_id.cust_id", saleVist.getSv_cust_id().getCust_id()));
			}
		}
		//把数据分装在分页实体中
		PageBean<SaleVist> pageBean = saleVistService.findByPage(dc,currPage,pageSize,user);
		//手动压入值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		ActionContext.getContext().getValueStack().set("custList", custList);
		return "findSuccess";
	}
	
	/**
	 * 进入添加页面
	 */
	public String addUI(){
		//查找出改用户负责的所有客户
		List<Customer> custList = customerService.findByUser(user);
		//存入值栈中
		ActionContext.getContext().getValueStack().set("custList", custList);
		return "addUI";
	}
	/**
	 * 进行添加
	 */
	public String add(){
		saleVistService.add(saleVist);
		return "addSuccess";
	}
	/**
	 * 进入修改页面
	 */
	public String editUI(){
		saleVist = saleVistService.findById(saleVist.getSv_id());
		//查找出改用户负责的所有客户
		List<Customer> custList = customerService.findByUser(user);
		//存入值栈中
		ActionContext.getContext().getValueStack().set("custList", custList);
		ActionContext.getContext().getValueStack().push(saleVist);
		return "editUI";
	}
	/**
	 * 修改数据
	 */
	public String edit(){
		saleVistService.update(saleVist);
		return "editSuccess";
	}
	/**
	 * 删除数据
	 */
	public String delete(){
		saleVistService.delete(saleVist);
		return "delSuccess";
	}
	/**
	 * 进入查看页面
	 */
	public String checkUI(){
		saleVist = saleVistService.findById(saleVist.getSv_id());
		ActionContext.getContext().getValueStack().push(saleVist);
		return "checkUI";
	}
	
	
	
	
	
	
	
	
	
	
}
