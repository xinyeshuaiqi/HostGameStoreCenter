<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
</head>

<link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/productlist.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/reply.css" type="text/css" rel="stylesheet">

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


	<div id="divpagecontent" style="margin-top: 50px; margin-bottom: 50px">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>
					<table cellspacing="0" class="infocontent">
						<tr>
							<td>

								<table width="100%" border="0" cellspacing="0">
									<tr>
										<td width="30%">

											<div class="divbookcover">
												<p>
													<img src="${pageContext.request.contextPath }/productImg/<s:property value='img_url' />"
														width="213" height="269" border="0" />
												</p>
											</div>

											<div style="text-align:center; margin-top:25px">
												
												<s:a href="ProductAction_addCart.action?id=%{id}">
													<img src="${pageContext.request.contextPath }/img/buybutton.gif" />
												</s:a>
											</div>
										</td>
										<td style="padding:20px 5px 5px 5px; font-size:30px;" >
											<img src="${pageContext.request.contextPath }/img/miniicon3.gif" width="16" height="13" />
											<s:property value="name" />

											<hr />售价：<font color="#FF0000"><s:property value="price" /></font>
											<hr /> 类别：<s:property value="category" />

											<hr />
											<p>
												<b>简介：</b>
											</p> <s:property value="description" />
										</td>
									</tr>
								</table>
								
								<br/>
								<br/>
								<br/>
								<br/>
								
								<!-- 商品评论 -->
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<b style="color:CadetBlue  ; font-size:25px;">商品评论</b>
								<hr/>
								
								<s:set name="a" value="1"/>
								<!-- 显示回复列表 -->
								<s:iterator value="replySet" var="r">
								<table class="postList" cellspacing="0" >
									
								       <tr class="title">
								           <td width="20" class="num"></td>
								           <td ><font size="4px"><s:property  value="#a" />楼</font></td>
								           <s:set name="a"  value="#a+1"/>
								       </tr>
								       <tr class="content">
								           <td></td>
								           <td><pre><font size="5px"><s:property  value="replyContent" /></font></pre></td>
								       </tr>
								       <tr class="info" >
								           <td></td>
								           <td >
											用户：<font><s:property  value="user.username" /></font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								               <font color="#999999" ><s:date name="createDate" format="yyyy-MM-dd hh:mm:ss" /></font>
								           </td>
								       </tr>
								   </table>
								   </s:iterator>
								   			   
								<!-- 发表回复表单 -->
								<s:form action="ReplyAction_add" class="addNewTopicForm">
									<table class="publishArticleForm">
										<s:hidden name="pid" value="%{id}"></s:hidden>
								        <tr>
								        	<td></td>
								        	<td></td>
								           <!--  <td class="label" style="font-size:20px;">评论:</td> -->
								            <td><s:textarea name="replyContent" class="content"></s:textarea></td>
								        </tr>
								        <tr>
								            <td></td>
								            <td></td>
								            <td>
								            <input type="submit" value="发表评论"/></td>
								        </tr>
								    </table>
								</s:form>
							</td>
						</tr>
					</table>
				</td>
			</tr>			
		</table>
	</div>
</body>
</html>