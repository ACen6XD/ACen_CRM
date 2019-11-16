<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>销售机会详情查看</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function back(){
		window.location.href="${pageContext.request.contextPath }/salePlan_findByPage.action ";
	}
	function edit(){
		if(confirm("是否确认修改?")){
			return true;
		}
		return false;
	}
	function del(planId){
		if(confirm("是否确认删除?")){
			window.location.href="${pageContext.request.contextPath }/salePlan_delete.action?plan_id="+planId;
		}
	}
	function planSuccess(sale_id){
		if(confirm("是否修改状态为开发成功?")){
			window.location.href="${pageContext.request.contextPath }/salePlan_planSuccess.action?sale_id="+sale_id;	
		}
	}
	function planFail(sale_id){
		if(confirm("是否修改状态为开发失败?")){
			//alert(sale_id);
			window.location.href="${pageContext.request.contextPath }/salePlan_planFail.action?sale_id="+sale_id;
		}
	}
</script>
</HEAD>
<BODY>

	<s:form id="form1" name="form1" method="post" action="saleChance_edit.action" namespace="/" theme="simple" onsubmit="return edit()">	

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
								<TD class=manageHead>当前位置：客户开发计划管理 &gt; 客户开发计划查看</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=1 cellPadding=5  style="border: 1px solid #CDC5BF">
						  
						    
							<TR>
								<s:hidden name="sale_id"/>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">客户名称：</td>
								<td bgcolor="#F0F8FF" width="150px" style="border: 1px solid #CDC5BF">
								
								<s:label name="saleChance.sale_name" style="WIDTH: 180px"></s:label>
								</td>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">成功机率(%)：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
								
								<s:label style="WIDTH: 180px" name="saleChance.sale_rate"></s:label>
								</td>
							</TR>
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">概要:</td>
								<td colspan="3"  bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									
									<s:label style="WIDTH: 180px" name="saleChance.sale_comm"></s:label>
								</td>
							</tr>
							
							<TR>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">机会来源 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
								
									<s:label style="WIDTH: 180px" name="saleChance.baseDictSource.dict_item_name"></s:label>
								</td>
								
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">机会描述：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
								
								<s:label style="WIDTH: 180px" name="saleChance.baseDictChanceComm.dict_item_name"></s:label>
								</td>
							</TR>
							
							<TR>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">联系人 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
								<s:label style="WIDTH: 180px" name="saleChance.sale_linkman"></s:label>
								</td>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">联系人电话 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
								<s:label style="WIDTH: 180px" name="saleChance.sale_linkphone" ></s:label>
								</td>
							</TR>
							
							<TR>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">创建人 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
								<s:label style="WIDTH: 200px" name="saleChance.sale_buildman.user_realname"></s:label>
								</td>

								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF"> 创建时间 ：</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
								<s:label style="WIDTH: 180px" name="saleChance.sale_date"></s:label>
								</td>

							</TR>
							
							<tr>
								<td height="15px" colspan="4" style="border: 1px solid #CDC5BF">
								</td>
							</tr>
							
							<tr>
								<td style="border: 1px solid #CDC5BF" bgcolor="#6CA6CD" align="center">日期</td>
								<td style="border: 1px solid #CDC5BF" bgcolor="#6CA6CD" align="center">计划项</td>
								<td style="border: 1px solid #CDC5BF" bgcolor="#6CA6CD" align="center">结果</td>
							
								<td style="border: 1px solid #CDC5BF" bgcolor="#6CA6CD" align="center">操作</td>
								
							</tr>
							
							
								<s:iterator value="salePlan" var="i">
									<tr>
									<td  bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF"><s:property value="#i.plan_date"/></td>
									<td  bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF"><s:property value="#i.plan_message"/></td>
									<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF"><s:property value="#i.plan_result"/></td>
									<td  bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:if test="saleChance.sale_status.equals('开发中')">
										<a href="${pageContext.request.contextPath }/salePlan_editUI.action?plan_id=${i.plan_id}">修改</a>
										&nbsp;
										<a onclick="del(${i.plan_id})">删除</a>
									</s:if>
									</td>
									</tr>
								</s:iterator>
							
							<tr>
								<td height="15px" colspan="4" style="border: 1px solid #CDC5BF">
								</td>
							</tr>
							
							<tr>
									<td  align="right">
									 <s:if test="saleChance.sale_status.equals('开发中')">
										<INPUT type="button" onclick="planSuccess(${saleChance.sale_id})" value=" 开发成功  "  >
									</s:if>
									</td>
									<td align="center">	
									<s:if test="saleChance.sale_status.equals('开发中')">				
										<INPUT type="button" onclick="planFail(${saleChance.sale_id})" value=" 开发失败 "  >
									</s:if>
									</td>
								<td colspan="3" align="center">
								<input type="button" onclick="back()" value="  返回  " >
								
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
