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
 * ��������ϵ�˵ı��ֲ��action��
 * @author ����
 *
 */
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	/**
	 * ģ������
	 */
	private LinkMan linkMan = new LinkMan();
	public LinkMan getModel() {
		return linkMan;
	}
	/**
	 * ����ע��
	 */
	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//��ȡ��ǰ������û�
	private User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
	//��ȡ�ͻ���id
	private Integer cust_id;
	
	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	private Integer currPage = 1;//��ǰҳ
	private Integer pageSize = 3;//ÿҳ��ʾ��������
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
	 * -----------�ָ���(������action�о����ʵ�ַ���)---------
	 */
	
	/**
	 * ����鿴��ϵ���б��ķ���
	 */
	public String findByPage(){
		//����һ����������
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		//�ж�ǰ���Ƿ�����ѯֵ
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
		//����ҵ����߼�ȡ�����е���ϵ����Ϣ����װ�ɷ�ҳ��Ϣ��ʵ��
		PageBean<LinkMan> pageBean = linkManService.findByPage(dc,currPage,pageSize,user);
		//��ȡ��ǰ����ͻ��������µ����еĿͻ�
		List<Customer> custList = customerService.findByUser(user);
		//�ֶ�ѹ��ֵջ
		ActionContext.getContext().getValueStack().push(pageBean);
		ActionContext.getContext().getValueStack().set("custList", custList);
		return "findSuccess";
	}
	/**
	 * ���������ϵ�˺������ϵ�����ҳ��
	 */
	public String addUI(){
		//��ȡ��ǰ����ͻ��������µ����еĿͻ�
		List<Customer> custList = customerService.findByUser(user);
		//�ֶ�ѹ��ֵջ
		ActionContext.getContext().getValueStack().set("custList", custList);
		return "addUI";
	}
	/**
	 * ������֮��������ϵ��
	 */
	public String add(){
		linkMan.setLkm_user(user);
		linkManService.save(linkMan);
		return "addSuccess";
	}
	/**
	 * ����޸ĺ�����޸�ҳ��
	 */
	public String editUI(){
		//��ȡ��ǰ����ͻ��������µ����еĿͻ�
		List<Customer> custList = customerService.findByUser(user);
		//�ֶ�ѹ��ֵջ
		ActionContext.getContext().getValueStack().set("custList", custList);
		linkMan = linkManService.findById(linkMan.getLkm_id());
		ActionContext.getContext().getValueStack().push(linkMan);
		return "editUI";
	}
	/**
	 * ���ȷ�Ϻ�����޸�
	 */
	public String edit(){
		linkMan.setLkm_user(user);
		linkManService.edit(linkMan);
		return "editSuccess";
	}
	/**
	 * ���ɾ��֮�����ɾ��
	 */
	public String delete(){
		linkMan = linkManService.findById(linkMan.getLkm_id());
		linkManService.delete(linkMan);
		return "deleteSuccess";
	}
	/**
	 * �ͻ�ҳ�����鿴��ϵ��
	 */
	public String findByCust(){
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		PageBean<LinkMan> pageBean = linkManService.findByCust(dc,currPage,pageSize,cust_id);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findByCustSuccess";
	}
	
}
