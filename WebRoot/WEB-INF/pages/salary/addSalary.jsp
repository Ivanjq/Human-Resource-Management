<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title></title>
    <style>
		body{
			margin:3px;
			border:1px solid #73A2E2;
			background-color:#CCD5FF;
		}
		.tbcss{
			margin-top:60px;
		}
		a{
			text-decoration:none;	
		}
		a:hover{
			color:#CF5762;
		}
	</style>
  </head>
  
  <body bgcolor="#FFC0CB"> 
   <table width="99%" border="0" cellpadding="0" cellspacing="0">
	<tr><td height="10"></td></tr>
	<tr style="background:url(../img/main_locbg.gif) repeat-x; height:30px;">
		<td height="32">&nbsp;&nbsp;&nbsp;
			<img src="../img/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：<a href="../main/bottom">后台管理</a>  &gt;
			<a href="../main/selectSalary2">工资管理</a>  &gt; 添加工资</td>
	</tr>
   </table>
   <form action="../salary/insertSalary" method="post">
   <table class="tbcss" cellspacing="0" cellpadding="0" width="60%" align="center">
		<tr height="30">
			<td>姓        名：</td>
			<td><input type="text" name="user.id"></td>
		</tr>
		<tr height="30">
			<td>职        位：</td>
			<td>
			<select name="job_id">
				<option value="">--职位选择--</option>
				<c:forEach items="${requestScope.jobList}" var="job">
					<option value="${job.id}" <c:if test="${job.id==requestScope.employee.job.id}">selected="selected"</c:if>>${job.name}</option>
				</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td>部门：</td>
			<td>
			<select name="dept_id">
				<option value="">--部门选择--</option>
				<c:forEach items="${requestScope.deptList}" var="dept">
					<option value="${dept.id}" <c:if test="${dept.id==requestScope.employee.dept.id}">selected="selected"</c:if>>${dept.name}</option>
				</c:forEach>
			</select>
			</td>
		</tr>
		<tr height="30">
			<td>工        资：</td>
			<td><input type="text" name="salary"></td>
		</tr>
   		<tr>
   			<td align="center">
   		 		<input type="submit" value="确 定" size="12">
			</td>
			<td>
   		 		<input type="reset" value="清 除" size="12">
   		 	</td>
   		</tr>
   	</table>
   </form>
  </body>
</html>
