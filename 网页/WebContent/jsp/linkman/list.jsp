<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>

<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit();
		
	}
	function clean(){
		$("#lkm_name").val("");
		$("#lkm_gender option[value='"+''+"']").prop("selected","selected");
		$("#cust_id option[value='"+''+"']").prop("selected","selected");
		document.customerForm.submit();
	}
	function del(data){
		if(confirm("是否确认删除该联系人？")){
			window.location.href="${pageContext.request.contextPath }/linkMan_delete.action?lkm_id="+data;
		}
	}
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<s:form id="customerForm" name="customerForm" 
	action="linkMan_findByPage.action" namespace="/" method="post" theme="simple">
	
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>联系人名称：</TD>
													<TD>
														<s:textfield 
														id="lkm_name"
														cssClass="textbox" 
														style="WIDTH: 80px" maxLength="50"
														name="lkm_name"
														/>
													&nbsp;&nbsp;
													</TD>
													<TD>联系人性别：</TD>
													<td>
														<s:select 
														id="lkm_gender"
														list="#{'男':'男','女':'女' }" name="lkm_gender"
														headerKey="" headerValue="--请选择--"
													/>
													&nbsp;&nbsp;
													</td>
													<td>联系人所属客户:</td>
													<td>
													<s:select 
														id="cust_id"
														list="custList" name="lkm_customer.cust_id"
														headerKey="" headerValue="--请选择--"
														listKey="cust_id" listValue="cust_name"
													/>
													&nbsp;&nbsp;
													</td>
													<TD>
													<INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2>
													<INPUT class=button id=sButton2 type=button
														value=" 清空 " name=sButton2 onclick="clean()">
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													</TD>
													
													<td>
														<a href="${pageContext.request.contextPath }/linkMan_addUI.action">新增联系人</a>
													</td>
													
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>联系人名称</TD>
													<TD>性别</TD>
													<TD>职位</TD>
													<TD>手机</TD>
													<TD>邮箱</TD>
													<TD>QQ</TD>
													<TD>所属客户</TD>
													<TD>操作</TD>
													
												</TR>
												<s:iterator value="list" var="i">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD><s:property value="#i.lkm_name"/></TD>
													<TD><s:property value="#i.lkm_gender"/></TD>
													<TD><s:property value="#i.lkm_position"/></TD>
													<TD><s:property value="#i.lkm_mobile"/></TD>
													<TD><s:property value="#i.lkm_email"/></TD>
													<TD><s:property value="#i.lkm_qq"/></TD>
													<TD><s:property value="#i.lkm_customer.cust_name"/>
													</TD>
													<TD>
													<a href="${pageContext.request.contextPath }/linkMan_editUI.action?lkm_id=<s:property value='#i.lkm_id'/>">修改</a>
													&nbsp;&nbsp;
													<a onclick="del(<s:property value='#i.lkm_id'/>)">删除</a>
													</TD>
												</TR>
												
												</s:iterator>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD align="right"><SPAN id=pagelink>
											<jsp:include page="/page.jsp"></jsp:include>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</s:form>
</BODY>
</HTML>
