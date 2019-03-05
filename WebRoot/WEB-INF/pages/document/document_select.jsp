<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>document_select页面</title>
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
			<img src="../img/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：<a href="../main/bottom">后台管理</a>  &gt; 文档查询</td>
	</tr>
</table>

<form action="selectDocument" method="post" style="margin-top:20px;">
 	<table border="0" align="center">
        <tr>
         	<td>标题: </td>
            <td><input type="text"  name="title" ></td>
            <td><input type="submit" value="查询"></td>
         </tr>
	</table>
</form>
    <table class="tbcss" width="600" border="1" align="center">
    <tr>
    	<td align="center">标题</td>
    	<td align="center">创建时间</td>
    	<td align="center">创建人</td>
    	<td align="center">描述</td>
    	<td colspan="2" align="center">操作</td>
    	<td align="center">下载</td>
    </tr>
    <c:forEach items="${requestScope.documentList}" var="document">
    	<tr>
    		<td align="center">${document.title}</td>
    		<td align="center">
    			<fmt:formatDate value="${document.createDate}" pattern="yyyy年MM月dd日"/>
    		</td>
    		<td align="center">${document.user.loginname}</td>
    		<td align="right">${document.remark}</td>
    		<td align="center"><a href="../updatedocument?id=${document.id}"">修改</a></td>
    		<td align="center"><a href="../deleteDocument?id=${document.id}">删除</a></td>
    		<td align="center"><a href="../download?filename=${document.filename}">下载</a></td>
    	</tr>
    </c:forEach>
	</table>
	<table class="tbcss" align="center">
		<tr>
			<c:if test="${requestScope.page.hasPre}">
				<td>
					<a href="selectDocument2?pageNow=1">  首页  </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasPre}">
				<td>
					<a href="selectDocument2?pageNow=${requestScope.page.pageNow-1}">  上一页   </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasNext}">
				<td>
					<a href="selectDocument2?pageNow=${requestScope.page.pageNow+1}">  下一页   </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasNext}">
				<td>
					<a href="selectDocument2?pageNow=${requestScope.page.totalPage}">  尾页  </a>
				</td>
			</c:if>
			<td>
				共${requestScope.page.totalPage}页，第${requestScope.page.pageNow}页
			</td>
		</tr>
	</table>
  </body>
</html>
