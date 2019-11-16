<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>修改访问记录</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function back(){
			window.location.href="${pageContext.request.contextPath }/saleVist_findByPage.action ";
	}
	

</script>
	 <s:head theme="xhtml"/> 
    <sx:head parseContent="true"/>    
</HEAD>
<BODY>
	
	<s:form id="form1" action="saleVist_edit.action" namespace="/" method="post" onsubmit="return add()" theme="simple">

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
								<TD class=manageHead>当前位置：客户访问记录管理 &gt; 修改访问记录</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<s:hidden name="sv_id"/>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">访问客户 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:property value="sv_cust_id.cust_name"/>
									
								</td>
								
							</TR>
							
							<TR>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">访问时间 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
								<s:date name="sv_date" format="yyyy-MM-dd" />
								</td>
							</tr>
							
							<tr>	
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">访问地点 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:property value="sv_address"/>
								</td>
							</TR>
							
							<TR>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">访问概述 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:property value="sv_sketch"/>
								</td>
							</TR>
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">访问详情：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:textarea name="sv_comm" cols="15" rows="10" style="margin: 0px; width: 177px; height: 87px;" readonly="true"/>
								</td>
							</tr>
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">访问人 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
								${session.loginUser.user_realname}
								<s:hidden id="userid" name="sv_user_id.user_id" value="%{#session.loginUser.user_id}"/>
								</td>
							</tr>
							
							
							<tr>
								<td align="center" colspan="2" >
								<input type="button" value="  返回  " onclick="back()">
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
