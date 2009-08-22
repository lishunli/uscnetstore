<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户登录</title>
	</head>
	<body bgcolor="">
		<center>
			<h1>
				登录
			</h1>
			<br>
			<hr color="#3254DD" width="80%">
			<s:form action="" method="post">
				<table>
					<tr>
						<td>
							<s:textfield name="Custom.customName" label="用户名或Email："/>
						</td>
					</tr>
					<br>
					<tr>
						<td>
							<s:textfield  name="Custom.customPass" label="密 码："/>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							&nbsp;&nbsp;&nbsp;&nbsp;<s:submit name="submit" theme="simple" value="登录" />
						</td >
						<td align="center"><s:reset theme="simple" value="重置"/></td>
					</tr>
				</table>
				<br>
				<s:a href="ForgetPassword.jsp">忘记密码？</s:a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:a
					href="Register.jsp">注册新用户</s:a>
			</s:form>
		</center>
	</body>
</html>
