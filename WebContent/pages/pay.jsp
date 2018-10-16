<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>在线支付</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />

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
	
	<div style="margin-top: 50px; margin-left: 300px;">
	<form action="${pageContext.request.contextPath }/OrderAction_payOnline" method="post">
		订单号：
		<s:textfield name="id" value="%{id}" readonly="true"></s:textfield>
		支付金额：
		<s:textfield name="money" value="%{money}" readonly="true"></s:textfield>元
		
		<br/>
		<br/>
		
		<div class="divBank">
			<div class="divText" style="margin-bottom: 20px">选择网上银行</div>
			<div style="margin-left: 20px;">
				<div style="margin-bottom: 20px;">
					<input id="ICBC-NET-B2C" type="radio" name="yh"
						value="ICBC-NET-B2C" checked="checked" />
						 <img
						name="ICBC-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/icbc.bmp" /> 
						<input
						id="CMBCHINA-NET-B2C" type="radio" name="yh"
						value="CMBCHINA-NET-B2C" />
						 <img name="CMBCHINA-NET-B2C"
						align="middle" src="${pageContext.request.contextPath }/img/bank/cmb.bmp"/> 
						<input
						id="ABC-NET-B2C" type="radio" name="yh" value="ABC-NET-B2C" /> 
						<img
						name="ABC-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/abc.bmp"/> 
						<input
						id="CCB-NET-B2C" type="radio" name="yh" value="CCB-NET-B2C" />
						 <img
						name="CCB-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/ccb.bmp" />
				</div>
				<div style="margin-bottom: 20px;">
					<input id="BCCB-NET-B2C" type="radio" name="yh"
						value="BCCB-NET-B2C" /> 
						<img name="BCCB-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/bj.bmp" /> <input
						id="BOCO-NET-B2C" type="radio" name="yh" value="BOCO-NET-B2C" />
					<img name="BOCO-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/bcc.bmp" />
						 <input
						id="CIB-NET-B2C" type="radio" name="yh" value="CIB-NET-B2C" /> 
						<img
						name="CIB-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/cib.bmp" /> <input
						id="NJCB-NET-B2C" type="radio" name="yh" value="NJCB-NET-B2C" />
					<img name="NJCB-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/nanjing.bmp" />
				</div>
				<div style="margin-bottom: 20px;">
					<input id="CMBC-NET-B2C" type="radio" name="yh"
						value="CMBC-NET-B2C" /> 
						<img name="CMBC-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/cmbc.bmp" /> <input
						id="CEB-NET-B2C" type="radio" name="yh" value="CEB-NET-B2C" /> <img
						name="CEB-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/guangda.bmp" /> <input
						id="BOC-NET-B2C" type="radio" name="yh" value="BOC-NET-B2C" /> <img
						name="BOC-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/bc.bmp" /> <input
						id="PINGANBANK-NET" type="radio" name="yh" value="PINGANBANK-NET" />
					<img name="PINGANBANK-NET" align="middle"
						src="${pageContext.request.contextPath }/img/bank/pingan.bmp" />
				</div>
				<div style="margin-bottom: 20px;">
					<input id="CBHB-NET-B2C" type="radio" name="yh"
						value="CBHB-NET-B2C" /> <img name="CBHB-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/bh.bmp" /> <input
						id="HKBEA-NET-B2C" type="radio" name="yh" value="HKBEA-NET-B2C" />
					<img name="HKBEA-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/dy.bmp" /> <input
						id="NBCB-NET-B2C" type="radio" name="yh" value="NBCB-NET-B2C" />
					<img name="NBCB-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/ningbo.bmp" /> <input
						id="ECITIC-NET-B2C" type="radio" name="yh" value="ECITIC-NET-B2C" />
					<img name="ECITIC-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/zx.bmp" />
				</div>
				<div style="margin-bottom: 20px;">
					<input id="SDB-NET-B2C" type="radio" name="yh" value="SDB-NET-B2C" />
					<img name="SDB-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/sfz.bmp" /> <input
						id="GDB-NET-B2C" type="radio" name="yh" value="GDB-NET-B2C" /> <img
						name="GDB-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/gf.bmp" /> <input
						id="SHB-NET-B2C" type="radio" name="yh" value="SHB-NET-B2C" /> <img
						name="SHB-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/sh.bmp" /> <input
						id="SPDB-NET-B2C" type="radio" name="yh" value="SPDB-NET-B2C" />
					<img name="SPDB-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/shpd.bmp" />
				</div>
				<div style="margin-bottom: 20px;">
					<input id="POST-NET-B2C" type="radio" name="yh"
						value="POST-NET-B2C" /> <img name="POST-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/post.bmp" /> <input
						id="BJRCB-NET-B2C" type="radio" name="yh" value="BJRCB-NET-B2C" />
					<img name="BJRCB-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/beijingnongshang.bmp" /> <input
						id="HXB-NET-B2C" type="radio" name="yh" value="HXB-NET-B2C" /> <img
						name="HXB-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/hx.bmp" /> <input id="CZ-NET-B2C"
						type="radio" name="yh" value="CZ-NET-B2C" /> <img
						name="CZ-NET-B2C" align="middle"
						src="${pageContext.request.contextPath }/img/bank/zheshang.bmp" />
				</div>
			</div>
			<div style="margin: 40px; text-align: center">
				
				<INPUT TYPE="submit" value="确定支付">
			</div>
		</div>
	</form>
	</div>
</body>
</html>
