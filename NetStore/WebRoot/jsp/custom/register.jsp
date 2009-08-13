<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
<div align="right"><a href="../front/default.jsp">注册帮助</a></div>
<h1 align="center">注册</h1>
<form id="form2" name="form2" method="post" action="../front/default.jsp">
  <table width="60%" border="0"  align="center">
    <tr>
      <td width="13%">用户名</td>
      <td width="58%"><input type="text" name="username" id="username" /></td>
      <td width="29%">*</td>
    </tr>
    <tr>
      <td>密 &nbsp;&nbsp;码：</td>
      <td><input type="password" name="password" id="password" /></td>
      <td>*</td>
    </tr>
    <tr>
      <td>重复密码：</td>
      <td><input type="password" name="password2" id="password2" /></td>
      <td>*</td>
    </tr>
    <tr>
      <td>Email：</td>
      <td><input type="text" name="username2" id="username2" /></td>
      <td>*</td>
    </tr>
    <tr>
      <td>真实姓名</td>
      <td><input type="text" name="username3" id="username3" /></td>
      <td>*</td>
    </tr>
    <tr>
      <td>性别</td>
      <td>&nbsp;
      	<select></select>
      </td>
      <td>*</td>
    </tr>
    <tr>
      <td>地址</td>
      <td>&nbsp;
      省/直辖市：<select></select>直辖市/市：<select></select>区/县：<select></select>
      街区：
      <input type="text" name="username4" id="username4" /></td>
      <td>*</td>
    </tr>
    <tr>
      <td>邮编</td>
      <td><input type="text" name="username5" id="username5" /></td>
      <td>*</td>
    </tr>
    <tr>
      <td>移动电话</td>
      <td><input type="text" name="username6" id="username6" /></td>
      <td>*</td>
    </tr>
    <tr>
      <td>固定电话</td>
      <td><input type="text" name="username7" id="username7" /></td>
      <td>&nbsp;</td>
    </tr>
    
    <tr>
      <td> 验证码：</td>
      <td><input name="verifyCode" type="text" id="verifyCode" size="10" maxlength="10" />
          <img src="" alt="" name="verifyCodeImg" width="98" height="19" id="verifyCodeImg" /></td>
      <td>*</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="register" id="register" value="注册" />
        <label>&nbsp;&nbsp;</label>
       &nbsp;&nbsp;&nbsp;&nbsp; <a href="login.jsp">登录
        </a></td>
      <td>&nbsp;</td>
    </tr>
  </table>
</form>

</body>
</html>