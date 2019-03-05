<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>job_select页面</title>
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
			<img src="../img/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：<a href="../main/bottom">后台管理</a>  &gt; 职位查询</td>
	</tr>
</table>

<form action="selectJob" method="post">
 	<table border="0" align="center" style="margin-top:20px;">
        <tr>
         	<td>职位名称: </td>
            <td><input type="text"  name="name" ></td>
         	<td>详细信息:</td>
            <td><input type="text"  name="remark" ></td>
            <td><input type="submit" value="查询"></td>
         </tr>
	</table>
</form>
    <table class="tbcss" width="600" border="1" align="center">
    <tr>
    	<td align="center">职位名称</td>
    	<td align="center">详细信息</td>
    	<td colspan="2" align="center">操作</td>
    </tr>
    <c:forEach items="${requestScope.jobList}" var="job">
    	<tr>
    		<td align="center">${job.name}</td>
    		<td align="center">${job.remark}</td>
    		<td align="center"><a href="../updateJob?id=${job.id}">修改</a></td>
    		<td align="center"><a href="../deleteJob?id=${job.id}">删除</a></td>
    	</tr>
    </c:forEach>
	</table>
	<table class="tbcss" align="center">
		<tr>
			<c:if test="${requestScope.page.hasPre}">
				<td>
					<a href="selectJob2?pageNow=1">  首页  </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasPre}">
				<td>
					<a href="selectJob2?pageNow=${requestScope.page.pageNow-1}">  上一页   </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasNext}">
				<td>
					<a href="selectJob2?pageNow=${requestScope.page.pageNow+1}">  下一页   </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasNext}">
				<td>
					<a href="selectJob2?pageNow=${requestScope.page.totalPage}">  尾页  </a>
				</td>
			</c:if>
			<td>
				共${requestScope.page.totalPage}页，第${requestScope.page.pageNow}页
			</td>
		</tr>
	</table>
  </body>
</html>
