<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>bottom页面</title>
	<style>
		body{
			margin:3px;
			border:1px solid #73A2E2;
			background-color:#CCD5FF;
		}	
	</style>
</head>
<body>
<div style="padding:5px;">
	<table width="99%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="10"></td>
		</tr>
		<tr>
			<td style="background:url(../img/main_locbg.gif) repeat-x; height:30px;">&nbsp;&nbsp;&nbsp;
			<img src="../img/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：后台管理  &gt; 当前用户</td>
		</tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="2" height="25"></td>
		</tr>
		<tr>
			<td width="5%"></td>
			<td height="50">用户姓名：${sessionScope.user.username}</td>
		</tr>
		<tr>
			<td width="5%"></td>
			<td height="50">用户状态：
				<c:choose>
					<c:when test="sessionScope.user.status==1">
						已审核
					</c:when>
					<c:otherwise>
						未审核
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td width="5%"></td>
			<td height="50">创建时间：
			<fmt:formatDate value="${sessionScope.user.createdate}" 
				pattern="yyyy年MM月dd日"/>
			</td>
		</tr>	
	</table>
</div>
</body>
</html>