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
 * 该类是销售开发计划的表现层的action类
 * @author 岑洛彬
 *
 */
public class SalePlanAction extends ActionSupport implements ModelDriven<SalePlan> {
	/**
	 * 模型驱动封装数据
	 */
	private SalePlan salePlan = new SalePlan();
	public SalePlan getModel() {
		return salePlan;
	}
	/**
	 * 依赖注入
	 */
	private SalePlanService salePlanService;//开发计划的业务逻辑层实体
	public void setSalePlanService(SalePlanService salePlanService) {
		this.salePlanService = salePlanService;
	}
	private SaleChanceService saleChanceService;//销售机会的业务逻辑层实体
	public void setSaleChanceService(SaleChanceService saleChanceService) {
		this.saleChanceService = saleChanceService;
	}
	private BaseDictService baseDictService;//从数据字典中获取数据
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	private Integer currPage = 1;//分页实体中的首页
	private Integer pageSize = 3;//分页实体中每页显示的数据量
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
	//如下属性主要用于action方法中的查询
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
	//获取当前登入的用户
	private User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
	/*
	 * ---------分割线(以下是action中具体的实现方法)-----------
	 */
	
	/**
	 * 点击客户计划开发机会后进入的列表页
	 */
	public String findByPage(){
		//找到数据字典中所有的机会来源
		List<BaseDict> sourceList = baseDictService.findSource();
		//找到数据字典中所有的机会描述
		List<BaseDict> chanceCommList = baseDictService.findChanceComm();
		//存储到值栈中
		ActionContext.getContext().getValueStack().set("sourceList", sourceList);
		ActionContext.getContext().getValueStack().set("chanceCommList", chanceCommList);
		//建立离线查询
		DetachedCriteria dc = DetachedCriteria.forClass(SaleChance.class);
		//判断前端页面是否穿查询的值
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
	 * 点击查看详情之后进入开发计划制定页面
	 */
	public String checkUI(){
		//找到数据字典中所有的机会来源
		List<BaseDict> sourceList = baseDictService.findSource();
		//找到数据字典中所有的机会描述
		List<BaseDict> chanceCommList = baseDictService.findChanceComm();
		//存储到值栈中
		ActionContext.getContext().getValueStack().set("sourceList", sourceList);
		ActionContext.getContext().getValueStack().set("chanceCommList", chanceCommList);
		//获得查看详情的销售机会的实体
		SaleChance saleChance = saleChanceService.findById(sale_id);
		//将实体手动存入值栈中
		ActionContext.getContext().getValueStack().set("saleChance", saleChance);
		//获取这个实体下的开发记录
		List<SalePlan> newSalePlan = (List<SalePlan>) salePlanService.findByChanceId(sale_id);
		//将实体手动存入值栈中
		ActionContext.getContext().getValueStack().set("salePlan", newSalePlan);
		return "checkUI";
	}
	
	/**
	 * 点击新增记录后进入添加界面
	 */
	public String addUI(){
		//获得查看详情的销售机会的实体
		SaleChance saleChance = saleChanceService.findById(sale_id);
		//将实体手动存入值栈中
		ActionContext.getContext().getValueStack().set("saleChance", saleChance);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		salePlan.setPlan_date(df.format(new Date()));
		return "addUI";
	}
	/**
	 * 点击增加后往数据库中加入计划项
	 */
	public String add(){
		//获得查看详情的销售机会的实体
		System.out.println(sale_id);
		SaleChance newSaleChance = saleChanceService.findById(sale_id);
		System.out.println(newSaleChance.getSale_id());
		salePlan.setPlan_salechance(newSaleChance);
		salePlanService.add(salePlan);
		return "addSuccess";
	}
	
	/**
	 * 点击删除确认后进行删除
	 */
	public String delete(){
		//通过id获取计划实体
		SalePlan delSalePlan = salePlanService.findById(salePlan.getPlan_id());
		//根据这条记录获取销售计划的编号,用于返回checkUI.aciton
		sale_id = delSalePlan.getPlan_salechance().getSale_id();
		salePlanService.delete(delSalePlan);
		return "delSuccess";
	}
	/**
	 * 点击修改之后进入修改页面
	 */
	public String editUI(){
		//通过id获取计划实体
		salePlan = salePlanService.findById(salePlan.getPlan_id());
		//根据这条记录获取销售计划的编号,用于返回editUI.action
		sale_name = salePlan.getPlan_salechance().getSale_name();
		//手动压入栈顶
		ActionContext.getContext().getValueStack().push(salePlan);
		return "editUI";
	}
	/**
	 * 点击修改后对数据库中的数据进行修改
	 */
	public String edit(){
		//通过id获取计划实体
		SalePlan newSalePlan = salePlanService.findById(salePlan.getPlan_id());
		//通过计划实体获取外键
		sale_id = newSalePlan.getPlan_salechance().getSale_id();
		//通过外键获取到销售机会的实体
		SaleChance newSaleChance = saleChanceService.findById(newSalePlan.getPlan_salechance().getSale_id());
		//为这个新的实体设置外键
		salePlan.setPlan_salechance(newSaleChance);
		//直接调用业务逻辑层的方法对接收到的实体进行更新
		salePlanService.update(salePlan);
		return "editSuccess";
	}
	/**
	 * 点击开发失败后修改销售机会为开发失败
	 */
	public String planFail(){
		SaleChance chance = saleChanceService.findById(sale_id);
		chance.setSale_status("开发失败");
		saleChanceService.edit(chance);
		return "planFail";
	}
	/**
	 * 开发失败后点击删除
	 */
	public String deletePlan(){
		SaleChance chance = saleChanceService.findById(sale_id);
		saleChanceService.delete(chance);
		return "planDel";
	}
	/**
	 * 点击开发成功后修改销售机会为开发成功
	 */
	public String planSuccess(){
		SaleChance chance = saleChanceService.findById(sale_id);
		chance.setSale_status("开发成功");
		saleChanceService.edit(chance);
		return "planSuccess";
	}
	
	
	
}
