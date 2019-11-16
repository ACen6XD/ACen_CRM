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
 * �����ǿͻ����ʼ�¼�ı��ֲ��action��
 * @author ����
 *
 */
public class SaleVistAction extends ActionSupport implements ModelDriven<SaleVist>{
	/**
	 * ģ������
	 */
	private SaleVist saleVist = new SaleVist();
	public SaleVist getModel() {
		return saleVist;
	}
	/**
	 * ����ע��
	 */
	private SaleVistService saleVistService;
	public void setSaleVistService(SaleVistService saleVistService) {
		this.saleVistService = saleVistService;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");//��ȡ��ǰ������û�
	private Integer currPage = 1;//��ȡǰ�˴�����ҳ����ص�ֵ
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
	 * -----------------------------�ָ���-------------------------------
	 */
	
	/**
	 * ������ҳ�鿴�ķ���
	 */
	public String findByPage(){
		//���ҳ����û���������пͻ�
		List<Customer> custList = customerService.findByUser(user);
		//�½�һ������
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVist.class);
		//�ж�ǰ���Ƿ񴫵��˲�ѯֵ
		if(saleVist.getSv_cust_id()!=null){
			if(saleVist.getSv_cust_id().getCust_id()!=null && !"".equals(saleVist.getSv_cust_id().getCust_id())){
				dc.add(Restrictions.eq("sv_cust_id.cust_id", saleVist.getSv_cust_id().getCust_id()));
			}
		}
		//�����ݷ�װ�ڷ�ҳʵ����
		PageBean<SaleVist> pageBean = saleVistService.findByPage(dc,currPage,pageSize,user);
		//�ֶ�ѹ��ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		ActionContext.getContext().getValueStack().set("custList", custList);
		return "findSuccess";
	}
	
	/**
	 * �������ҳ��
	 */
	public String addUI(){
		//���ҳ����û���������пͻ�
		List<Customer> custList = customerService.findByUser(user);
		//����ֵջ��
		ActionContext.getContext().getValueStack().set("custList", custList);
		return "addUI";
	}
	/**
	 * �������
	 */
	public String add(){
		saleVistService.add(saleVist);
		return "addSuccess";
	}
	/**
	 * �����޸�ҳ��
	 */
	public String editUI(){
		saleVist = saleVistService.findById(saleVist.getSv_id());
		//���ҳ����û���������пͻ�
		List<Customer> custList = customerService.findByUser(user);
		//����ֵջ��
		ActionContext.getContext().getValueStack().set("custList", custList);
		ActionContext.getContext().getValueStack().push(saleVist);
		return "editUI";
	}
	/**
	 * �޸�����
	 */
	public String edit(){
		saleVistService.update(saleVist);
		return "editSuccess";
	}
	/**
	 * ɾ������
	 */
	public String delete(){
		saleVistService.delete(saleVist);
		return "delSuccess";
	}
	/**
	 * ����鿴ҳ��
	 */
	public String checkUI(){
		saleVist = saleVistService.findById(saleVist.getSv_id());
		ActionContext.getContext().getValueStack().push(saleVist);
		return "checkUI";
	}
	
	
	
	
	
	
	
	
	
	
}
