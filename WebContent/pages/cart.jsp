<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>购物车</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/normal.css" type="text/css" />
<script type="text/javascript">
	function changeProductNum(id,num,Maxcount){
		num=parseInt(num);
		Maxcount=parseInt(Maxcount);
		if(num<1){
			if(confirm("是否确认不购买本书？")){
				num=0;
			}else{
				num=1;
			}
		}
		
		if(num>Maxcount){
			alert("购买数量过多");
			num=Maxcount;
		}
		location.href="${pageContext.request.contextPath}/ProductAction_changeNum?id="+id+"&num="+num;
	}
</script>

</head>

<body class="main" style="background-color: antiquewhite;">
	
	<div class="top">
		
		<div class="text">
		Host Game Store Center</div>
		
		<div class="menu">
		
				<table >
					<tr>					
						<td align="right">
							<img src="${pageContext.request.contextPath}/img/cart.gif"/>
							<a href="#">购物车</a>|						
							<a href="${pageContext.request.contextPath}/ProductAction_findAllByCondition.action">购物中心</a>|						
						    <a href="${pageContext.request.contextPath}/pages/login.jsp">用户登陆</a>|
						    <a href="${pageContext.request.contextPath}/pages/apply.jsp" >用户注册</a>|
						    <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
						</td>
					</tr>
					
				</table>
		</div>
			
	</div>	
	
	<div id="divpagecontent" style="margin-top: 50px; ">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>

					<table cellspacing="0" class="infocontent">
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0">
									
									<tr>
										<td>
											<table cellspacing="1" class="carttable">
												<tr>
													<td width="10%">序号</td>
													<td width="30%">名称</td>
													<td width="10%">价格</td>
													<td width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数量</td>
													<td width="10%">库存</td>
													<td width="10%">小计</td>
													<td width="10%">取消</td>
												</tr>
											</table> 
											
											<c:set var="sum" value="0"></c:set>
											<c:forEach items="${cart }" var="entry" varStatus="vs">
												<table width="100%" border="0" cellspacing="0">
													<tr>
														<td width="10%">${vs.count}</td>
														<td width="30%">${entry.key.name }</td>

														<td width="10%">${entry.key.price }</td>
														<td width="20%">
															<input type="button" value='-'
															style="width:20px"
															onclick="changeProductNum('${entry.key.id}','${entry.value-1}','${entry.key.pnum}')">

															<input name="text" type="text" value="${entry.value}"
															style="width:40px;text-align:center" /> <input
															type="button" value='+' style="width:20px"
															onclick="changeProductNum('${entry.key.id}','${entry.value+1}','${entry.key.pnum}')">
														</td>
														<td width="10%">${entry.key.pnum}</td>
														<td width="10%">${entry.key.price*entry.value}</td>

														<td width="10%"><a href="${pageContext.request.contextPath}/ProductAction_changeNum?id=${entry.key.id}&num=0"
															style="color:#FF0000; font-weight:bold">X</a></td>
													</tr>
												</table>
												<c:set var="sum" value="${sum+entry.key.price*entry.value }"></c:set>
											</c:forEach>

											<table cellspacing="1" class="carttable">
												<tr>
													<td style="text-align:right; padding-right:40px;"><font
														style="color:#FF6600; font-weight:bold">合计：&nbsp;&nbsp;${sum}元</font>
													</td>
												</tr>
											</table>
											<div style="text-align:right; margin-top:10px">
												<a href="${pageContext.request.contextPath}/ProductAction_findAllByCondition.action">
												<img src="${pageContext.request.contextPath}/img/gwc_jx.gif" border="0" /> </a>

												&nbsp;&nbsp;&nbsp;&nbsp;
												<a href="${pageContext.request.contextPath}/pages/order.jsp">
													<img src="${pageContext.request.contextPath}/img/gwc_buy.gif" border="0" /> 
												</a>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>

</body>
</html>
