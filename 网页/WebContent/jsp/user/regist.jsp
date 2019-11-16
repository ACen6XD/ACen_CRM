<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
BODY {
	FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
}
TD {
	FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
}
</STYLE>
<META content="MSHTML 6.00.6000.16809" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function regist(){
		var loginname = $("#txtName").val();
		if(loginname.length == 0){
			$("#namespan").html("请输入登陆账号！");
			return false;
		}
		var password = $("#txtPwd").val();
		if(password.length == 0){
			$("#passwordspan").html("请输入登陆密码！");
			return false;
		}
		var realname = $("#txtRealName").val();
		if(realname.length == 0){
			$("#usernamespan").html("请输入用户名！");
			return false;
		}
		var userphone = $("#txtPhone").val();
		if(userphone.length == 0){
			$("#userphonespan" ).html("请输入用户联系方式！");
			return false;
		}
		var userpermis = $("#userpermis").val();
		if(userpermis.length == 0){
			$("#permisspan").html("请选择权限！");
			return false;
		}
		return true;
	}
</script>
</HEAD>
<BODY>
<FORM id=form1 name=form1 action="${ pageContext.request.contextPath }/user_regist.action" method=post onsubmit="return regist()">

<DIV id=UpdatePanel1>
<DIV id=div1 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
<DIV id=div2 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>


<DIV>&nbsp;&nbsp; </DIV>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width=100% align=center border=1>
  <TBODY>
  <TR>
    <!--  <TD style="HEIGHT: 105px"><IMG src="${ pageContext.request.contextPath }/images/login_1.gif" 
  border=0></TD></TR>-->
  <TR>
    <TD background=${ pageContext.request.contextPath }/images/login_2.jpg height=300>
      <TABLE height=500 cellPadding=0 width=100% border=1>
        <TBODY>
 
    
          <TD align="center">
            <TABLE cellSpacing=0 cellPadding=2 border=0>
              <TBODY>
              <TR>
              	<s:actionerror/>
              	<s:property value="msg"/>
                <TD style="HEIGHT: 28px" width=80> 账号：</TD>
                <TD style="HEIGHT: 28px" width=150><INPUT id="txtName" 
                  style="WIDTH: 130px" name="user_loginname">
                  </TD>
              <TR>
              
              <tr height="18px">
              	<td width="80"></td>
              	<td><span id="namespan"></span></td>
              </tr>
              
                <TD style="HEIGHT: 28px">密码：</TD>
                <TD style="HEIGHT: 28px"><INPUT id="txtPwd" style="WIDTH: 130px" 
                  type=password name="user_password">
                  </TD>
         
              </TR>
             
              <tr height="18px">
              	<td width="80"></td>
              	<td><span id="passwordspan"></span></td>
              </tr>
             
             
              <TR>
                <TD style="HEIGHT: 28px" width=80>用户名 ：</TD>
                <TD style="HEIGHT: 28px" width=150><INPUT id="txtRealName" 
                  style="WIDTH: 130px" name="user_realname">
                  </TD>
            
              </TR>
              
              <tr height="18px">
              	<td width="80"></td>
              	<td><span id="usernamespan"></span></td>
              </tr>
              
              
       		<TR>
                <TD style="HEIGHT: 28px" width=80>联系方式 ：</TD>
                <TD style="HEIGHT: 28px" width=150><INPUT id="txtPhone" 
                  style="WIDTH: 130px" name="user_phone">
                  </TD>
            </TR>
              
              
              <tr height="18px">
              	<td width="80"></td>
              	<td><span id="userphonespan"></span></td>
              </tr>
              
              
              <TR>
                <TD style="HEIGHT: 28px" width=80>用户角色 ：</TD>
                <td>
                	<s:select 
                		id="userpermis"
                		name="baseDictPermission.dict_id"
                		list="permissionList"
                		headerKey=""
                		headerValue="--请选择--"
                		listKey="dict_id"
                		listValue="dict_item_name"
                		theme="simple"
                	/>
                </td>
              
              </TR>
       		
       		
       		<tr height="18px">
              	<td width="80"></td>
              	<td><span id="permisspan"></span></td>
              </tr>
       		
       		
              <TR>
                <TD></TD>
                <TD>
                <input type="submit" value="  注册  ">
             	</TD>
            </TR>
           </TBODY>
          </TABLE>
         </TD>
        </TR>
       </TBODY>
      </TABLE>
     </TD>
    </TR>
  <TR>
    <!--  <TD><IMG src="${ pageContext.request.contextPath }/images/login_3.jpg" 
border=0></TD></TR></TBODY></TABLE></DIV></DIV>
-->

</FORM></BODY></HTML>
