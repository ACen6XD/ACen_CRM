<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>销售机会列表</TITLE> 
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
	function addUI(){
    	window.location.href="${pageContext.request.contextPath }/saleChance_addUI.action";
	}
	function clean(){
		$("#sale_name").val("")
		$("#baseDictSource").val("")
		$("#baseDictChanceComm").val("")
		$("#sale_linkman").val("")
		document.customerForm.submit();
	}
	function del(data){
		if(confirm("是否确认删除?")){
			//var sale_id = $("#saleid").val();
			var sale_id = data;
			//alert(sale_id);
			location.href="${pageContext.request.contextPath }/saleChance_delete.action?sale_id="+sale_id;
			alert("删除成功");
			
		}
	}
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/saleChance_findByPage.action"
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
													<TD>客户名称：</TD>
													<TD>
													<s:textfield 
														id="sale_name"
														cssClass="textbox"
														style="WIDTH: 80px"
														maxLength="50"
														name="sale_name"
														theme="simple"
													/>
													&nbsp;
													</TD>
													
													<td>机会来源 ：</td>
													<td>
													<s:select 
														id="baseDictSource"
														list="sourceList" 
														name="baseDictSource.dict_id"
														headerKey="" headerValue="--请选择--"
														listKey="dict_id" listValue="dict_item_name"
														theme="simple"
													/>
													&nbsp;&nbsp;
													</td>
													
													<td>机会描述 ：</td>
													<td>
													<s:select 
														id="baseDictChanceComm"
														list="chanceCommList" 
														name="baseDictChanceComm.dict_id"
														headerKey="" headerValue="   --请选择--"
														listKey="dict_id" listValue="dict_item_name"
														theme="simple"
													/>
													&nbsp;&nbsp;
													</td>
													
													<td>联系人：</td>
													<td>
													<s:textfield
														id="sale_linkman"
														cssClass="textbox"
														style="WIDTH: 80px"
														maxLength="50"
														name="sale_linkman"
														theme="simple"
													/>
									
													&nbsp;&nbsp;
													</td>
													
													
													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
													<TD><INPUT class=button id=sButton3 type=button onclick="clean()"
														value="清空 " name=sButton3> </TD>
													<td width="150px"></td>
													<TD><INPUT class=button id=sButton4 type=button onclick="addUI()"
														value="新增" name=sButton4> </TD>
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
													<!--  <TD>编号</TD>-->
													<TD>客户名称</TD>
													<TD>概述</TD>
													<TD>机会来源</TD>
													<TD>机会描述</TD>
													<TD>联系人</TD>
													<TD>联系人电话</TD>
													<TD>创建时间</TD>
													<TD>操作</TD>
												</TR>
												<s:iterator value="list" var="i">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<!-- <TD><s:property value="#i.sale_id" /></TD> -->
													
													<TD><s:property value="#i.sale_name"  /></TD>
													<TD><s:property value="#i.sale_comm"  /></TD>
													<TD><s:property value="#i.baseDictSource.dict_item_name"/></TD>
													<TD><s:property value="#i.baseDictChanceComm.dict_item_name" /></TD>
													<TD><s:property value="#i.sale_linkman"  /></TD>
													<TD><s:property value="#i.sale_linkphone"  /></TD>
													<TD><s:property value="#i.sale_date"  /></TD>
													<TD>
													<a href="${pageContext.request.contextPath }/saleChance_editUI.action?sale_id=<s:property value="#i.sale_id" />">修改</a>
													
													<a onclick="del(${i.sale_id})" >删除</a>
													<s:if test="#session.loginUser.baseDictPermission.dict_id == 3">
														<a href="${pageContext.request.contextPath }/saleChance_appointUI.action?sale_id=<s:property value="#i.sale_id"/>">指派</a>
													</s:if>
													</TD>
												</TR>
												</s:iterator>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD align="right"><SPAN id=pagelink>
											<!-- 分页信息 -->
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
