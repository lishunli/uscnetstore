<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<div align="right"><a href="../front/default.jsp">登录帮助</a></div>
<h1 align="center">登录</h1>
<form id="login" name="login" method="post" action="../front/default.jsp">
  <table width="60%" border="0" align="center">
    <tr>
      <td width="13%">用户名或Email地址：</td>
      <td width="31%"><input type="text" name="username" id="username" /></td>
      <td width="56%">*</td>
    </tr>
    <tr>
      <td>密 &nbsp;&nbsp;码：</td>
      <td><input type="password" name="password" id="password" /></td>
      <td>*</td>
    </tr>
    <tr>
      <td> 验证码：</td>
      <td><input name="verifyCode" type="text" id="verifyCode" size="10" maxlength="10" />
      <img src="" alt="" name="verifyCodeImg" width="98" height="19" id="verifyCodeImg" /></td>
      <td>*</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="login" id="login" value="登录" />
         <a href="findpass.jsp"> 忘记密码</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp">&nbsp;&nbsp;注册新用户</a></td>
      <td>&nbsp; </td>
    </tr>
  </table>
</form>

</body>
</html>