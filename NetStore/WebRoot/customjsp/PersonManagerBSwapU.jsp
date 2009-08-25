<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>积分换U币</title>
    
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
  <table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <a href=index.jsp>积分管理</a> → 积分换U币
                </td>
                </tr>
		</table>
              <br>
               <table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr><td height=25 valign=middle>
              欢迎参与积分回馈活动：
                </td></tr>
        <tr>
		<td height=25 valign=middle>
              1. XXXXXXXXXXXXXXdggggsadgsasdggdsdgdsdgsdgdggd
                </td></tr>
        <tr>
        <td height=25 valign=middle>
              2. XXXXXXXXXXXXXXsdgghgdsgsdgsafsfsdf
                </td></tr>
        <tr>
        <td height=25 valign=middle>
             3. XXXXXXXXXXXXXXfffffffffffffffffffffff
                </td></tr> 
        <tr>
        <td height=25 valign=middle>
             4. XXXXXXXXXXXXXXdddddddddddddddddddddddddddd
                </td></tr> 
        <tr>
        <td height=25 valign=middle>
              5. XXXXXXXXXXXXXXsssssssssssssssssssss
                </td></tr>
		</table><br>
		
		
		
      		  <form action="converte.action" method="post">
              <table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle colspan=2 align=center height=25 background="WebRoot/images/bg2.gif" ><font color="blue"><b>积分兑换</b></font></td>
		</tr>
		<tr>
		<td valign=middle class=tablebody1>您的当前积分：</td>
			<td width="60%" class="tablebody1">${user.jifen}</td>
		</tr>

		<tr>
			<td valign=middle class=tablebody1>请输入您要兑换的积分：</td>
			<td valign=middle class=tablebody1>
			<input name="count" type="text" valve="20"/> &nbsp; </td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle colspan=2 align=center>
			<input type="submit" value="兑 换" /></td>

		</tr>
		</table>
      </form>
  </body>
</html>
