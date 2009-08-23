<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UHistory.jsp' starting page</title>
    
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
        <table width="942" height="107" border="5" cellspacing="1" cellpadding="1">
           <tr><td class=tablebody2 valign=middle colspan=6 align=center><font color="blue"><b>U币历史清单</b></td></tr>
           <tr>
               <td width="6%" class="tablebody1">${uCurrencyDetail.uCurrencyID}</td>
               <td width="6%" class="tablebody1">${uCurrencyDetail.last}</td>
               <td width="6%" class="tablebody1">${uCurrencyDetail.current}</td>
               <td width="6%" class="tablebody1">${uCurrencyDetail.source}</td>
               <td width="6%" class="tablebody1">${uCurrencyDetail.destination}</td> 
               <td width="6%" class="tablebody1">${uCurrencyDetail.uCurrencyDate}</td>
           </tr>
           

           
            <tr>
              <td>2</td> <td>60</td> <td>80</td> <td>jim</td> <td>转入</td> <td>2008-10-25</td>
           </tr> <tr>
              <td> 3</td> <td>80 </td> <td>40</td> <td> </td> <td>704245</td> <td>2009-1-25</td>
           </tr>
        </table><br>
  </body>
</html>
