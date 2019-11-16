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
 * �����ǿͻ���ı��ֲ��action��
 * @author ����
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	/**
	 * ģ����������װ����
	 */
	private Customer customer = new Customer();
	public Customer getModel() {
		return customer;
	}
	/**
	 * ����ע��
	 */
	private CustomerService customerService;//�ͻ�����ҵ����߼�
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	private SaleChanceService saleChanceService;//���ۻ����ҵ���߼�
	public void setSaleChanceService(SaleChanceService saleChanceService) {
		this.saleChanceService = saleChanceService;
	}
	private BaseDictService baseDictService;//�����ֵ��ҵ���߼�
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
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
	//��ȡ��ǰ�����û� 
	private User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
	private Integer sale_id;//�����ɹ������ۻ����id
	public Integer getSale_id() {
		return sale_id;
	}
	
	public void setSale_id(Integer sale_id) {
		this.sale_id = sale_id;
	}
	
	/*
	 * ---------------�ָ���(������action�и������������ʵ��)-------------------
	 */
	

	/**
	 * ȷ����������ϸ�ͻ���Ϣ�󣬽�����ӽ���
	 */
	public String addUI(){
		//�������ֵ��л�ȡ�ͻ���Դ�������б�
		List<BaseDict> custSourceList = baseDictService.findByTypeCode("1");
		//�������ֵ��л�ȡ�ͻ�����������б�
		List<BaseDict> custLevelList = baseDictService.findByTypeCode("4");
		//�������ֵ��л�ȡ�ͻ�������ҵ�������б�
		List<BaseDict> custIndurstyList = baseDictService.findByTypeCode("5");
		//�������ֵ��л�ȡ�ͻ����������������б�
		List<BaseDict> custAreaList = baseDictService.findByTypeCode("6");
		//��ȡ�������ɹ������ۻ����ʵ��
		SaleChance saleChance = saleChanceService.findById(sale_id);
		//�ӿ����ɹ������ۻ����ʵ���л�ȡ�ͻ����ƺͿͻ���Դ
		customer.setCust_name(saleChance.getSale_name());
		customer.setCust_source(saleChance.getBaseDictSource());
		//ͬʱ���ÿͻ�������ʱ��
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		customer.setCust_date(df.format(new Date()));
		//���ÿͻ�������,����ǰ������û�
		customer.setCust_respman(user);
		//�ֶ�ѹ��ֵջ��
		ActionContext.getContext().getValueStack().set("saleChance",saleChance);
		ActionContext.getContext().getValueStack().set("custSourceList",custSourceList);
		ActionContext.getContext().getValueStack().set("custLevelList",custLevelList);
		ActionContext.getContext().getValueStack().set("custAreaList",custAreaList);
		ActionContext.getContext().getValueStack().set("custIndurstyList",custIndurstyList);
		return "addUI";
	}
	/**
	 * ����ύ��,��Ӹÿͻ�����Ϣ
	 */
	public String add(){
		//ͨ��id��ȡ�������ɹ������ۻ����ʵ��
		SaleChance saleChance = saleChanceService.findById(sale_id);
		//�ӿ����ɹ������ۻ����ʵ���л�ȡ�ͻ���Դ
		customer.setCust_source(saleChance.getBaseDictSource());
		//���ÿͻ�������,����ǰ������û�
		customer.setCust_respman(user);
		//���ͻ����д�����ϸ�ͻ���Ϣ
		customerService.add(customer);
		//ɾ�����ۻ����е���ɿ���������
		saleChanceService.delete(saleChance);
		return "addSuccess";
	}
	/**
	 * ����ͻ�����������ʾ����ǰ�˻��µĿͻ�
	 */
	public String findByPage(){
		//�������ֵ��л�ȡ�ͻ���Դ�������б�
		List<BaseDict> custSourceList = baseDictService.findByTypeCode("1");
		//�������ֵ��л�ȡ�ͻ�����������б�
		List<BaseDict> custLevelList = baseDictService.findByTypeCode("4");
		//�������ֵ��л�ȡ�ͻ�������ҵ�������б�
		List<BaseDict> custIndurstyList = baseDictService.findByTypeCode("5");
		//�������ֵ��л�ȡ�ͻ����������������б�
		List<BaseDict> custAreaList = baseDictService.findByTypeCode("6");
		//�½�һ����ҳʵ�壬���ڴ���б�ҳ�еķ�ҳ��Ϣ
		PageBean<Customer> pageBean = new PageBean<Customer>();
		//�½�һ�����߲�ѯ
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//�ж�ǰ���Ƿ�����Ҫ��ѯ��ֵ����
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
		//����ҵ����߼�����ҳʵ�帳ֵ
		pageBean = customerService.findByPage(dc,currPage,pageSize,user);
		//�ж���ҳ�в�ѯ����
		//�ֶ�ѹ��ֵջ
		ActionContext.getContext().getValueStack().push(pageBean);
		ActionContext.getContext().getValueStack().set("custSourceList",custSourceList);
		ActionContext.getContext().getValueStack().set("custLevelList",custLevelList);
		ActionContext.getContext().getValueStack().set("custIndurstyList",custIndurstyList);
		ActionContext.getContext().getValueStack().set("custAreaList",custAreaList);
		return "findSuccess";
	}
	/**
	 * ����޸ĺ�����޸Ľ���
	 */
	public String editUI(){
		//�������ֵ��л�ȡ�ͻ���Դ�������б�
		List<BaseDict> custSourceList = baseDictService.findByTypeCode("1");
		//�������ֵ��л�ȡ�ͻ�����������б�
		List<BaseDict> custLevelList = baseDictService.findByTypeCode("4");
		//�������ֵ��л�ȡ�ͻ�������ҵ�������б�
		List<BaseDict> custIndurstyList = baseDictService.findByTypeCode("5");
		//�������ֵ��л�ȡ�ͻ����������������б�
		List<BaseDict> custAreaList = baseDictService.findByTypeCode("6");
		//���ݴ��ݽ�����cust_id��ȡҪ�޸ĵ��û���������Ϣ
		customer = customerService.findById(customer.getCust_id());
		//�ֶ�ѹ��ֵջ
		ActionContext.getContext().getValueStack().push(customer);
		ActionContext.getContext().getValueStack().set("custSourceList",custSourceList);
		ActionContext.getContext().getValueStack().set("custLevelList",custLevelList);
		ActionContext.getContext().getValueStack().set("custIndurstyList",custIndurstyList);
		ActionContext.getContext().getValueStack().set("custAreaList",custAreaList);
		return "editUI";
	}
	
	/**
	 * ����޸�֮��
	 */
	public String edit(){
		//customer = customerService.findById(customer.getCust_id());
		customer.setCust_respman(user);
		//����ҵ����߼������û�
		customerService.edit(customer);
		return "editSuccess";
	}
	/**
	 * ���ɾ��֮��ɾ����������
	 */
	public String delete(){
		//����ҵ����߼�ɾ���û�
		customerService.delete(customer);
		return "deleteSuccess";
	}
	/**
	 * ����鿴��ϸ��Ϣ������Ϣ�鿴����
	 */
	public String checkUI(){
		//�������ֵ��л�ȡ�ͻ���Դ�������б�
		List<BaseDict> custSourceList = baseDictService.findByTypeCode("1");
		//�������ֵ��л�ȡ�ͻ�����������б�
		List<BaseDict> custLevelList = baseDictService.findByTypeCode("4");
		//�������ֵ��л�ȡ�ͻ�������ҵ�������б�
		List<BaseDict> custIndurstyList = baseDictService.findByTypeCode("5");
		//�������ֵ��л�ȡ�ͻ����������������б�
		List<BaseDict> custAreaList = baseDictService.findByTypeCode("6");
		//���ݴ��ݽ�����cust_id��ȡҪ�޸ĵ��û���������Ϣ
		customer = customerService.findById(customer.getCust_id());
		//�ֶ�ѹ��ֵջ
		ActionContext.getContext().getValueStack().push(customer);
		ActionContext.getContext().getValueStack().set("custSourceList",custSourceList);
		ActionContext.getContext().getValueStack().set("custLevelList",custLevelList);
		ActionContext.getContext().getValueStack().set("custIndurstyList",custIndurstyList);
		ActionContext.getContext().getValueStack().set("custAreaList",custAreaList);
		return "checkUI";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
