<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.usc.daos.Custom"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>无标题文档</title>
		<style type="text/css">
<!--
.STYLE3 {
	font-size: large
}

.STYLE4 {
	font-size: x-large
}

.STYLE7 {
	font-family: "宋体";
	font-weight: bold;
}

body {
	margin-top: 5mm;
	margin-bottom: 5mm;
}
-->
</style>
		<script src="js/Custom.js"></script>
	</head>

	<body onload="CTime(bgclock)">
		<%
			String path = request.getContextPath();
		%>
		<table width="80%" height="30%" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<th colspan="2" bgcolor="#B9C8EC" scope="col">
					<marquee direction=left>
					南华大学电子商务平台 为了您的生活更简单 我们真诚为您服务！
					</marquee>
				</th>
			</tr>
			<tr>
				<th bgcolor="#B9C8EC" scope="col">
					<div align="left">
						<%
							Custom custom = (Custom) session.getAttribute("Custom");
							if (custom == null)
							{
						%>
						<%
							out.print("欢迎您光临南华大学电子商务平台");
							} else
							{
								out.print("欢迎您的光临！" + custom.getCustomName());
							}
						%>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="<%=path%>/customjsp/Login.jsp">【登录】</a><a
							href="<%=path%>/customjsp/Register.jsp" type="redirect">【注册】</a>
					</div>
				</th>
				<td bgcolor="#B9C8EC" scope="col">
					<div align="left" id="bgclock"></div>
				</td>
			</tr>
			<tr>
				<td colspan="2" background="images/custom/Log.jpg" alt="x"
					width="987" height="50" hspace="0" vspace="0" border="0"></td>
			</tr>
			<tr>
				<td width="542" height="0" bgcolor="#76946D">
				</td>
				<td bgcolor="#76946D">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td width="542" bgcolor="#E7E7E7">
					<span class="STYLE4"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><a
							href="<%=path%>/Top.jsp">首页</a>|<a
							href="<%=path%>/customjsp/BooksMain.jsp">图书</a>|<a
							href="<%=path%>/customjsp/DigitalsMain.jsp">数码</a>
					</strong>
					</span>
				</td>
				<td width="445" bgcolor="#E7E7E7">
					<span class="STYLE3"><a
						href="<%=path%>/customjsp/PersonManagerMain.jsp?action=order">我的信息库</a>&nbsp;<a
						href="<%=path%>/customjsp/ShoppingCart.jsp"> 购物车</a>&nbsp; <a
						href="<%=path%>/customjsp/NewPeoples.jsp">新手上路</a> &nbsp;<a
						href="<%=path%>/customjsp/Help.jsp">帮助中心</a>
					</span>
				</td>
			</tr>
			<form action="FuzzySearchAction.action" method="post">
				<table width="80%" height="30%" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr>
						<td bgcolor="#E7E7E7" align="left" width="40%">
							<span class="STYLE3">按产品类型： <select name="s">
									<option value="1">
										图书
									</option>
									<option value="2">
										数码
									</option>
								</select> <input name="Search" type="text" size="30" /> </span>
						</td>
						<td bgcolor="#E7E7E7" valign="top" align="left">
							<span class="STYLE7"> <input type="submit" value="搜索" />&nbsp;&nbsp;&nbsp;<a
								href="<%=path%>/customjsp/AdvancedSearch.jsp">高级搜索</a> </span>
						</td>
					</tr>
				</table>
				<hr color="#0000FF" />
			</form>
		</table>
	</body>
</html>

