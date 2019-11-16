<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
BODY {
	FONT-SIZE: 12px; COLOR: black; FONT-FAMILY: 宋体
}
TD {
	FONT-SIZE: 12px; COLOR: black; FONT-FAMILY: 宋体
}
</STYLE>

<META content="MSHTML 6.00.6000.16809" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
	function login(){
		var name = $("#txtName").val();
		if(name.length == 0){
			$("#namespan").html("请输入用户名！");
			return false;
		}
		var password = $("#txtPwd").val();
		if(password.length == 0){
			$("#passwordspan").html("请输入密码！");
			return false;
		}
		var permission = $("input:radio[name='baseDictPermission.dict_id']:checked").val();
		if(permission == null){
			$("#permissspan").html("请选择权限！");
			return false;
		}
		return true;
	}
</script>
</HEAD>
<BODY background="images/login_2.jpg">
<FORM id=form1 name=form1 action="${pageContext.request.contextPath}/user_login.action" 
method=post target="_parent" onsubmit="return login()">

<DIV id=UpdatePanel1>
<DIV id=div1 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
<DIV id=div2 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>


<DIV>&nbsp;&nbsp; </DIV>
<DIV >
<TABLE cellSpacing=0 cellPadding=0 width=700 align=center border=0  >
  <TBODY>
   <TR>
          <TD  height=40></TD></TR>
        <TR>
 	 <TR>
    <TD style="HEIGHT: 105px" align="center"><b><font size="26" face="verdana">客户关系管理系统登入</font></b></TR>
  <TR>
    <TD style="height:300px"  align="center"><!-- background:url(images/login_2.jpg) -->
      <TABLE height=300 cellPadding=0 width=500 border=0>
        <TBODY>
        <TR>
          <TD  height=35></TD></TR>
        <TR>
          <TD align="center" bgcolor="#EDEDED">
            <TABLE cellSpacing=0 cellPadding=2 border=0>
              <TBODY>
              <s:property value="msg"/>
              <TR>
              	<s:actionerror/>
                <TD style="HEIGHT: 28px" width=80>登 录 名：</TD>
                <TD style="HEIGHT: 28px" width=150 colspan="2">
	                <s:textfield id="txtName" name="user_loginname" 
	               style="WIDTH: 130px" theme="simple"
	                />
                </TD>
			 </TR>
			 <tr>
			 	<td style="HEIGHT: 28px" width=80></td>
                <td style="HEIGHT: 28px" ><span id="namespan"></span></td>
			 </tr> 
			  
        <TR>
              <TR>
                <TD style="HEIGHT: 28px">登录密码：</TD>
                <TD style="HEIGHT: 28px" colspan="2">
                <INPUT id="txtPwd" style="WIDTH: 130px" 
                  type=password name="user_password">
                  </TD>
              </TR>
              
               <tr>
			 	<td style="HEIGHT: 28px" width=80></td>
                <td style="HEIGHT: 28px" ><span id="passwordspan"></span></td>
			 </tr> 
              
              
        <TR>
			  <tr>
			  	<td colspan="3">
			  		<s:radio 
			  		id="txtPermis"
			  		list="#{'1':'高管','2':'客户经理','3':'销售主管'}"
			  		name="baseDictPermission.dict_id"
			  		theme="simple"
			  		/>
			  	</td>
			  </tr>

			    <tr>
			 	<td style="HEIGHT: 24px" width=80></td>
                <td style="HEIGHT: 24px" ><span id="permissspan"></span></td>
			 </tr> 
			   
        <TR>
               <tr>
                <TD colspan="3" align="center">
                	
                	<input type="submit" value="  登入  " align="left" />

               	</TD>
              </TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
<!-- <TD><IMG src="images/login_3.jpg" 
border=0></TD> -->

</TR></TBODY></TABLE></DIV></DIV>


</FORM></BODY></HTML>
