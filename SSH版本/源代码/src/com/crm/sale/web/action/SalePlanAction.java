package com.crm.sale.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.basedict.domain.BaseDict;
import com.crm.basedict.service.BaseDictService;
import com.crm.common.domain.PageBean;
import com.crm.sale.domain.SaleChance;
import com.crm.sale.domain.SalePlan;
import com.crm.sale.service.SaleChanceService;
import com.crm.sale.service.SalePlanService;
import com.crm.user.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ���������ۿ����ƻ��ı��ֲ��action��
 * @author ����
 *
 */
public class SalePlanAction extends ActionSupport implements ModelDriven<SalePlan> {
	/**
	 * ģ��������װ����
	 */
	private SalePlan salePlan = new SalePlan();
	public SalePlan getModel() {
		return salePlan;
	}
	/**
	 * ����ע��
	 */
	private SalePlanService salePlanService;//�����ƻ���ҵ���߼���ʵ��
	public void setSalePlanService(SalePlanService salePlanService) {
		this.salePlanService = salePlanService;
	}
	private SaleChanceService saleChanceService;//���ۻ����ҵ���߼���ʵ��
	public void setSaleChanceService(SaleChanceService saleChanceService) {
		this.saleChanceService = saleChanceService;
	}
	private BaseDictService baseDictService;//�������ֵ��л�ȡ����
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	private Integer currPage = 1;//��ҳʵ���е���ҳ
	private Integer pageSize = 3;//��ҳʵ����ÿҳ��ʾ��������
	public void setCurrPage(Integer currPage) {
		if(currPage == 0){
			currPage = 1;
		}
		this.currPage = currPage;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize == 0){
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}
	//����������Ҫ����action�����еĲ�ѯ
	private String sale_name;
	private String sale_linkman;
	private String sale_status;
	private Integer sale_id;
	public Integer getSale_id() {
		return sale_id;
	}
	public void setSale_id(Integer sale_id) {
		this.sale_id = sale_id;
	}
	public void setSale_status(String sale_status) {
		this.sale_status = sale_status;
	}
	public void setSale_name(String sale_name) {
		this.sale_name = sale_name;
	}
	public String getSale_name() {
		return sale_name;
	}
	public void setSale_linkman(String sale_linkman) {
		this.sale_linkman = sale_linkman;
	}
	//��ȡ��ǰ������û�
	private User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
	/*
	 * ---------�ָ���(������action�о����ʵ�ַ���)-----------
	 */
	
	/**
	 * ����ͻ��ƻ���������������б�ҳ
	 */
	public String findByPage(){
		//�ҵ������ֵ������еĻ�����Դ
		List<BaseDict> sourceList = baseDictService.findSource();
		//�ҵ������ֵ������еĻ�������
		List<BaseDict> chanceCommList = baseDictService.findChanceComm();
		//�洢��ֵջ��
		ActionContext.getContext().getValueStack().set("sourceList", sourceList);
		ActionContext.getContext().getValueStack().set("chanceCommList", chanceCommList);
		//�������߲�ѯ
		DetachedCriteria dc = DetachedCriteria.forClass(SaleChance.class);
		//�ж�ǰ��ҳ���Ƿ񴩲�ѯ��ֵ
		if(sale_name!=null && !"".equals(sale_name)){
			dc.add(Restrictions.like("sale_name", "%"+sale_name+"%"));
		}
		if(sale_status!=null && !"".equals(sale_status)){
			dc.add(Restrictions.eq("sale_status", sale_status));
		}

		if(sale_linkman!=null && !"".equals(sale_linkman)){
			dc.add(Restrictions.like("sale_linkman", "%"+sale_linkman+"%"));
		}
		PageBean<SaleChance> saleChanceList = saleChanceService.findPermisByPage(dc,currPage, pageSize,user.getUser_id());
		ActionContext.getContext().getValueStack().push(saleChanceList );
		return "findSuccess";
	}
	
	/**
	 * ����鿴����֮����뿪���ƻ��ƶ�ҳ��
	 */
	public String checkUI(){
		//�ҵ������ֵ������еĻ�����Դ
		List<BaseDict> sourceList = baseDictService.findSource();
		//�ҵ������ֵ������еĻ�������
		List<BaseDict> chanceCommList = baseDictService.findChanceComm();
		//�洢��ֵջ��
		ActionContext.getContext().getValueStack().set("sourceList", sourceList);
		ActionContext.getContext().getValueStack().set("chanceCommList", chanceCommList);
		//��ò鿴��������ۻ����ʵ��
		SaleChance saleChance = saleChanceService.findById(sale_id);
		//��ʵ���ֶ�����ֵջ��
		ActionContext.getContext().getValueStack().set("saleChance", saleChance);
		//��ȡ���ʵ���µĿ�����¼
		List<SalePlan> newSalePlan = (List<SalePlan>) salePlanService.findByChanceId(sale_id);
		//��ʵ���ֶ�����ֵջ��
		ActionContext.getContext().getValueStack().set("salePlan", newSalePlan);
		return "checkUI";
	}
	
	/**
	 * ���������¼�������ӽ���
	 */
	public String addUI(){
		//��ò鿴��������ۻ����ʵ��
		SaleChance saleChance = saleChanceService.findById(sale_id);
		//��ʵ���ֶ�����ֵջ��
		ActionContext.getContext().getValueStack().set("saleChance", saleChance);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		salePlan.setPlan_date(df.format(new Date()));
		return "addUI";
	}
	/**
	 * ������Ӻ������ݿ��м���ƻ���
	 */
	public String add(){
		//��ò鿴��������ۻ����ʵ��
		System.out.println(sale_id);
		SaleChance newSaleChance = saleChanceService.findById(sale_id);
		System.out.println(newSaleChance.getSale_id());
		salePlan.setPlan_salechance(newSaleChance);
		salePlanService.add(salePlan);
		return "addSuccess";
	}
	
	/**
	 * ���ɾ��ȷ�Ϻ����ɾ��
	 */
	public String delete(){
		//ͨ��id��ȡ�ƻ�ʵ��
		SalePlan delSalePlan = salePlanService.findById(salePlan.getPlan_id());
		//����������¼��ȡ���ۼƻ��ı��,���ڷ���checkUI.aciton
		sale_id = delSalePlan.getPlan_salechance().getSale_id();
		salePlanService.delete(delSalePlan);
		return "delSuccess";
	}
	/**
	 * ����޸�֮������޸�ҳ��
	 */
	public String editUI(){
		//ͨ��id��ȡ�ƻ�ʵ��
		salePlan = salePlanService.findById(salePlan.getPlan_id());
		//����������¼��ȡ���ۼƻ��ı��,���ڷ���editUI.action
		sale_name = salePlan.getPlan_salechance().getSale_name();
		//�ֶ�ѹ��ջ��
		ActionContext.getContext().getValueStack().push(salePlan);
		return "editUI";
	}
	/**
	 * ����޸ĺ�����ݿ��е����ݽ����޸�
	 */
	public String edit(){
		//ͨ��id��ȡ�ƻ�ʵ��
		SalePlan newSalePlan = salePlanService.findById(salePlan.getPlan_id());
		//ͨ���ƻ�ʵ���ȡ���
		sale_id = newSalePlan.getPlan_salechance().getSale_id();
		//ͨ�������ȡ�����ۻ����ʵ��
		SaleChance newSaleChance = saleChanceService.findById(newSalePlan.getPlan_salechance().getSale_id());
		//Ϊ����µ�ʵ���������
		salePlan.setPlan_salechance(newSaleChance);
		//ֱ�ӵ���ҵ���߼���ķ����Խ��յ���ʵ����и���
		salePlanService.update(salePlan);
		return "editSuccess";
	}
	/**
	 * �������ʧ�ܺ��޸����ۻ���Ϊ����ʧ��
	 */
	public String planFail(){
		SaleChance chance = saleChanceService.findById(sale_id);
		chance.setSale_status("����ʧ��");
		saleChanceService.edit(chance);
		return "planFail";
	}
	/**
	 * ����ʧ�ܺ���ɾ��
	 */
	public String deletePlan(){
		SaleChance chance = saleChanceService.findById(sale_id);
		saleChanceService.delete(chance);
		return "planDel";
	}
	/**
	 * ��������ɹ����޸����ۻ���Ϊ�����ɹ�
	 */
	public String planSuccess(){
		SaleChance chance = saleChanceService.findById(sale_id);
		chance.setSale_status("�����ɹ�");
		saleChanceService.edit(chance);
		return "planSuccess";
	}
	
	
	
}
