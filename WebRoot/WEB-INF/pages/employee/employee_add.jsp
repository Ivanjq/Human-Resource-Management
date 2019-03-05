<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>employee_add页面</title>
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
			<a href="../main/selectEmployee">员工管理</a>  &gt; 添加员工</td>
	</tr>
</table>

<form action="../employee/insertEmployee" method="post">
<table width="80%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr  height="30">
		<td colspan="2"></td>
	</tr>
	<tr height="30">
		<td>姓        名：</td>
		<td><input type="text" name="name"></td>
		<td>身份证号码：</td>
		<td><input type="text" name="cardId"></td>
	</tr>
	<tr height="30">
		<td>性        别：</td>
		<td>
			<select name="sex">
					<option value="0">--性别选择--</option>
					<option value="1">男</option>
					<option value="2">女</option>
			</select>
		</td>
		<td>职        位：</td>
		<td>
			<select name="job_id" value="${requestScope.employee.job.id}">
				<option value="">--职位选择--</option>
				<c:forEach items="${requestScope.jobList}" var="job">
					<option value="${job.id}" <c:if test="${job.id==requestScope.employee.job.id}">selected="selected"</c:if>>${job.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr height="30">
		<td>学       历：</td>
		<td><input type="text" name="education"></td>
		<td>邮       箱：</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr height="30">
		<td>手机号码：</td>
		<td><input type="text" name="phone"></td>
		<td>电话号码：</td>
		<td><input type="text" name="tel"></td>
	</tr>
	<tr height="30">
		<td>政治面貌：</td>
		<td><input type="text" name="party"></td>
		<td>QQ 号码：</td>
		<td><input type="text" name="qqNum"></td>
	</tr>
	<tr height="30">
		<td>联系地址：</td>
		<td><input type="text" name="address"></td>
		<td>邮政编码：</td>
		<td><input type="text" name="postCode"></td>
	</tr>
	<tr height="30">
		<td>出生日期：</td>
		<td><input type="text" name="birthday"></td>
		<td>民        族：</td>
		<td><input type="text" name="race"></td>
	</tr>
	<tr height="30">
		<td>所学专业：</td>
		<td><input type="text" name="speciality"></td>
		<td>爱        好：</td>
		<td><input type="text" name="hobby"></td>
	</tr>
	<tr height="30">
		<td>备        注：</td>
		<td><input type="text" name="remark"></td>
		<td>部门：</td>
		<td>
			<select name="dept_id" value="${requestScope.employee.dept.id}">
				<option value="">--部门选择--</option>
				<c:forEach items="${requestScope.deptList}" var="dept">
					<option value="${dept.id}" <c:if test="${dept.id==requestScope.employee.dept.id}">selected="selected"</c:if>>${dept.name}</option>
				</c:forEach>
			</select>
		</td>
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