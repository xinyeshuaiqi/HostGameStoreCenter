<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="/struts-tags" prefix="s" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Host Game Store Center</title>

<meta name="Keywords" content="游戏"> 
<meta name="description" content="热门游戏商城中心"> 

<link href='http://cdn.webfont.youziku.com/webfonts/nomal/112400/46671/5a425e94f629d91984d8e21a.css' rel='stylesheet' type='text/css' />
<link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/css/showImg.css" type="text/css" rel="stylesheet">

</head>
<body>
	
	<!--start top -->
	<div class="top">
		
		<div class="text">
		Host Game Store Center</div>
		
		<div class="menu">
		
				<table >
					<tr>					
						<td align="right">
							<img src="${pageContext.request.contextPath}/img/cart.gif"/>
							<a href="${pageContext.request.contextPath}/pages/cart.jsp">购物车</a>|						
							<a href="${pageContext.request.contextPath}/ProductAction_findAllByCondition.action">购物中心</a>|							
						    <a href="${pageContext.request.contextPath}/pages/login.jsp">用户登陆</a>|
						    <a href="${pageContext.request.contextPath}/pages/apply.jsp" >用户注册</a>|
						    <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
						</td>
					</tr>
					
				</table>
		</div>
			
	</div>	

	<!--end top -->
	
	<!-- image start -->
	<div class="user_callback">  
		<div class="user_pic" id="user_pic">   
			<span class="prev"></span>   <span class="next"></span>   
			<ul id="user_call">    
				<li class="user_pic1">
					<a href="#"> <img src="img/1.jpg" alt="1" width="248" height="285" /></a>
				</li>    
				<li class="user_pic2"> 
					<a href="#"> <img src="img/2.jpg" alt="2" width="247" height="285" /></a>
				</li>    
				<li class="user_pic3">
					<a href="#"> <img src="img/3.jpg" alt="3" width="248" height="285" /></a>
				</li>    
				<li class="user_pic4">
					<a href="#"> <img src="img/4.jpg" alt="4" width="247" height="285" /></a>
				</li>    
				<li class="user_pic5"> 
					<a href="#"> <img src="img/5.jpg" alt="5" width="247" height="285" /></a>
				</li>    
				<li class="user_pic6">
					<a href="#"> <img src="img/6.jpg" alt="6" width="247" height="285" /></a>
				</li>    
				<li class="user_pic7">
					<a href="#"> <img src="img/7.jpg" alt="7" width="247" height="285" /></a> 
				</li>    
				<li class="user_pic8">
					<a href="#"> <img src="img/8.jpg" alt="8" width="247" height="285" /></a>
				</li>   
			</ul>  
		</div>
	</div>
	<!-- image end -->
		
	
	<!--ECharts start  -->
	<!--  为 ECharts 准备一个具备大小（宽高）的 DOM  -->
    <div id="main" style="width: 100%;height:400px;"></div> 
    <!--ECharts end  -->
    
    <!--description start  -->
	<div id="description" style="font-size:26px; color: white ;width: 100%; background:rgb(64, 74, 89); font-family:'jdfkongyif386abb491b710';">
			<table style="width: 100%;">
				<tr>
					<td>服务遍及全国&nbsp;&nbsp;秒速发货</td>
					<td style="text-align: right"><img src="${pageContext.request.contextPath}/img/b.jpg" height="30px" style="margin-bottom: 10px">热门游戏基地</td>
				</tr>
			</table>				    	
   	</div>
	<!--description end  -->
    
    <!--bottom start  -->
    <div class="bottom" style="width: 100%; ">
		
		Copyright ©2017 Host Game Store Center  All Rights Reserved<br/>
		班级：15软件工程1班  &nbsp;&nbsp;    姓名：汪明鑫  &nbsp;&nbsp; 学号：1525161009<br/>
	</div> 
	<!--bottom end  -->

</body>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/showImg.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/1.js" ></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/indexShow.js" ></script> 
	
</html>