<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%> <!-- 获取系统时间必须导入的 -->
<%@ page import="java.text.*"%>  <!-- 获取系统时间必须导入的 -->
<% 
String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间 
%>
<html>
  <head>
    <title>top页面</title>
    <style>
    	html{
    		height:120px;
    	}
    	body{
    		background-image:url(../img/topbg.gif);
    		background-size:contain;
    		width:auto;
    		height:120px;
    	}
    	a{
    		color:#fff;
    		text-decoration:none;
    	}
     	div.child{
     		float:left;
     	}
     	.one{
     		margin-left:500px;
     		margin-top:20px;
     	}
     	.two{
     		margin-left:70px;
     		margin-top:20px;
     	}
     	.three{
     		margin-left:140px;
     		margin-top:50px;
     	}
     	.four{
     		margin-left:200px;
     		margin-top:50px;
     	}
     	.four>input{
     		background:url(../img/topbg.gif) 50% center;
     		border:0;
     	}
    </style>
    <script type="text/javascript">
	function disptime(){
		var now = new Date();//创建日期对象
		var sWeek=new Array("日","一","二","三","四","五","六");
  		var yy = now.getFullYear();//年
  		var mm = now.getMonth()+1;//月
  		var day = now.getDate();//日 
  		var sDay=sWeek[now.getDay()];//星期
  		var hh = now.getHours();//小时
  		var minu = now.getMinutes();//分钟
  		var ss = now.getSeconds();//秒
                //判断分和秒 如是各位数 前面加个0 例如11:23:07
  		if(minu<=9){
    		minu ='0'+minu;
  		}
  		if(ss<=9){ss = '0'+ss;}
			document.getElementById("time").value=yy+'年:'+mm+'月:'+day+'日:'+'星期'+sDay+','+hh+'点:'+minu+'分:'+ss+'秒';
			var myTime=setTimeout("disptime()",1000);
		} 
</script>
  </head>
  <body onload="disptime()">
  	<div>
  		<div class="child">
  			<img src="../img/top_logo.gif" height="100" width="500">
  		</div>
  		<div>
  		<div class="child one">
  				<a href="#">
  					<img src="../img/top_home.gif"/>
  					网站首页</a>
  			</div>
  			<div class="child two">
  				<a href="../login" target="_top">
  					<img src="../img/top_exit.gif"/>
  					注销退出</a>
  			</div>
  			<div class="child three">
  				<img src="../img/StatBar_admin.gif"/>
  					当前用户：
  					【${sessionScope.user.loginname}】
  			</div>
  			<div class="child four">
  					<img src="../img/StatBar_time.gif"/>
  					<!-- <%=datetime%>  -->
  					<input type="text" size="40" id="time"/>
  			</div>
  		</div>
  	</div>
  </body>
</html>
