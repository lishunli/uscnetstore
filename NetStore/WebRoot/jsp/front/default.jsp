<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
        <table border="0" width="920" cellspacing="0" cellpadding="0" bgcolor="white">
            <tr><td colspan="2"><jsp:include page="top.jsp"/></td></tr>
            <tr>
                <td width="230" valign="top" align="center"><jsp:include page="left.jsp"/></td>
                <td width="690" height="400" align="center" valign="top" bgcolor="#FFFFFF"><jsp:include page="main.jsp"/></td>
            </tr>
            <tr><td colspan="2"><%@ include file="botton.jsp" %></td></tr>
        </table>        
    </center>
</body>
</html>