<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>销售机会添加</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function back(sale_id){
		window.location.href="${pageContext.request.contextPath }/salePlan_checkUI.action?sale_id="+sale_id;
	}
	function add(){
		if(confirm("是否确认修改?")){
			return true;
		}
		return false;
	}
</script>
</HEAD>
<BODY>

	<s:form id="form1" name="form1" method="post" action="salePlan_edit.action"  namespace="/" theme="simple" onsubmit="return add()">	

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
								<TD class=manageHead>当前位置：开发记录管理 &gt; 修改开发记录</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  	<s:hidden name="plan_id"/>
						  	
							<s:actionerror/>	    
							<TR>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">当前客户名称:</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="sale_name"/>
								</td>
							</tr>
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">日期:</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:textfield name="plan_date" readonly="true"/>
								</td>
							</tr>
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">记录项:</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:textarea rows="3" cols="18" name="plan_message"/>
								</td>
							</tr>
							
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">结果:</td>
								<td colspan="3" bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:textfield name="plan_result" />
								</td>
							</tr>
							
							
							
							<tr>
								<td rowspan=2 align="center">
								<INPUT class=button id=sButton2 type=submit
														value=" 修改 " name=sButton2>
								</td>
								<td rowspan=2 align="center">
								<input type="button" onclick="back(${plan_salechance.sale_id})" value="  返回  " class="button">						
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
