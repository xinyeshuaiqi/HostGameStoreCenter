<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑商品</title>

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
						    <a href="${pageContext.request.contextPath}/pages/apply.jsp">用户注册</a>|
						    <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
						</td>
					</tr>
					
				</table>
		</div>
			
	</div>	

	<!--end top -->

	
	<s:form id="userAction_save_do" name="Form1" action="ProductAction_edit.action" enctype="multipart/form-data">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="60%" height="400px" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3; margin:30px auto" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑商品</STRONG> </strong>
				</td>
			</tr>
			
			
			<tr>
				<td><br></td>
			</tr>
			
			<s:hidden name="id"></s:hidden>
			
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品名称：</td>
				<td class="ta_01" bgColor="#ffffff">
					<s:textfield name="name" class="bg"></s:textfield>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品价格：</td>
				<td class="ta_01" bgColor="#ffffff">
				
					<s:textfield name="price" class="bg"></s:textfield>
				</td>
			</tr>
			
			<tr>
				<td><br></td>
			</tr>
			
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品库存：</td>
				<td class="ta_01" bgColor="#ffffff">
					<s:textfield name="pnum" class="bg"></s:textfield>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品类别：</td>
				<td class="ta_01" bgColor="#ffffff">
				<%-- <select name="category" id="category">
						<option value="" selected="selected">--选择商品类别--</option>
						<option value="英雄联盟">英雄联盟</option>
						<option value="绝地求生">绝地求生</option>
						<option value="王者荣耀">王者荣耀</option>
						<option value="荒野行动">荒野行动</option>
						<option value="守望先锋">守望先锋</option>
						<option value="CSGO">CSGO</option>
						<option value="DOTA2">DOTA2</option>
						<option value="DNF">DNF</option>
						<option value="穿越火线">穿越火线</option>
						<option value="单机游戏">单机游戏</option>
						<option value="其他">其他</option>
				</select> --%>
				
				<s:select name="category" list=" {'英雄联盟','绝地求生','王者荣耀','荒野行动','守望先锋',
				'CSGO','DOTA2','DNF','穿越火线','单机游戏','其他' }" 
				
				headerKey="其他"
				headerValue="--选择商品类别--"
				>
					
				</s:select>
				</td>
			</tr>
			
			<tr>
				<td><br></td>
			</tr>
			
			
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品封面：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3">
				
				
				<s:file name="photo" label="商品封面"></s:file>
				</td>
			</tr>
			
			<tr>
				<td><br></td>
			</tr>
			
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">商品描述：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3">
				
				<s:textarea name="description" cols="30" rows="3" cssStyle="WIDTH: 96%"></s:textarea>
				</TD>
			</TR>
			
			<tr>
				<td><br></td>
			</tr>
			
			<TR>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/img/shim.gif">
				</td>
			</TR>


			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					
					
						
					<input type="submit" class="button_ok" value="确定">	
						
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					
					
					
					<input type="reset" value="重置" class="button_cancel">

					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> 
					
					<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					
					<span id="Label1">
					
					</span>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>