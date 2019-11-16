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
	function back(){
		window.location.href="${pageContext.request.contextPath }/saleChance_findByPage.action ";
	}
	function add(){
		if(confirm("是否确认添加?")){
			return true;
		}
		return false;
	}
</script>
</HEAD>
<BODY>

	<s:form id="form1" name="form1" method="post" action="saleChance_add.action" namespace="/" theme="simple" onsubmit="return add()">	

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
								<TD class=manageHead>当前位置：销售机会管理 &gt; 添加销售机会</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="sale_name">
								</td>
								<td>成功机率(%)：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="sale_rate">
								</td>
							</TR>
							
							<tr>
								<td>概要:</td>
								<td colspan="3">
									<INPUT class=textbox id=sChannel2
														style="WIDTH: 465px" maxLength=50 name="sale_comm">
								</td>
							</tr>
							
							<TR>
								<td>机会来源 ：</td>
								<td>
								<s:select name="baseDictSource.dict_id" list="sourceList" 
								headerKey="" headerValue="--请选择--" 
								listKey="dict_id" listValue="dict_item_name"/>
									
								</td>
								
								<td>机会描述：</td>
								<td>
								<s:select name="baseDictChanceComm.dict_id" list="chanceCommList"
								headerKey="" headerValue="--请选择--" 
								listKey="dict_id" listValue="dict_item_name"/>
								</td>
							</TR>
							
							<TR>
								<td>联系人 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="sale_linkman">
								</td>
								<td>联系人电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="sale_linkphone">
								</td>
							</TR>
							
							<TR>
								<td>创建人 ：</td>
								<td>
								<s:textfield readonly="true" name="sale_buildman.user_realname" style="WIDTH: 180px" maxLength="50"/>
								
								
								
								
								</td>
								<td> 创建时间 ：</td>
								<td>
								<s:textfield readonly="true" name="sale_date" style="WIDTH: 180px" maxLength="50"/>		

							</TR>
							
							
							
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
								<td rowspan=2>
								<input type="button" onclick="back()" value="  返回  " class="button">						
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
