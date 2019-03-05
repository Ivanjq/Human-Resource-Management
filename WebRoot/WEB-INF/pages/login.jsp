<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>人事管理系统————登录页面</title>
    <style>
          body{
			font:12px "microsoft yahei",Arial,sans-serif;
			color:#666;
			margin:0;
			padding:0;
		}
		h1{
			margin-top:100px;
		}
	 /*文本框*/
		#container label{
			display:block;
			width:70px;
		}
		#container input.w270{
			float:left;
			box-sizing:border-box;
			width:270px;
			height:29px;
			border:1px solid #ccc;
			padding-left:20px;
			outline:0;
		}
		/*文本框背景图像 */
		#container input.txtUser{
			background:#fff url(img/user.png) no-repeat 2% center;
		}
		#container input.txtPass{
			background:#fff url(img/pwd.png) no-repeat 2% center;
		}
		#container input.w60{
			float:left;
			box-sizing:border-box;
			width:60px;
			height:29px;
			border:1px solid #FAFFBD;
			padding-left:1px;
			outline:0;
			background:#FAFFBD url(img/pointer.gif) no-repeat 100% center;
		}
		#container input.w60:hover{
			cursor:pointer;
		}
    </style>
  </head>
  <body background="img/background.jpg">
  	<h1 align="center">人事管理系统</h1>
  	<!--页面主体-->
	<form action="login" method="post">
  		<div id="container">
  			<table width="300" height="200" border="0" align="center">
         		<tr>
         			<td><label>登录名:</label></td>
             		<td><input type="text" class="w270 txtUser" name="loginname" ></td>
         		</tr>
        		<tr>
         			<td><label>密&nbsp;&nbsp;&nbsp;码: </label></td>
            		<td><input type="password" class="w270 txtPass"  name="password" ></td>
         		</tr>
         		<tr>
             		<td colspan="2">
             			<div style="margin-left:280px;"><input class="w60" type="submit" value="登录"></div>
             		</td>
         		</tr>
				<tr>
          			<td colspan="2" height="60" ><font color="red">${requestScope.msg}</font></td>
     			</tr>
			</table>
  		</div>
	</form>
  </body>
</html>
