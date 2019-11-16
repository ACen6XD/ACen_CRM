package com.crm.linkman.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.common.domain.PageBean;
import com.crm.customer.domain.Customer;
import com.crm.customer.service.CustomerService;
import com.crm.linkman.domain.LinkMan;
import com.crm.linkman.service.LinkManService;
import com.crm.user.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 该类是联系人的表现层的action类
 * @author 岑洛彬
 *
 */
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	/**
	 * 模型驱动
	 */
	private LinkMan linkMan = new LinkMan();
	public LinkMan getModel() {
		return linkMan;
	}
	/**
	 * 依赖注入
	 */
	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//获取当前登入的用户
	private User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
	//获取客户的id
	private Integer cust_id;
	
	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
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
	
	/*
	 * -----------分割线(以下是action中具体的实现方法)---------
	 */
	
	/**
	 * 点击查看联系人列表后的方法
	 */
	public String findByPage(){
		//建立一个离线条件
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		//判断前端是否传来查询值
		if(linkMan.getLkm_name()!=null && !"".equals(linkMan.getLkm_name())){
			dc.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		}
		if(linkMan.getLkm_gender()!=null && !"".equals(linkMan.getLkm_gender())){
			dc.add(Restrictions.eq("lkm_gender", linkMan.getLkm_gender()));
		}
		if(linkMan.getLkm_customer()!=null){
			if(linkMan.getLkm_customer().getCust_id()!=null && !"".equals(linkMan.getLkm_customer().getCust_id())){
				dc.add(Restrictions.eq("lkm_customer.cust_id", linkMan.getLkm_customer().getCust_id()));
			}
		}
		//调用业务层逻辑取得所有的联系人信息并封装成分页信息的实体
		PageBean<LinkMan> pageBean = linkManService.findByPage(dc,currPage,pageSize,user);
		//获取当前登入客户经理名下的所有的客户
		List<Customer> custList = customerService.findByUser(user);
		//手动压入值栈
		ActionContext.getContext().getValueStack().push(pageBean);
		ActionContext.getContext().getValueStack().set("custList", custList);
		return "findSuccess";
	}
	/**
	 * 点击新增联系人后进入联系人添加页面
	 */
	public String addUI(){
		//获取当前登入客户经理名下的所有的客户
		List<Customer> custList = customerService.findByUser(user);
		//手动压入值栈
		ActionContext.getContext().getValueStack().set("custList", custList);
		return "addUI";
	}
	/**
	 * 点击添加之后新增联系人
	 */
	public String add(){
		linkMan.setLkm_user(user);
		linkManService.save(linkMan);
		return "addSuccess";
	}
	/**
	 * 点击修改后进入修改页面
	 */
	public String editUI(){
		//获取当前登入客户经理名下的所有的客户
		List<Customer> custList = customerService.findByUser(user);
		//手动压入值栈
		ActionContext.getContext().getValueStack().set("custList", custList);
		linkMan = linkManService.findById(linkMan.getLkm_id());
		ActionContext.getContext().getValueStack().push(linkMan);
		return "editUI";
	}
	/**
	 * 点击确认后进行修改
	 */
	public String edit(){
		linkMan.setLkm_user(user);
		linkManService.edit(linkMan);
		return "editSuccess";
	}
	/**
	 * 点击删除之后进行删除
	 */
	public String delete(){
		linkMan = linkManService.findById(linkMan.getLkm_id());
		linkManService.delete(linkMan);
		return "deleteSuccess";
	}
	/**
	 * 客户页面点击查看联系人
	 */
	public String findByCust(){
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		PageBean<LinkMan> pageBean = linkManService.findByCust(dc,currPage,pageSize,cust_id);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findByCustSuccess";
	}
	
}
