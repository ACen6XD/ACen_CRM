<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户访问记录列表</TITLE> 
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
	function add(){
		window.location.href="${pageContext.request.contextPath }/saleVist_addUI.action";
		
	}
	function del(data){
		if(confirm("是否确认该记录?")){
			window.location.href="${pageContext.request.contextPath }/saleVist_delete.action?sv_id="+data;
		}
	}
	function clean(){
		$("#custid option[value='"+''+"']").prop("selected","selected");
		document.customerForm.submit();
	}
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/saleVist_findByPage.action"
		method=post>
		
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
								<TD class=manageHead>当前位置：客户访问记录管理 &gt; 客户访问记录列表</TD>
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
													<TD>客户名称：</TD>
													<TD>
														<s:select 
														id="custid"
														name="sv_cust_id.cust_id"
														list="custList"
														headerKey=""
														headerValue="--请选择--"
														listKey="cust_id"
														listValue="cust_name"
														theme="simple"
														/>
														&nbsp;&nbsp;
													</TD>
													
			
													
													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2>&nbsp;</TD>
													<TD><INPUT class=button id=sButton3 type=button onclick="clean()"
														value="清空 " name=sButton3>
														
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="button" onclick="add()" value="  新增记录  ">	
													</TD>
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
													<TD>访问时间</TD>
													<TD>访问地点</TD>
													<TD>访问概要</TD>
													<td>查看</td>
													<TD>操作</TD>
												</TR>
												<s:iterator value="list" var="i">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD><s:property value="#i.sv_cust_id.cust_name"  /></TD>
													<TD><s:date name="#i.sv_date" format="yyyy-MM-dd"/></TD>
													<TD><s:property value="#i.sv_address" /></TD>
													<TD><s:property value="#i.sv_sketch"  /></TD>
													<td>
														<a href="${pageContext.request.contextPath }/saleVist_checkUI.action?sv_id=<s:property value="#i.sv_id" />">查看详情</a>
													</td>
													<TD>
													<a href="${pageContext.request.contextPath }/saleVist_editUI.action?sv_id=<s:property value="#i.sv_id" />">修改</a>
													&nbsp;
													<a onclick="del(<s:property value="#i.sv_id" />)">删除</a>
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
	</FORM>
</BODY>

</HTML>
