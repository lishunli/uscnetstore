<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserInforChange.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><br><br><br>
    <form action="UserInforChange.Action" method="post">
    <table width="700" cellspacing="1" cellpadding="3" border="3" align="center" class="tableborder2" height="350"> 
    <tr> 
       <td valign="middle" height="25" align="center" colspan="3"><font color="blue"><b>修改个人信息</b></font><br></td> 
    </tr> 
    <tr>
        <td valign="middle"  align="center" width="25%">真实姓名</td>
        <td valign=middle class=tablebody1 width="70%"><input name="usernamet" type="text"/> &nbsp;</td>
        <td>*</td>
    </tr>   
    <tr> 
       <td valign="middle"  align="center" >性 别</td>
       <td width="6%" class="tablebody1">${user.sex}</td> 
    </tr> 
       <td valign="middle"  align="center" >地 址</td>
       <td>
          <select name="selP1" id="selP1" >
            <option value=1>四川</option>
            <option value=2>上海</option>
            <option value=3>浙江</option>
          </select>
          <select name="selP2" id="selP2" >
            <option value=1>成都市</option>
            <option value=2>上海</option>
            <option value=3>合肥市</option>
          </select>
        </td>
    <tr> 
       <td valign="middle"  align="center" >邮 编</td>
        <td valign=middle class=tablebody1><input name="usernamet" type="text"/> &nbsp;</td>
        <td>*</td>
    </tr> 
     <tr> 
       <td valign="middle"  align="center" >移动电话</td>
        <td valign=middle class=tablebody1><input name="mobile" type="text"/> &nbsp;</td>
        <td>*</td>
    </tr> 
     <tr> 
       <td valign="middle"  align="center" >固定电话</td>
        <td valign=middle class=tablebody1><input name="phone" type="text"/> &nbsp;</td>
        <td>*</td>
    </tr> 
    <tr>
       <td class=tablebody2 valign=middle  align=right colspan="3">
		<input type="submit" value="确  定" /><input type="submit" value="取  消" /></td>
    </tr> 
    </table>
    </form>
  </body>
</html>
