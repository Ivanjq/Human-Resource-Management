<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>left页面</title>
	<style type="text/css"> 
		.font1 { color:#1f324d; font-size:14px; font-weight:bold; text-indent:4.5em; margin-top:1px;padding:5px;}
		.font1:hover{cursor:pointer;}
		.font2 { font-size:14px; text-indent:3.6em;padding:4px;}
		body{
			margin:3px;
			border:1px solid #73A2E2;
			background:url(../img/back-left.jpg) no-repeat;
		}
		.openBox{
			background:url(../img/left_nav_closed.gif) no-repeat; 
			width:200px;
			height:28px;
		}
		a{
			text-decoration:none;	
		}
		a:hover{
			color:#CF5762;
		}
	</style>
	<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">
</script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".divBox").hide();
  			$(".openBox").click(function(){
    			$(".divBox:eq("+$(this).index(".openBox")+")").toggle();
  			});
		});
	</script>
</head>
<body>
<div style="padding:5px;text-align:left;">
		<div class="openBox">
		  		<p class="font1">用户管理</p>
		</div>
		<div class="divBox">
			<div class="font2">
			  	<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  	<a href="selectUser" target="main">用户查询</a>
			</div>
		</div>
		<div class="openBox">
		   		<p class="font1">公告管理</p>
		</div>
		<div class="divBox">
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="selectNotice" target="main">公告查询</a>
			</div>
		</div>
		<div class="openBox">
		   		<div class="font1">下载中心</div>
		</div>
		<div class="divBox">
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="selectDocument" target="main">文档查询</a>
			</div>
		</div>
		<div class="openBox">
		   		<div class="font1">本月工资</div>
		</div>
		<div class="divBox">
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="selectSalary" target="main">查看工资</a>
			</div>
		</div>
		<div class="openBox">
		   		<div class="font1">信息反馈</div>
		</div>
		<div class="divBox">
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="../problem/addproblem" target="main">添加反馈</a>
			</div>
		</div>
		<div>
			<p style="margin-left:30px;font-weight:bold;font-size:14px;">技术支持：</p>
			<p style="margin-left:30px;font-weight:bold;font-size:14px;">广东为学教育有限公司</p>
			<p style="margin-left:30px;font-size:12px;">
				<a href="http://www.fkjava.org" target="main">http://www.fkjava.org</a>
			</p>
		</div>
	</div>
</body>
</html>