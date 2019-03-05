<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>salary_update页面</title>
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
			<a href="main/selectSalary2">工资管理</a>  &gt; 修改工资</td>
	</tr>
</table>

<form action="updateSalaryView" method="post">
<table width="30%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr  height="30">
		<td colspan="2"><input type="hidden" name="id" value="${salary.id}"></td>
	</tr>
	<tr height="30">
		<td>职位：</td>
		<td>
			<select name="job_id">
				<option value="">--职位选择--</option>
				<c:forEach items="${requestScope.jobList}" var="job">
					<option value="${job.id}" <c:if test="${job.id==requestScope.salary.job.id}">selected="selected"</c:if>>${job.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr height="30">
		<td>部门：</td>
		<td>
			<select name="dept_id" value="${requestScope.salary.dept.id}">
				<option value="">--部门选择--</option>
				<c:forEach items="${requestScope.deptList}" var="dept">
					<option value="${dept.id}" <c:if test="${dept.id==requestScope.salary.dept.id}">selected="selected"</c:if>>${dept.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr height="30">
		<td>工资：</td>
		<td><input type="text" name="salary" value="${salary.salary}"></td>
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