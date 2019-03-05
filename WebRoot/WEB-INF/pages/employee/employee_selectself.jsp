<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>employee_select页面</title>
	<style>
		body{
			margin:3px;
			border:1px solid #73A2E2;
			background-color:#CCD5FF;
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
			<img src="../img/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：<a href="../main/bottom">后台管理</a>  &gt; 员工查询</td>
	</tr>
</table>
    <table class="tbcss" width="1000" border="1" align="center">
    <tr>
    	<td align="center">姓名</td>
    	<td align="center">性别</td>
    	<td align="center">手机号码</td>
    	<td align="center">邮箱</td>
    	<td align="center">职位</td>
    	<td align="center">学历</td>
    	<td align="center">身份证号码</td>
    	<td align="center">部门</td>
    	<td align="center">联系地址</td>
    	<td align="center">建档日期</td>
    	<td colspan="2" align="center">操作</td>
    </tr>
    	<tr>
    		<td align="center">${employeeList.name}</td>
    		<td><c:if test="${employeeList.sex==1}">男</c:if>
    			<c:if test="${employeeList.sex==2}">女</c:if>
    		</td>
    		<td align="center">${employeeList.phone}</td>
    		<td align="center">${employeeList.email}</td>
    		<td align="center">${employeeList.job.name}</td>
    		<td align="center">${employeeList.education}</td>
    		<td align="center">${employeeList.cardId}</td>
    		<td align="center">${employeeList.dept.name}</td>
    		<td align="center">${employeeList.address}</td>
    		<td align="center">
    			<fmt:formatDate value="${employeeList.createDate}" pattern="yyyy年MM月dd日"/>
    		</td>
    		<td align="center"><a href="../updateEmployee?id=${employeeList.id}">修改</a></td>
    		<td align="center"><a href="../deleteEmployee?id=${employeeList.id}">删除</a></td>
    	</tr>
	</table>
	<table class="tbcss" align="center">
		<tr>
			<c:if test="${requestScope.page.hasPre}">
				<td>
					<a href="selectEmployee2?pageNow=1">  首页  </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasPre}">
				<td>
					<a href="selectEmployee2?pageNow=${requestScope.page.pageNow-1}">  上一页   </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasNext}">
				<td>
					<a href="selectEmployee2?pageNow=${requestScope.page.pageNow+1}">  下一页   </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasNext}">
				<td>
					<a href="selectEmployee2?pageNow=${requestScope.page.totalPage}">  尾页  </a>
				</td>
			</c:if>
			<td>
				共${requestScope.page.totalPage}页，第${requestScope.page.pageNow}页
			</td>
		</tr>
	</table>
  </body>
</html>
