<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>select页面</title>
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
			<img src="../img/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：<a href="../main/bottom">后台管理</a>  &gt; 反馈查询</td>
	</tr>
</table>

<form action="selectProblem" method="post">
 	<table border="0" align="center" style="margin-top:20px;">
        <tr>
         	<td>反馈标题: </td>
            <td><input type="text"  name="title" ></td>
         	<td>反馈内容:</td>
            <td><input type="text"  name="content" ></td>
            <td><input type="submit" value="查询"></td>
         </tr>
	</table>
</form>
    <table class="tbcss" width="800" border="1" align="center">
    <tr>
    	<td align="center">反馈标题</td>
    	<td align="center">反馈内容</td>
    	<td align="center">创建时间</td>
    	<td align="center">公告人</td>
    	<td align="center">预览</td>
    	<td colspan="2" align="center">操作</td>
    </tr>
    <c:forEach items="${requestScope.problemList}" var="problem">
    	<tr>
    		<td align="center"><div id="title${problem.id}">${problem.title}</div></td>
    		<td align="center"><div id="content${problem.id}">${problem.content}</div></td>
    		<td align="center">
    			<div id="createDate${problem.id}"><fmt:formatDate value="${problem.createDate}" pattern="yyyy年MM月dd日"/></div>
    		</td>
    		<td align="center"><div id="user.username${problem.id}">${problem.user.username}</div></td>
    		<td align="center">
    			<button class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModal" onclick="display(${problem.id})">预览</button><!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="myModalLabel">
									<p class="p_title">反馈标题：</p><div id="title"></div></br>
									<p class="p_user">公告人：</p><div class="user" id="user.username"></div>
								</h4>
							</div>
							<div class="modal-body">
								<input type="hidden" id="id" name="id" value=""/>
								<p class="p_content">反馈内容：</p><div id="content"></div></br>
								<p class="p_createDate">发布时间：</p><div id="createDate"></div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal -->
				</div>
    		</td>
    		<td align="center"><a href="../deleteProblem?id=${problem.id}">删除</a></td>
    	</tr>
    </c:forEach>
	</table>
	<table class="tbcss" align="center">
		<tr>
			<c:if test="${requestScope.page.hasPre}">
				<td>
					<a href="selectProblem2?pageNow=1">  首页  </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasPre}">
				<td>
					<a href="selectProblem2?pageNow=${requestScope.page.pageNow-1}">  上一页   </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasNext}">
			<td>
					<a href="selectProblem2?pageNow=${requestScope.page.pageNow+1}">  下一页   </a>
				</td>
			</c:if>
			<c:if test="${requestScope.page.hasNext}">
				<td>
					<a href="selectProblem2?pageNow=${requestScope.page.totalPage}">  尾页  </a>
				</td>
			</c:if>
			<td>
				共${requestScope.page.totalPage}页，第${requestScope.page.pageNow}页
			</td>
		</tr>
	</table>
  </body>
</html>
