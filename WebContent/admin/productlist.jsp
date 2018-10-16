<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理-商品管理</title>

<link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet">


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
							<a href="#">购物车</a>|						
							<a href="#">购物中心</a>|							
						    <a href="${pageContext.request.contextPath}/pages/login.jsp">用户登陆</a>|
						    <a href="${pageContext.request.contextPath}/pages/apply.jsp" >用户注册</a>|
						    <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
						</td>
					</tr>
					
				</table>
		</div>
			
	</div>	

	<!--end top -->
	
	<!-- product start -->
	
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0" >
			<TBODY>
				
				<tr>
					
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						
						<button type="button" id="add" name="add" value="添加商品"
							class="button_add" style="font-size:20px;" onclick="addProduct()">添加商品
						</button>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
				<form>
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								
								
								<td align="center" width="10%">商品编号</td>
								<td align="center" width="20%">商品名称</td>
								<td align="center" width="10%">商品价格</td>
								<td align="center" width="10%">商品库存</td>
								<td width="20%" align="center">商品类别</td>
								<td width="10%" align="center">编辑</td>

								<td width="10%" align="center">删除</td>
							</tr>

							<s:iterator value="#allProduct" var="p" status="index">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%" >
										<s:property value="#index.index+1"/>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="20%"><s:property value="name"/></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><s:property value="price"/></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="10%"><s:property value="pnum"/></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="20%"><s:property value="category"/></td>
									<td align="center" style="HEIGHT: 22px" width="10%">
										<s:a href="ProductAction_editUI?id=%{id}">
											<img
											src="${pageContext.request.contextPath}/img/i_edit.gif"
											border="0" style="CURSOR: hand"> 
											
										</s:a>
											
									</td>

									<td align="center" style="HEIGHT: 22px" width="10%">
									
										<s:a href="ProductAction_delete?id=%{id}">
												<img
												src="${pageContext.request.contextPath}/img/i_del.gif"
												width="16" height="16" border="0" style="CURSOR: hand">
												
										</s:a>
									
									</td>
								</tr>
								</s:iterator> 
						</table>
					</form>
					</td>
				</tr>
			</TBODY>
		</table>
		
	<!-- product end -->
	
	
	<!--bottom start  -->
   <!--  <div class="bottom" style="width: 100%; margin-top: 450px;">
		
		Copyright ©2017 Host Game Store Center  All Rights Reserved<br/>
		班级：15软件工程1班  &nbsp;&nbsp;    姓名：汪明鑫  &nbsp;&nbsp; 学号：1525161009<br/>
	</div>  -->
	<!--bottom end  -->
</body>

<script type="text/javascript">
	
	//添加商品
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/admin/add.jsp";
	}
	
</script>

</html>