<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'suggestion.jsp' starting page</title>
    
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
     <table cellspacing=1 cellpadding=4 border="3" width="938" align=center class=tableBorder2 height="110">
         <td valign=middle  align=center height=25 background="WebRoot/images/bg2.gif" ><font color="blue"><b>建 议</b></font></td>
         <td name="mark" type="text" value=" ">尊敬的客户：您好！
            为了您更好地购物，如果您对我们公司有什么建议或意见，请您在下面填写您的建议或意见的内容并提交，我们会及时妥善处理。
            如果您的建议或意见被采纳，我们会衷心地感谢您提的建议或意见并赠送相应的积分。非常谢谢您的参与！
</td> 
     </table>
     <form action="suggestion.action" method="post">
     <table cellspacing=1 cellpadding=4 border="3" width="938" align=center class=tableBorder2 height="300">
        <tr><td valign=left align=left><input name="suggestion" type="text"/>&nbsp;</td> </tr>
       <tr>
			<td class=tablebody2 valign=middle  align=right>
			<input type="submit" value="确  定" /><input type="submit" value="取  消" /></td>
		</tr>
     </table>
     </form>
   
  </body>
</html>