<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%String path=request.getContextPath();%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head> 
  <body>
  恭喜<%request.getParameter("Custom.address"); %>客户成为南华大学电子商务平台注册客户！
  <s:a href="<%=path%>/cutomjsp/Login.jsp">返回登陆页面</s:a>
  </body>
</html>
