<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆账号</title>

<link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/form.css" type="text/css" rel="stylesheet">
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
						    <a href="${pageContext.request.contextPath}/pages/apply.jsp">用户注册</a>|
						    <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
						</td>
					</tr>
					
				</table>
		</div>
			
	</div>	

	<!--end top -->
	
	<div class="loginImage" style="margin: 100px 100px 50px 50px;float: left; ">
		<img  src="${pageContext.request.contextPath}/img/c.jpg">
	</div>
	
	<!-- form start -->
	
	<div class="container" style="margin-right: 200px; margin-top: 100px">  
	  <form id="contact" action="${pageContext.request.contextPath}/UserAction_login" method="post" >
	    <h3>用户登陆</h3>
	    <br/>
	    <br/>
	    <s:actionerror cssStyle="color:red; font-weight: bold;"/>
	   
	    <fieldset>
	      <input placeholder="用户名" type="text" name="username" tabindex="1" required autofocus>
	    </fieldset>
	    <fieldset>
	      <input placeholder="密码" type="password" name="password" tabindex="2" required>
	    </fieldset>
	    
	    <br/>
	    <fieldset>
	      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">登陆</button>
	    </fieldset>
	  </form>
		
	</div>
	
	<!-- form end -->
	
	
	<!--bottom start  -->
    <div class="bottom" style="width: 100%; margin-top:130px" >
		
		Copyright ©2017 Host Game Store Center  All Rights Reserved<br/>
		班级：15软件工程1班  &nbsp;&nbsp;    姓名：汪明鑫  &nbsp;&nbsp; 学号：1525161009<br/>
	</div> 
	<!--bottom end  -->
	
</body>
</html>