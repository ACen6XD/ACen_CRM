<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function back(){
		window.location.href="${pageContext.request.contextPath }/customer_findByPage.action ";
	}

</script>
</HEAD>
<BODY>	
		<s:form id="form1" name="form1" action="customer_edit.action" namespace="/" method="post" theme="simple" onsubmit="return add()">
		
		
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
							<s:hidden name="cust_id" />
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 查看客户详细信息</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						<TR>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">客户名称 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_name"/>
								</td>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">客户来源 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_source.dict_item_name"/>

								</td>
							</TR>
							
							<TR>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">所属行业 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_indursty.dict_item_name"/>
								
								</td>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">客户级别 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_level.dict_item_name"/>
				
									
								</td>
								
							</TR>
								
							
							<TR>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">公司电话 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_phone"/>
								</td>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">公司邮箱 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_mail"/>
								</td>
								
							</TR>
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">公司地区:</td>
								<td colspan="3" bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_area.dict_item_name"/>
									
								</td>
							</tr>
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF" >公司地址 ：</td>
								<td colspan="3" bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_address"/>

								</td>
							</tr>
							
							
							
							
							<tr>
								<td height="10px" colspan="4" style="border: 1px solid #CDC5BF">
								</td>
							</tr>
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">营业执照注册号 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_code"/>
									</td>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">法人 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_registman"/>
									</td>
							</tr>
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">注册资金 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_money"/>
									</td>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">年营业额 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_yearmoney"/>
									</td>
							</tr>
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">开户银行 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_bank"/>
									</td>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">银行账号 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_bankid"/>
									</td>
							</tr>
							
							<tr>
								<td height="10px" colspan="4" style="border: 1px solid #CDC5BF">
								</td>
							</tr>
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">公司备注 ：</td>
								<td colspan="3" bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:textarea rows="7" cols="70" name="cust_comm" style="margin: 0px; width: 470px; height: 102px;" readonly="true" />
								</td>
							</tr>
							
							<tr>
								<td height="10px" colspan="4" style="border: 1px solid #CDC5BF">
								</td>
							</tr>
							
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">客户负责人 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_respman.user_realname" style="width:180px" maxLength="50" value="%{cust_respman.user_realname}"/>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">客户注册日期 ：</td>

								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:label name="cust_date"/>
								</td>

							</tr>
							
							
							<tr>
								<td height="7px" colspan="4" style="border: 1px solid #CDC5BF">
								</td>
							</tr>
							
							<tr>
								<td colspan="4" align="center"><input type="button" value="  返回  " onclick="back()"></td>
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
