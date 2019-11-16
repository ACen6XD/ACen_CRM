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
 * �������û����ֲ��action��
 * @author ����
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	//ģ��������װ����
	private User user = new User();
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//����ע��
	private UserService userService ;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private BaseDictService baseDictService;
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
	/**
	 * �û�����ע�������ͬ�������û���ɫ
	 */
	public String registUI(){
		List<BaseDict> permissionList = baseDictService.findPermission();
		ActionContext.getContext().getValueStack().set("permissionList", permissionList);
		return "toRegistUI";
	}
	/**
	 * ע���û��ķ���
	 */
	public String regist(){
		//����Ѿ����ڸ��˻�
		if(userService.findByLoginName(user.getUser_loginname()) != null){
		this.addActionError("�Ѵ��ڸ��˺�,������ע��");
			return INPUT;
		}
		userService.add(user);
		ActionContext.getContext().getValueStack().set("msg", "ע��ɹ�,�����!");
		return "registSuccess";
	}
	/**
	 * �û�����ķ���
	 */
	public String login(){
		//�ж��Ƿ�����Ϣû������
		User loginUser = userService.login(user);
		if(loginUser == null){//������û�������
			ActionContext.getContext().getValueStack().set("msg", "�û������������!");
			return LOGIN;
		}else{//������û�����
			//�������û�����ֵջ��,�����첽������ʾ�û�Ȩ��
//			ActionContext.getContext().getValueStack().set("loginUser", loginUser);
			//�������û�����ֵջ��
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", loginUser);
		}
		return "loginSuccess";
	}
	/**
	 * �û��˳�
	 */
	public String logOut(){
		ServletActionContext.getRequest().getSession().removeAttribute("loginUser");
		return LOGIN;
	}
	/**
	 * �߹ܽ����鿴��ǰ����������˻�
	 */
	public String findByPage(){
		//�������ֵ���ȡ���û���ɫ
		List<BaseDict> permissionList = baseDictService.findPermission();
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		//�ж�ǰ���Ƿ�����ѯ
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
		//��ֵ����ֵջ��
		ActionContext.getContext().getValueStack().set("permissionList", permissionList);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findSuccess";
	}
	/**
	 * �����û��޸Ľ���
	 */
	public String editUI(){
		//�������ֵ���ȡ���û���ɫ
		List<BaseDict> permissionList = baseDictService.findPermission();
		//�����û�id��ȡ�û�
		user = userService.findById(user.getUser_id());
		//��ֵ����ֵջ��
		ActionContext.getContext().getValueStack().push(user);
		ActionContext.getContext().getValueStack().set("permissionList", permissionList);
		return "editUI";
	}
	/**
	 * �޸��û�
	 */
	public String edit(){
		userService.edit(user);
		return "editSuccess";
	}
	/**
	 * ɾ���û�
	 */
	public String delete(){
		userService.delete(user);
		return "delSuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
