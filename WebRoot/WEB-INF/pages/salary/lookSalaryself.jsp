<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>salary_select页面</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		.p_title{
			font-size:18px;
			color:#e4393c;
			font-weight:bold;
			display:inline-block;
		}
		#title{
			font-size:18px;
			color:#e4393c;
			font-weight:bold;
			display:inline-block;
		}
		.p_user{
			font-size:14px;
			color:#f08080;
			font-weight:bold;
			display:inline-block;
		}
		.user{
			font-size:14px;
			color:#f08080;
			font-weight:bold;
			display:inline-block;
		}
		.p_content{
			font-size:20px;
			margin-top:20px;
			font-weight:bold;
			display:inline-block;
		}
		#content{
			font-size:20px;
			margin-top:20px;
			font-weight:bold;
			display:inline-block;
		}
		.p_createDate{
			font-size:15px;
			margin-left:300px;
			margin-top:30px;
			color:#a0522d;
			display:inline-block;
		}
		#createDate{
			font-size:15px;
			color:#a0522d;
			display:inline-block;
		}
	</style>
	<script>
		function display(id){
			//alert(document.getElementById("title"+id).innerHTML);
			//alert(document.getElementById("content"+id).innerHTML);
			document.getElementById("title").innerHTML=document.getElementById("title"+id).innerHTML;
			document.getElementById("content").innerHTML=document.getElementById("content"+id).innerHTML;
			document.getElementById("user.username").innerHTML=document.getElementById("user.username"+id).innerHTML;
			document.getElementById("createDate").innerHTML=document.getElementById("createDate"+id).innerHTML;
		}
	</script>
  </head>
<body>
<table width="99%" border="0" cellpadding="0" cellspacing="0">
	<tr><td height="10"></td></tr>
	<tr style="background:url(../img/main_locbg.gif) repeat-x; height:30px;">
		<td height="32">&nbsp;&nbsp;&nbsp;
			<img src="../img/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：<a href="../main/bottom">后台管理</a>  &gt; 工资查询</td>
	</tr>
</table>

<form action="selectSalary2" method="post">
 	<table border="0" align="center" style="margin-top:20px;">
        <tr>
        	<td>所属部门: </td>
			<td>
				<select name="dept_id">
					<option value="">--部门选择--</option>
					<c:forEach items="${requestScope.deptList}" var="dept">
						<option value="${dept.id}">${dept.name}</option>
					</c:forEach>
				</select>
			</td>
         	<td>职位:</td>
            <td>
            	<select name="job_id">
					<option value="">--职位选择--</option>
					<c:forEach items="${requestScope.jobList}" var="job">
						<option value="${job.id}">${job.name}</option>
					</c:forEach>
				</select>
			</td>
			<td><input type="submit" value="查询"></td>
         </tr>
	</table>
</form>
    <table class="tbcss" width="800" border="1" align="center">
    <tr>
    	<td align="center">姓名</td>
    	<td align="center">部门</td>
    	<td align="center">职位</td>
    	<td align="center">工资</td>
    </tr>
    <c:forEach items="${requestScope.salaryList}" var="salary">
    	<tr>
    		<td align="center">${salary.user.username}</td>
    		<td align="center">${salary.dept.name}</td>
    		<td align="center">${salary.job.name}</td>
    		<td align="center">${salary.salary}</td>
    	</tr>
    </c:forEach>
	</table>
	<table class="tbcss" align="center">
		<tr>
			<c:if test="${requestScope.page.hasPre}">
				<td>
					<a href="selectSalary2?pageNow=1">  首页  </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasPre}">
				<td>
					<a href="selectSalary2?pageNow=${requestScope.page.pageNow-1}">  上一页   </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasNext}">
			<td>
					<a href="selectSalary2?pageNow=${requestScope.page.pageNow+1}">  下一页   </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasNext}">
				<td>
					<a href="selectSalary2?pageNow=${requestScope.page.totalPage}">  尾页  </a>
				</td>
			</c:if>
			<td>
				共${requestScope.page.totalPage}页，第${requestScope.page.pageNow}页
			</td>
		</tr>
	</table>
  </body>
</html>
