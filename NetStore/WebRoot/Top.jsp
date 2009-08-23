<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.usc.daos.Custom" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE3 {font-size: large}
.STYLE4 {font-size: x-large}
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
<table width="80%" height="30%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <th colspan="2" bgcolor="#B9C8EC" scope="col" ><marquee direction=left>南华大学电子商务平台 为了您的生活更简单 我们真诚为您服务！</marquee></th> 
  </tr>
  <tr>
    <th bgcolor="#B9C8EC" scope="col" ><div align="left">
    <% Custom custom = (Custom)session.getAttribute("Custom");
    if(custom==null){%>
    <%out.print("欢迎您光临南华大学电子商务平台");}else{out.print("欢迎您的光临！"+custom.getCustomName());} %>
    </div></th>
    <td bgcolor="#B9C8EC" scope="col" ><div align="left" id="bgclock"></div></td>
  </tr>
  <tr>
    <td colspan="2" background="images/custom/Log.jpg"  alt="x" width="987" height="50" hspace="0" vspace="0" border="0" ></td>
  </tr>
  <tr>
    <td width="542" height="0" bgcolor="#76946D"><span class="STYLE3">您好！欢迎光临南华大学电子商务平台</span><a href="customjsp/Login.jsp">【登录】</a><a href="customjsp/Register.jsp">【注册】</a> </td>
    <td bgcolor="#76946D">&nbsp;</td>
  </tr>
  <tr>
    <td width="542" bgcolor="#E7E7E7"><span class="STYLE4"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><a href="customjsp/Main.jsp">首页</a>|<a href="customjsp/BooksMain.jsp">图书</a>|<a href="customjsp/DigitalsMain.jsp">数码</a></strong></span></td>
    <td width="445" bgcolor="#E7E7E7"><span class="STYLE3"><a href="customjsp/PersonManagerTop.jsp" type="redirect">我的信息库</a>&nbsp;<a href="customjsp/ShoppingCart.jsp"> 购物车</a>&nbsp; <a href="customjsp/NewPeoples.jsp">新手上路</a> &nbsp;<a href="customjsp/Help.jsp">帮助中心</a></span></td>
  </tr>
  <tr>
    <td bgcolor="#E7E7E7"><span class="STYLE3">按产品类型：
        <select name="select2">
          <option value="1" selected="selected">图书</option>
          <option value="2">数码</option>
        </select>
&nbsp;&nbsp;
<input name="textfield2" type="text" size="36" />
    </span></td>
    <td bgcolor="#E7E7E7"><span class="STYLE7">搜索 高级搜索</span></td>
  </tr>
</table>
<hr color="#0000FF"/>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</body>
</html>
