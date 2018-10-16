<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册账号</title>

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
	
	
	<!-- form start -->
	
	<div class="container">  
	  <form id="contact" action="${pageContext.request.contextPath}/UserAction_register" method="post">
	    <h3>用户注册</h3>
	    <h4></h4>
	     
	     <s:actionerror cssStyle="color:red; font-weight: bold;"/>
	    <fieldset>
	     <input placeholder="用户名" type="text" name="username" tabindex="1" required autofocus> 
	              
	    </fieldset>
	   
	    <fieldset>
	      <input placeholder="密码" type="password" name="password" tabindex="2" required>
	    </fieldset>
	    <fieldset>
	      <input placeholder="邮箱" type="email" name="email" tabindex="3" required>
	    </fieldset>
	    <fieldset>
	      <input type="radio" name="gender" value="男" checked="checked" /> 男
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="gender" value="女" /> 女
	    </fieldset>
	    <fieldset>
	      <input placeholder="联系电话" name="telephone" type="tel" tabindex="4" required>
	    </fieldset>
	    
	   <fieldset>
	      <input placeholder="请输入校验码" type="text" name="code" size="4" required>
	    </fieldset>
	    
	    <s:fielderror name="code" cssStyle="color:red; font-weight: bold;"></s:fielderror>
	   	<img src="${pageContext.request.contextPath}/imageCodeAction_code.action" id="img" />&nbsp;&nbsp;
		<br/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:changeImage()" style="color:black;">看不清换一张</a>
	    
	    <fieldset>
	      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">注册</button>
	    </fieldset>
	  </form>
		
	</div>
	
	<!-- form end -->
	
	<!--bottom start  -->
    <div class="bottom" style="width: 100%; ">
		
		Copyright ©2017 Host Game Store Center  All Rights Reserved<br/>
		班级：15软件工程1班  &nbsp;&nbsp;    姓名：汪明鑫  &nbsp;&nbsp; 学号：1525161009<br/>
	</div> 
	<!--bottom end  -->

</body>

<script type="text/javascript">
	function changeImage() {

		document.getElementById("img").src = "${pageContext.request.contextPath}/imageCodeAction_code.action?time="
				+ new Date().getTime();
	}
</script>

</html>