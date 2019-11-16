package com.crm.sale.web.action;

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
import com.crm.sale.service.SaleChanceService;
import com.crm.user.domain.User;
import com.crm.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 该类是销售机会的表现层的action类
 * @author 岑洛彬
 *
 */
public class SaleChanceAction extends ActionSupport implements ModelDriven<SaleChance>{
	//依赖注入
	private SaleChanceService saleChanceService;
	public void setSaleChanceService(SaleChanceService saleChanceService) {
		this.saleChanceService = saleChanceService;
	}
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//使用模型驱动封装数据
	private SaleChance saleChance = new SaleChance();
	public SaleChance getModel() {
		return saleChance;
	}
	//获取前端传来的页面相关的值
	private Integer currPage = 1;
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
	//获取当前登入用户的所有信息
	private User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
	/**
	 * 查询数据库中所有未分配的订单 	 
	 **/
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
		if(saleChance.getSale_name()!=null && !"".equals(saleChance.getSale_name())){
			dc.add(Restrictions.like("sale_name", "%"+saleChance.getSale_name()+"%"));
		}
		if(saleChance.getBaseDictSource()!=null){
			if(saleChance.getBaseDictSource().getDict_id()!=null && !"".equals(saleChance.getBaseDictSource().getDict_id())){
				dc.add(Restrictions.like("baseDictSource.dict_id", saleChance.getBaseDictSource().getDict_id()));
			}
		}
		if(saleChance.getBaseDictChanceComm()!=null){
			if(saleChance.getBaseDictChanceComm().getDict_id()!=null && !"".equals(saleChance.getBaseDictChanceComm().getDict_id())){
				dc.add(Restrictions.like("baseDictChanceComm.dict_id", saleChance.getBaseDictChanceComm().getDict_id()));
			}
		}
		if(saleChance.getSale_linkman()!=null && !"".equals(saleChance.getSale_linkman())){
			dc.add(Restrictions.like("sale_linkman", "%"+saleChance.getSale_linkman()+"%"));
		}
		//分页查询相应数据
		PageBean<SaleChance> pageBean = saleChanceService.findByPage(dc,currPage,pageSize);
		//手动压入栈顶
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findSuccess";
	}
	
	/**
	 * 跳转到添加页面，同时同步加载下拉框选项
	 */
	public String addUI(){
		//找到数据字典中所有的机会来源
		List<BaseDict> sourceList = baseDictService.findSource();
		//找到数据字典中所有的机会描述
		List<BaseDict> chanceCommList = baseDictService.findChanceComm();
		//存储到值栈中
		ActionContext.getContext().getValueStack().set("sourceList", sourceList);
		ActionContext.getContext().getValueStack().set("chanceCommList", chanceCommList);
		//设置当前登入的用户为创建人
		saleChance.setSale_buildman(user);
		//获取当前创建的时间
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		saleChance.setSale_date(dt.format(new Date()));
		return "addUI";
	}
	
	/**
	 * 添加新的销售机会
	 */
	public String add(){
		saleChance.setSale_buildman(user);
		saleChanceService.add(saleChance);
		return "addSuccess";
	}
	/**
	 * 删除记录
	 */
	public String delete(){
		//根据前端传来的值查找到需要进行操作的记录实体
		SaleChance newSaleChance = saleChanceService.findById(saleChance.getSale_id());
		//删除改条记录
		saleChanceService.delete(newSaleChance);
		return "deleSuccess";
	}
	/**
	 * 进入修改页面
	 */
	public String editUI(){
		//找到数据字典中所有的机会来源
		List<BaseDict> sourceList = baseDictService.findSource();
		//找到数据字典中所有的机会描述
		List<BaseDict> chanceCommList = baseDictService.findChanceComm();
		//存储到值栈中
		ActionContext.getContext().getValueStack().set("sourceList", sourceList);
		ActionContext.getContext().getValueStack().set("chanceCommList", chanceCommList);
		//根据前端传来的值查找到需要进行操作的记录实体
		saleChance = saleChanceService.findById(saleChance.getSale_id());
		ActionContext.getContext().getValueStack().push(saleChance);
		return "editUI";
	}
	/**
	 * 修改数据
	 */
	public String edit(){
		saleChance.setSale_buildman(user);
		saleChanceService.edit(saleChance);
		return "editSuccess";
	}
	/**
	 * 进入指派页面
	 */
	public String appointUI(){
		//找到数据字典中所有的机会来源
		List<BaseDict> sourceList = baseDictService.findSource();
		//找到数据字典中所有的机会描述
		List<BaseDict> chanceCommList = baseDictService.findChanceComm();
		//找出数据库中所有的客户经理
		List<User> userList = userService.findByPermis("2");
		//存储到值栈中
		ActionContext.getContext().getValueStack().set("sourceList", sourceList);
		ActionContext.getContext().getValueStack().set("chanceCommList", chanceCommList);
		ActionContext.getContext().getValueStack().set("userList", userList);
		//根据前端传来的值查找到需要进行操作的记录实体
		saleChance = saleChanceService.findById(saleChance.getSale_id());
		ActionContext.getContext().getValueStack().push(saleChance);
		//获取当前创建的时间
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		saleChance.setSale_respdate(dt.format(new Date()));
		
		return "appointUI";
	}
	/**
	 * 指派功能
	 */
	public String appoint(){
		//通过前端传的值取得当前销售机会
		SaleChance newSaleChance = saleChanceService.findById(saleChance.getSale_id());
		//根据选择的负责用户的id获取用户实体
		User respUser = userService.findById(saleChance.getSale_respman().getUser_id());
		//设置销售机会的指派人和时间
		newSaleChance.setSale_respman(respUser);
		newSaleChance.setSale_respdate(saleChance.getSale_respdate());
		newSaleChance.setSale_status("开发中");
		//数据库中进行更新
		saleChanceService.edit(newSaleChance);
		
		return "appointSuccess";
	}
	
}
