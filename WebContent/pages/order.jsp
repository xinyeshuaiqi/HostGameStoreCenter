<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/normal.css" type="text/css" />
</head>
<body style="background-color: antiquewhite;">
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
	
	<div id="divpagecontent" style="margin-top: 70px">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>

					<form id="orderForm" action="${pageContext.request.contextPath }/OrderAction_createOrder.action" method="post">
						<table cellspacing="0" class="infocontent">
							<tr>
								<td><table width="100%" border="0" cellspacing="0">
										<tr><td></td></tr>
										
										<tr>
											<td>
												<b style="font-size:20px; color:blue;">您好：${user.username }！欢迎您来到商城结算中心</b></td>
										</tr>
										
										<tr><td></td></tr>
										<tr><td></td></tr>
										<tr>
											<td><table cellspacing="1" class="carttable">
													<tr>
														<td width="10%">序号</td>
														<td width="40%">商品名称</td>
														<td width="10%">价格</td>
														<td width="10%">类别</td>
														<td width="10%">数量</td>
														<td width="10%">小计</td>

													</tr>
												</table>
												<c:set var="sum" value="0"></c:set>
												<table width="100%" border="0" cellspacing="0">
													<c:forEach items="${cart }" var="entry" varStatus="vs">
														<tr>
															<td width="10%">${vs.count }</td>
															<td width="40%">${entry.key.name}</td>
															<td width="10%">${entry.key.price}</td>
															<td width="10%">${entry.key.category}</td>
															<td width="10%">${entry.value}</td>
															<td width="10%">${entry.key.price*entry.value}</td>
														</tr>
														<c:set var="sum" value="${sum+entry.key.price*entry.value }"></c:set>
													</c:forEach>
												</table>


												<table cellspacing="1" class="carttable">
													<tr>
														<td style="text-align:right; padding-right:40px;"><font
															style="color:#FF0000">合计：&nbsp;&nbsp;${sum }</font></td>
													</tr>
													<tr>
														<td>
															<input type="hidden" name="money" value="${sum }" />
														</td>
													</tr>
												</table>
												<br/>
												
												<p>
													收货邮箱：<input name="receiverEmail" type="email" value=""
														style="width:350px"/>&nbsp;&nbsp;&nbsp;&nbsp
													<br /> 
													<br/>
													<br/>
													

												</p>
											
												<p style="text-align:right">
													<img src="${pageContext.request.contextPath }/img/gif53_029.gif" width="204" height="51"
														border="0"  onclick="doOrder()"/>
												</p></td>
										</tr>
									</table></td>
							</tr>
						</table>
					</form></td>
			</tr>
		</table>
	</div>
	
	
	
</body>

<script>
function doOrder(){
		document.getElementById("orderForm").submit();
	}
</script>

</html>