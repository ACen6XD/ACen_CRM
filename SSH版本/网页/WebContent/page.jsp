<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<!-- 分页信息 -->
	一共[<s:property value="totalSize"/>]条记录,
	总共[<s:property value="totalPage"/>]页
	&nbsp;
	每页显示
	<select name="pageSize" onchange="to_page()">
		<option value="3" <s:if test="pageSize == 3">selected</s:if> >3</option>
		<option value="5" <s:if test="pageSize == 5">selected</s:if>>5</option>
		<option value="10" <s:if test="pageSize == 10">selected</s:if>>10</option>
	</select>
	条
	&nbsp;
	<s:if test="currPage != 1">
	<a href="javascript:to_page(<s:property value='1'/>)">首页</a>
	<a href="javascript:to_page(<s:property value='currPage-1'/>)">前一页</a>
	</s:if>
	
	<s:iterator begin="1" end="totalPage" var="i">
		<s:if test="#i != currPage">
			<a href="javascript:to_page(<s:property value='#i'/>)" /><s:property value='#i'/></a>
		</s:if>
		<s:else>
			<s:property value="#i"/>
		</s:else>
	</s:iterator>
	
	<s:if test="currPage != totalPage">
	<a href="javascript:to_page(<s:property value='currPage+1'/>)">后一页</a>
	<a href="javascript:to_page(<s:property value='totalPage'/>)" >末页</a>
	</s:if>
	
	&nbsp;&nbsp;
	到 
	<input type="text" id="page" name="currPage" size="3">
	 页
	&nbsp;<input type="button" onclick="to_page()" value="跳转">
</body>
</html>