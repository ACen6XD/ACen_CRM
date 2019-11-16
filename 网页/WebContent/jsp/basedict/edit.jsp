﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>修改数据字典</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function back(){
		if(confirm("是否要返回?一旦确认,输入的信息将在下次重新填写")){
			window.location.href="${pageContext.request.contextPath }/baseDict_findByPage.action ";
		}
	}
	function edit(){
		if(confirm("是否确认修改该数据?")){
			return true;
		}
		return false;
	}

</script>
</HEAD>
<BODY>
	<s:form name="form1" action="baseDict_edit.action" namespace="/"  method="post" theme="simple" onsubmit="return edit()">
	

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
								<TD class=manageHead>当前位置：数据字典管理 &gt; 修改数据</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<s:actionerror/>
							<s:hidden name="dict_id"></s:hidden>
							<s:hidden name="dict_type_code"></s:hidden>
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">数据字典类别名称:</td>
								<td colspan="3" bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:textfield name="dict_type_name" readonly="true"></s:textfield>
								</td>
							</tr>
							
							<TR>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">数据字典项目名称：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
								<s:textfield cssClass="textbox" style="WIDTH: 180px" maxLength="50" name="dict_item_name"/>
							</TR>
							
							
							
							<tr>
								<td  align="center" >
								<INPUT class=button id=sButton2 type="submit"
														value="  保存   " name=sButton2>
								</td>
								<td   align="center">
								<INPUT class=button id=sButton2 onclick="back()" type="button"
														value="  返回   " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
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
