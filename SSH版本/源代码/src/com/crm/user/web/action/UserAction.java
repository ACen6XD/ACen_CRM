package com.crm.user.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.basedict.domain.BaseDict;
import com.crm.basedict.service.BaseDictService;
import com.crm.common.domain.PageBean;
import com.crm.user.domain.User;
import com.crm.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 该类是用户表现层的action类
 * @author 岑洛彬
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	//模型驱动封装数据
	private User user = new User();
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//依赖注入
	private UserService userService ;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private BaseDictService baseDictService;
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
	/**
	 * 用户进入注册界面是同步加载用户角色
	 */
	public String registUI(){
		List<BaseDict> permissionList = baseDictService.findPermission();
		ActionContext.getContext().getValueStack().set("permissionList", permissionList);
		return "toRegistUI";
	}
	/**
	 * 注册用户的方法
	 */
	public String regist(){
		//如果已经存在该账户
		if(userService.findByLoginName(user.getUser_loginname()) != null){
		this.addActionError("已存在该账号,请重新注册");
			return INPUT;
		}
		userService.add(user);
		ActionContext.getContext().getValueStack().set("msg", "注册成功,请登入!");
		return "registSuccess";
	}
	/**
	 * 用户登入的方法
	 */
	public String login(){
		//判断是否有信息没有输入
		User loginUser = userService.login(user);
		if(loginUser == null){//如果该用户不存在
			ActionContext.getContext().getValueStack().set("msg", "用户名或密码错误!");
			return LOGIN;
		}else{//如果该用户存在
			//将登入用户存入值栈中,用于异步加载显示用户权限
//			ActionContext.getContext().getValueStack().set("loginUser", loginUser);
			//将登入用户存入值栈中
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", loginUser);
		}
		return "loginSuccess";
	}
	/**
	 * 用户退出
	 */
	public String logOut(){
		ServletActionContext.getRequest().getSession().removeAttribute("loginUser");
		return LOGIN;
	}
	/**
	 * 高管进入后查看当前登入的所有账户
	 */
	public String findByPage(){
		//从数据字典中取出用户角色
		List<BaseDict> permissionList = baseDictService.findPermission();
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		//判断前端是否传来查询
		if(user.getUser_loginname()!=null && !"".equals(user.getUser_loginname())){
			dc.add(Restrictions.like("user_loginname", "%"+user.getUser_loginname()+"%"));
		}
		if(user.getUser_realname()!=null && !"".equals(user.getUser_realname())){
			dc.add(Restrictions.like("user_realname", "%"+user.getUser_realname()+"%"));
		}
		if(user.getBaseDictPermission()!=null){
			if(user.getBaseDictPermission().getDict_id()!=null && !"".equals(user.getBaseDictPermission().getDict_id())){
				dc.add(Restrictions.eq("baseDictPermission.dict_id", user.getBaseDictPermission().getDict_id()));
			}
		}
		PageBean<User> pageBean = userService.findByPage(dc,currPage,pageSize);
		//将值存入值栈中
		ActionContext.getContext().getValueStack().set("permissionList", permissionList);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findSuccess";
	}
	/**
	 * 进入用户修改界面
	 */
	public String editUI(){
		//从数据字典中取出用户角色
		List<BaseDict> permissionList = baseDictService.findPermission();
		//根据用户id获取用户
		user = userService.findById(user.getUser_id());
		//将值存入值栈中
		ActionContext.getContext().getValueStack().push(user);
		ActionContext.getContext().getValueStack().set("permissionList", permissionList);
		return "editUI";
	}
	/**
	 * 修改用户
	 */
	public String edit(){
		userService.edit(user);
		return "editSuccess";
	}
	/**
	 * 删除用户
	 */
	public String delete(){
		userService.delete(user);
		return "delSuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
