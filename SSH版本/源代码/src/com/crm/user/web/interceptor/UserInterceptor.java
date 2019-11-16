package com.crm.user.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.crm.user.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		if(user == null){//没有用户登入
			ActionSupport action = (ActionSupport) invocation.getAction();
			action.addActionError("请先登入！");
			return action.LOGIN;
		}
		return invocation.invoke();
	}

}
