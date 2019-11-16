<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function clean(){
		$("#cust_name").val("");
		$("#cust_area option[value='"+''+"']").prop("selected","selected");
		$("#cust_indursty option[value='"+''+"']").prop("selected","selected");
		$("#cust_source option[value='"+''+"']").prop("selected","selected");
		$("#cust_level option[value='"+''+"']").prop("selected","selected");
		document.customerForm.submit();
	}
	function del(data){
		if(confirm("是否确认删除该客户？(提示：客户信息删除后，其所有的相关联系人及访问信息都会被删除，请确认您的操作)")){
			window.location.href="${pageContext.request.contextPath }/customer_delete.action?cust_id="+data;
		}
	}
</script>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit();
		
	}
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<s:form id="customerForm" name="customerForm" method="post" namespace="/" action="customer_findByPage.action" theme="simple">
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
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
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
													<TD>客户名称:</TD>
													<TD>
													<input type="text" class=textbox 
													style="WIDTH: 80px" 
													maxLength=50 
													id="cust_name"
													name="cust_name" 
													value="<s:property value='model.cust_name'/>">
													&nbsp;
													</TD>
												
													<td>客户地区 :</td>
													<td>
														<s:select 
															id="cust_area"
															name="cust_area.dict_id"
															list="custAreaList"
															headerKey=""
															headerValue="--请选择--"
															listKey="dict_id"
															listValue="dict_item_name" 
														/>
														&nbsp;
													</td>
												
													<td>客户级别 :</td>
													<td>
														<s:select 
															id="cust_level"
															name="cust_level.dict_id"
															list="custLevelList"
															headerKey=""
															headerValue="--请选择--"
															listKey="dict_id"
															listValue="dict_item_name" 
														/>
														&nbsp;
													</td>
													
													<td>客户来源 :</td>
													<td>
														<s:select 
															id="cust_source"
															name="cust_source.dict_id"
															list="custSourceList"
															headerKey=""
															headerValue="--请选择--"
															listKey="dict_id"
															listValue="dict_item_name" 
														/>
													&nbsp;
													</td>
													
													<td>所属行业 :</td>
													<td>
														<s:select 
															id="cust_indursty"
															name="cust_indursty.dict_id"
															list="custIndurstyList"
															headerKey=""
															headerValue="--请选择--"
															listKey="dict_id"
															listValue="dict_item_name" 
														/>
													&nbsp;
													</td>
												
													
													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
													<TD><INPUT class=button id=sButton3 type=button onclick="clean()"
														value="清空 " name=sButton3></TD>
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
													<TD>客户名称</TD>
													<td>客户地区</td>
													<TD>客户级别</TD>
													<TD>客户来源</TD>
													<TD>所属行业</TD>
													<TD>客户电话</TD>
													<TD>客户邮箱</TD>
													<td>详情</td>
													<TD>操作</TD>
												</TR>
												<s:iterator value="list" var="i">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD><s:property value="#i.cust_name" /></TD>
													<td><s:property value="#i.cust_area.dict_item_name" /></td>
													<TD><s:property value="#i.cust_level.dict_item_name"  /></TD>
													<TD><s:property value="#i.cust_source.dict_item_name"/></TD>
													<TD><s:property value="#i.cust_indursty.dict_item_name" /></TD>
													<TD><s:property value="#i.cust_phone"  /></TD>
													<TD><s:property value="#i.cust_mail"  /></TD>
													<TD>
													<a href="${pageContext.request.contextPath }/customer_checkUI.action?cust_id=<s:property value="#i.cust_id" />">查看详情</a>
													&nbsp;
													
													<a href="${pageContext.request.contextPath }/linkMan_findByCust.action?cust_id=<s:property value="#i.cust_id" />">查看联系人</a>
					
													</td>
													<TD>
													<a href="${pageContext.request.contextPath }/customer_editUI.action?cust_id=<s:property value="#i.cust_id" />">修改</a>
													&nbsp;
													
													<a  onclick="del(<s:property value="#i.cust_id" />)">删除</a>
													</TD>
												</TR>
												</s:iterator>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV align="right">
												<jsp:include page="/page.jsp"></jsp:include>
											</DIV>
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
