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
			background-color:#CCD5FF;
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
			  	<a href="selectUser2" target="main">用户查询</a>
			</div>
			<div class="font2">
			 	<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  	<a href="../user/user_add" target="main">添加用户</a>
			</div>
		</div>
		<div class="openBox">
		   		<p class="font1">部门管理</p>
		</div>
		<div class="divBox">
			<div class="font2">
			  	<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  	<a href="selectDept2" target="main">部门查询</a>
			</div>
			<div class="font2">
			  	<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  	<a href="../dept/dept_add" target="main">添加部门</a>
			</div>
		</div>
		<div class="openBox">
		   		<p class="font1">职位管理</p>
		</div>
		<div class="divBox">
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="selectJob2" target="main">职位查询</a>
			</div>
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="../job/job_add" target="main">添加职位</a>
			</div>
		</div>
		<div class="openBox">
		   		<p class="font1">员工管理</p>
		</div>
		<div class="divBox">
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="selectEmployee2" target="main">员工查询</a>
			</div>
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="insertEmployeeView" target="main">添加员工</a>
			</div>
		</div>
		<div class="openBox">
		   		<p class="font1">公告管理</p>
		</div>
		<div class="divBox">
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="selectNotice2" target="main">公告查询</a>
			</div>
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="../notice/notice_add" target="main">添加公告</a>
			</div>
		</div>
		<div class="openBox">
		   		<div class="font1">下载中心</div>
		</div>
		<div class="divBox">
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="selectDocument2" target="main">文档查询</a>
			</div>
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="../document/document_add" target="main">上传文档</a>
			</div>
		</div>
		<div class="openBox">
		   		<div class="font1">本月工资</div>
		</div>
		<div class="divBox">
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="selectSalary2" target="main">查看工资</a>
			</div>
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="insertSalaryView" target="main">添加工资</a>
			</div>
		</div>
		<div class="openBox">
		   		<div class="font1">本月反馈</div>
		</div>
		<div class="divBox">
			<div class="font2">
			  		<img src="../img/left_nav_arrow.gif"/>&nbsp;&nbsp;
			  		<a href="selectProblem2" target="main">查看反馈</a>
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