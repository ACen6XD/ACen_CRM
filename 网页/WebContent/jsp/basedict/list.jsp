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
		$("#dict_item_name").val("");
		$("#dict_type_name option[value='"+''+"']").prop("selected","selected");
		document.customerForm.submit();
	}
	function del(data){
		//alert(data);
		if(confirm("是否确认删除该数据?(提示：数据字典删除后其关联的所有数据都会被删除,请确认操作！")){
			window.location.href="${pageContext.request.contextPath }/baseDict_delete.action?dict_id="+data;
		}
	}
	function add(){
		window.location.href="${pageContext.request.contextPath }/baseDict_addUI.action";
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
	<s:form id="customerForm" name="customerForm" method="post" namespace="/" action="baseDict_findByPage.action" theme="simple">
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
								<TD class=manageHead>当前位置：数据字典管理 &gt; 数据字典列表</TD>
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
													<TD>类别名称:</TD>
													<TD>
														<s:select
															id="dict_type_name" 
															list="listTypeName"
															name="dict_type_name"
															
															headerKey=""
															headerValue="--请选择--"
														/>
														&nbsp;
													</TD>
												
													<td>项目名称 :</td>
													<td>
														<s:textfield
															name="dict_item_name"
															id="dict_item_name"
														/>
														&nbsp;
													</td>
											
													
													<TD><INPUT  id=sButton2 type=submit
														value=" 筛选 " name=sButton2>
														&nbsp;
													</TD>
													<TD><INPUT id=sButton3 type=button onclick="clean()"
														value=" 清空 " name=sButton3>
														
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<input type="button" value="  新增数据  " onclick="add()">
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
													<TD>类别名称</TD>
													<td>项目名称</td>
													<TD>操作</TD>
												</TR>
												<s:iterator value="list" var="i">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD><s:property value="#i.dict_type_name" /></TD>
													<td><s:property value="#i.dict_item_name" /></td>
												
													
													<TD>
													<a href="${pageContext.request.contextPath }/baseDict_editUI.action?dict_id=<s:property value="#i.dict_id" />">修改</a>
													&nbsp;
													
													<a  onclick="del('${i.dict_id}')">删除</a>
													
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
