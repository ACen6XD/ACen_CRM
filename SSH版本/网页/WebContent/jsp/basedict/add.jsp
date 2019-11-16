<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>数据字典添加</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function back(){
		window.location.href="${pageContext.request.contextPath }/baseDict_findByPage.action ";
	}
	function add(){
		if(confirm("是否确认添加?")){
			return true;
		}
		return false;
	}
	function setVal(){
		//alert($("#dictTypeName").val());
		var data = $("#dictTypeName").val();
		$("#dict_type_name").val(data);
	}
</script>
</HEAD>
<BODY>

	<s:form id="form1" name="form1" method="post" action="baseDict_add.action"  namespace="/" theme="simple" onsubmit="return add()">	

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
								<TD class=manageHead>当前位置：数据字典管理 &gt; 添加数据记录</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
				
							<s:actionerror/>	    

							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">数据字典类别名称:</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:select 
									id="dictTypeName"
									onchange="setVal()"
									list="listTypeName"
									headerKey=""
									headerValue="--请选择--"
									/>
									<s:hidden id="dict_type_name" name="dict_type_name"></s:hidden>
								</td>
							</tr>
							
							<tr>
								<td bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">数据字典项目名称:</td>
								<td bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF">
									<s:textfield name="dict_item_name"/>
								</td>
							</tr>
							
		
							
							
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 添加 " name=sButton2>
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
