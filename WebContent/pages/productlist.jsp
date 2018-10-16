<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>

<link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/productlist.css" type="text/css" rel="stylesheet">



</head>
<body style="background-color: antiquewhite;">
	
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
	
	
	
	<div id="search" align="right" style="width: 100%; height:30px; background-color: grey; padding-top: 10px">
				<input type="text" />
				<input type="button" value="搜索" />
	</div>
	
	
	<div id="divpagecontent" style=" margin-bottom: 50px">
		
		<img src="${pageContext.request.contextPath}/img/b.jpg" style="float: left; margin-top:20px; width: 50px; height: 50px">
		
		<div class="condition" style="border: 1px thick; width: 50%; margin-bottom: 10px;">
		
		<s:form namespace="/" action="ProductAction_findAllByCondition">
			
			<s:hidden id="currentPage" name="currentPage" value="1"></s:hidden>
			<br>
			
			<table border="0" class="emp_table" >
			  <tr>
			    <td >商品类别：</td>
			    <td>
			    
			    <s:select name="category" list=" {'英雄联盟','绝地求生','王者荣耀','荒野行动','守望先锋',
				'CSGO','DOTA2','DNF','穿越火线','单机游戏','其他' }" 
				
				headerKey=""
				headerValue="--选择商品类别--"
				></s:select>
				
			    </td>
			  </tr>
			  
			  <tr></tr>
			  <tr></tr>
			  
			  <tr>
			    <td >商品描述：</td>
			    <td >
			    <s:textfield name="description" size="30"></s:textfield>
			    </td>
			  </tr>
			  
			  <tr></tr>
			  <tr></tr>
			  
			  <tr>  
			    <td >商品价格：</td>
			    <td >
			     <s:textfield name="minPrice" size="12"></s:textfield> 至  <s:textfield name="maxPrice" size="12"></s:textfield>
			    </td>
			  </tr>
			  
			
			</table>
			
			<br/>
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<s:submit value="查询商品"></s:submit>
			
		
		</s:form>
		
		</div>
		
		
		<table width="100%" border="0" cellspacing="0">
		
			<tr>

				<td>
					

					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h1 style="color:blue;">商品目录</h1>
								
								<div style="margin-top:10px; margin-bottom:5px">
									<img src="${pageContext.request.contextPath }/img/productlist.gif" width="100%" height="38" />
								</div>

								<table cellspacing="0" class="booklist">
									<tr>
									<s:iterator value="#pageBean.data" var="product">
										<td>

											<div class="divbookpic">
												<p>
												
														
													<s:a href="ProductAction_findById.action?id=%{id}" width="115" height="129" border="0">
														<%-- <s:param name="id"><s:property value="id" /></s:param>  --%>
														<img src="${pageContext.request.contextPath }/productImg/<s:property value='img_url' />" />
														<br/>
													</s:a>
												</p>
											</div>
											
											<div class="divlisttitle">
												
												<s:a href="ProductAction_findById.action?id=%{id}" cssStyle="color:blue; font-size:15px;">
													<%-- <s:param name="id"><s:property value="id" /></s:param>  --%>
													商品名称:<s:property value="name" /><br />
													售价:<s:property value="price" />
												</s:a>
											
											</div>
										</td>
									</s:iterator>									
									</tr>
								</table>
								
								<table border="0" cellspacing="0" cellpadding="0" align="center">
								  <tr>
								    <td align="right">
								    	
								    </td>
								  </tr>
								</table>			
								
								
								
								
								
								<table border="0" cellspacing="0" cellpadding="0" align="center">
									<tr>
									  <td align="right">
									  	<span>第<s:property value="#pageBean.currentPage"/>/<s:property value="#pageBean.totalPage"/>页</span>
									      <span>
									      	<s:if test="#pageBean.currentPage>1">
									       	<a href="javascript:void(0)" onclick="showPage(1)" style="color:blue;">[首页]</a>&nbsp;
									           <a href="javascript:void(0)" onclick="showPage(<s:property value="#pageBean.currentPage-1"/>)" style="color:blue;">[上一页]</a>&nbsp;&nbsp;
									          </s:if>
									          
									       	
									          <s:if test="#pageBean.currentPage<#pageBean.totalPage">
									          <a href="javascript:void(0)" onclick="showPage(<s:property value="#pageBean.currentPage+1"/>)" style="color:blue;">[下一页]</a>
									          <a href="javascript:void(0)" onclick="showPage(<s:property value="#pageBean.totalPage"/>)" style="color:blue;">[尾页]</a>&nbsp;&nbsp;
									      	</s:if>
									      </span>
									    </td>
									  </tr>
								</table>										
								</td>
								
								<tr>
								
								
						</tr>
					</table>
				</td>
			</tr>
		</table>
		
		
	</div>
	
</body>

<script type="text/javascript">
	function showPage(num){
		
		//修改隐藏域的值
		document.getElementById("currentPage").value=num;
		document.forms[0].submit();
	}

</script>


</html>