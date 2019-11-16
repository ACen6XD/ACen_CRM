package com.crm.basedict.web.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.crm.basedict.domain.BaseDict;
import com.crm.basedict.service.BaseDictService;
import com.crm.common.domain.PageBean;
import com.crm.customer.domain.Customer;
import com.crm.user.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 该文档是数据字典的action类
 * @author 岑洛彬
 *
 */
public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict>{
	//依赖注入
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	//模型驱动封装数据
	private BaseDict baseDict = new  BaseDict();
	public BaseDict getModel() {
		return baseDict;
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
	//异步加载显示用户的登入权限
	public String findPremis() throws IOException{
		//通过登入的用户获得用户在数据字典中的实体
		BaseDict newBaseDict = baseDictService.findById(baseDict.getDict_id());
		
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); // 自动为我排除circle。  
		
		jsonConfig.setExcludes(new String[] { "baseDictPermission" }); // 设置转换中忽略的属性
		JSONObject jsonBaseDict = JSONObject.fromObject(newBaseDict,jsonConfig);
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(jsonBaseDict.toString());
		return NONE;
	}
	/**
	 * 按分页查找所有的数据字典信息
	 */
	public String findByPage(){
		//新建一个离线查询
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		//判断前端是否有传值
		if(baseDict.getDict_item_name()!=null && !"".equals(baseDict.getDict_item_name())){
			dc.add(Restrictions.like("dict_item_name", "%"+baseDict.getDict_item_name()+"%"));
		}
		if(baseDict.getDict_type_name()!=null && !"".equals(baseDict.getDict_type_name())){
			dc.add(Restrictions.eq("dict_type_name", baseDict.getDict_type_name()));
		}
		//找出所有的记录分装成分页实体
		PageBean<BaseDict> pageBean = baseDictService.findByPage(dc,currPage,pageSize);
		//找出所有的类别
		List<String> listTypeName = baseDictService.findAllTypeName();
		//手动存入值栈
		ActionContext.getContext().getValueStack().push(pageBean);
		ActionContext.getContext().getValueStack().set("listTypeName", listTypeName);
		return "findSuccess";
	}
	/**
	 * 点击修改进入修改页面
	 */
	public String editUI(){
		baseDict = baseDictService.findById(baseDict.getDict_id());
		ActionContext.getContext().getValueStack().push(baseDict);
		return "editUI";
	}
	/**
	 * 修改数据
	 */
	public String edit(){
		baseDictService.edit(baseDict);
		return "editSuccess";
	}
	/**
	 * 点击进入添加新数据的页面
	 */
	public String addUI(){
		//找出所有的类别
		List<String> listTypeName = baseDictService.findAllTypeName();
		//手动存入值栈
		ActionContext.getContext().getValueStack().set("listTypeName", listTypeName);
		return "addUI";
	}
	/**
	 * @param
	 * @return
	 * 点击添加进行数据添加
	 */
	public String add(){
		if(baseDict.getDict_type_name().equals("机会来源")){
			baseDict.setDict_type_code("1");
		}else if(baseDict.getDict_type_name().equals("机会描述")){
			baseDict.setDict_type_code("2");
		}else if(baseDict.getDict_type_name().equals("用户角色")){
			baseDict.setDict_type_code("3");
		}else if(baseDict.getDict_type_name().equals("客户级别")){
			baseDict.setDict_type_code("4");
		}else if(baseDict.getDict_type_name().equals("客户所属行业")){
			baseDict.setDict_type_code("5");
		}else {
			baseDict.setDict_type_code("6");
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		baseDict.setDict_id(df.format(new Date()));
		baseDictService.save(baseDict);
		return "addSuccess";
	}
	/**
	 * 点击删除进行数据删除
	 */
	public String delete(){
		baseDict = baseDictService.findById(baseDict.getDict_id());
		baseDictService.delete(baseDict);
		return "deleteSuccess";
	}
}
