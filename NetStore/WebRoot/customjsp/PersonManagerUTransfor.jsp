<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <base href="<%=basePath%>">
    
    <title>U币转让</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 
  <body>
       <table cellspacing=1 cellpadding=4 align=center class=tableBorder2>
		<tr><td height=25 valign=middle>U币转让说明：</td></tr>
		<tr><td height=25 valign=middle>注释：xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		</td></tr>
		</table><br>
  
  <form action="UTransfor.action" method="post">
       <table cellpadding=8 cellspacing=1 align=center class=tableborder2 width="500" border="10">
		<tr>
			<td valign=middle colspan=2 align=center height=25 background="WebRoot/images/bg2.gif" ><font color="blue"><b>U币转让</b></font></td>
		</tr>
		<tr>
		<td valign=middle class=tablebody1>您的当前U币总额：</td>
		<td width="6%" class="tablebody1">${user.uCurrency}</td> 
		</tr>

		<tr>
			<td valign=middle class=tablebody1>转入的账户：</td>
			<td valign=middle class=tablebody1>
			<input name="username" type="text"/> &nbsp; </td>
		</tr>
		<tr>
			<td valign=middle class=tablebody1>转入的金额：</td>
			<td valign=middle class=tablebody1>
			<input name="Ucount" type="text"/> &nbsp; </td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle colspan=2 align=center>
			<input type="submit" value="确定" /></td>

		</tr>
		</table>
     </form>
         
  </body>
</html>
