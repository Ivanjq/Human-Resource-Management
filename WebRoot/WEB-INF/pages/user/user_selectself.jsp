<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>user_select页面</title>
	<style>
		body{
			margin:3px;
			border:1px solid #73A2E2;
			background:url(../img/back.jpg) no-repeat;
		}
		.tbcss{
			border:1px dotted #ACC9F2;
			margin-top:50px;
			background-color:#E8F2FE;
		}
		.tbcss td{
			border:1px dotted #ACC9F2;
		}
		a{
			text-decoration:none;	
		}
		a:hover{
			color:#CF5762;
		}
	</style>
  </head>
<body>

<table width="99%" border="0" cellpadding="0" cellspacing="0">
	<tr><td height="10"></td></tr>
	<tr style="background:url(../img/main_locbg.gif) repeat-x; height:30px;">
		<td height="32">&nbsp;&nbsp;&nbsp;
			<img src="../img/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：<a href="../main/bottom">后台管理</a>  &gt; 查询用户</td>
	</tr>
</table>
    <table width="600" align="center" class="tbcss">
    <tr>
    	<td align="center">登录名</td>
    	<td align="center">密码</td>
    	<td align="center">用户名</td>
    	<td align="center">状态</td>
    	<td align="center">创建时间</td>
    	<td colspan="2" align="center">操作</td>
    </tr>
    <tr>
    	<td align="center">${sessionScope.user.loginname}</td>
    	<td align="center">${sessionScope.user.password}</td>
    	<td align="center">${sessionScope.user.username}</td>
    	<td align="center">${sessionScope.user.status}</td>
    	<td align="center">
    		<fmt:formatDate value="${sessionScope.user.createdate}" pattern="yyyy年MM月dd日"/>
    	</td>
    	<td align="center"><a href="../updateUser1?id=${sessionScope.user.id}">修改</a></td>
    </tr>
	</table>
  </body>
</html>
