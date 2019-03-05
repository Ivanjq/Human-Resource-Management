<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>user_update页面</title>
	<style>
		body{
			margin:3px;
			border:1px solid #73A2E2;
			background:url(img/back.jpg) no-repeat;
		}	
	</style>
</head>
<body>

<table width="99%" border="0" cellpadding="0" cellspacing="0">
	<tr><td height="10"></td></tr>
	<tr style="background:url(../img/main_locbg.gif) repeat-x; height:30px;">
		<td height="32">&nbsp;&nbsp;&nbsp;
			<img src="img/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：<a href="main/bottom">后台管理</a>  &gt;
			<a href="main/selectUser">用户管理</a>  &gt; 修改用户</td>
	</tr>
</table>

<form action="main/updateUserView" method="post">
<table width="30%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr  height="30">
		<td colspan="2"><input type="hidden" name="id" value="${user.id}"></td>
	</tr>
	<tr height="30">
		<td width="20%">姓名：</td>
		<td><input type="text" name="username" value="${user.username}"></td>
	</tr>
	<tr height="30">
		<td>状态：</td>
		<td>
		    <select name=status value="${user.status}">
				<option value="1" <c:if test="${requestScope.user.status==1}">selected="selected"</c:if>>已审核</option>
				<option value="2" <c:if test="${requestScope.user.status==2}">selected="selected"</c:if>>未审核</option>
			</select>
		</td>
	</tr>
	<tr height="30">
		<td>登录名：</td>
		<td><input type="text" name="loginname" value="${user.loginname}"></td>
	</tr>
	<tr height="30">
		<td>密码：</td>
		<td><input type="text" name="password" value="${user.password}"></td>
	</tr>
	<tr>
		<td colspan="2">
		    <input type="submit" value="修改"/>&nbsp;&nbsp;&nbsp;
		    <input type="reset" value="取消"/>
		</td> 
	</tr>
</table>
</form>

</body>
</html>