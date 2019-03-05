<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>notice_update页面</title>
	<style>
		body{
			margin:3px;
			border:1px solid #73A2E2;
			background-color:#CCD5FF;
		}
		.content{
			width:200px;
			height:200px;
		}
	</style>
</head>
<body>

<table width="99%" border="0" cellpadding="0" cellspacing="0">
	<tr><td height="10"></td></tr>
	<tr style="background:url(../img/main_locbg.gif) repeat-x; height:30px;">
		<td height="32">&nbsp;&nbsp;&nbsp;
			<img src="img/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：<a href="main/bottom">后台管理</a>  &gt;
			<a href="main/selectNotice2">公告管理</a>  &gt; 修改公告</td>
	</tr>
</table>

<form action="updateNoticeView" method="post">
<table width="30%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr  height="30">
		<td colspan="2"><input type="hidden" name="id" value="${notice.id}"></td>
	</tr>
	<tr height="30">
		<td width="30%">公告标题：</td>
		<td><input type="text" name="title" value="${notice.title}"></td>
	</tr>
	<tr height="30">
		<td colspan="2">公告内容：</td>
	</tr>
	<tr>
		<td colspan="2"><input class="content" type="text" name="content" value="${notice.content}"></td>
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