<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE> 
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
	function back(){
		window.location.href="${pageContext.request.contextPath }/customer_findByPage.action";
	}
	
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<s:form id="customerForm" name="customerForm" 
	action="linkMan_findByPage.action" namespace="/" method="post" theme="simple">
	
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
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TBODY>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">联系人名称</TD>
													<TD bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">性别</TD>
													<TD bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">职位</TD>
													<TD bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">手机</TD>
													<TD bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">邮箱</TD>
													<TD bgcolor="#87CEFF" style="border: 1px solid #CDC5BF">QQ</TD>
					
												
													
												</TR>
												<s:iterator value="list" var="i">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD  bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF"><s:property value="#i.lkm_name"/></TD>
													<TD  bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF"><s:property value="#i.lkm_gender"/></TD>
													<TD  bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF"><s:property value="#i.lkm_position"/></TD>
													<TD  bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF"><s:property value="#i.lkm_mobile"/></TD>
													<TD  bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF"><s:property value="#i.lkm_email"/></TD>
													<TD  bgcolor="#F0F8FF" style="border: 1px solid #CDC5BF"><s:property value="#i.lkm_qq"/></TD>
													
												</TR>
												
												</s:iterator>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD align="right">
										<SPAN id=pagelink>
											<jsp:include page="/page.jsp"></jsp:include>
										</SPAN>
										<input type="button" onclick="back()" value="返回">
									</TD>
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
