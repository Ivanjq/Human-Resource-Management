<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>job_add页面</title>
	<style>
		body{
			margin:3px;
			border:1px solid #73A2E2;
			background-color:#CCD5FF;
		}	
	</style>
</head>
<body>

<table width="99%" border="0" cellpadding="0" cellspacing="0">
	<tr><td height="10"></td></tr>
	<tr style="background:url(../img/main_locbg.gif) repeat-x; height:30px;">
		<td height="32">&nbsp;&nbsp;&nbsp;
			<img src="../img/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：<a href="../main/bottom">后台管理</a>  &gt;
			<a href="../main/selectJob2">职位查询</a> &gt; 添加职位</td>
	</tr>
</table>

<form action="insertJob" method="post">
<table width="30%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr  height="30">
		<td colspan="2"></td>
	</tr>
	<tr height="30">
		<td width="30%">职位名称：</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr height="30">
		<td>详细信息：</td>
		<td><input type="text" name="remark"></td>
	</tr>
	<tr>
		<td colspan="2">
		    <input type="submit" value="添加"/>&nbsp;&nbsp;&nbsp;
		    <input type="reset" value="取消"/>
		</td> 
	</tr>
</table>
</form>

</body>
</html>