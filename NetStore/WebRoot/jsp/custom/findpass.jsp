<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码</title>
</head>
<body>
<div align="right"><a href="../front/default.jsp">找回密码帮助</a></div>
<h1 align="center">找回密码</h1>
<form action="../front/default.jsp">
<table width="60%" border="0" align="center">
  <tr>
    <td width="13%">注册Email：</td>
    <td width="26%"><input type="text" name="username" id="username" /></td>
    <td width="61%">*</td>
  </tr>
  <tr>
    <td> 验证码：</td>
    <td><input name="verifyCode" type="text" id="verifyCode" size="10" maxlength="10" />
    <img src="" alt="" name="verifyCodeImg" width="98" height="19" id="verifyCodeImg" /></td>
    <td>*</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="login" id="login" value="确认" />
      <label>&nbsp;&nbsp;</label></td>
    <td>确认后系统会发送新密码至您的注册Email</td>
  </tr>
</table>
  <p>&nbsp;</p>
</form>


</body>
</html>