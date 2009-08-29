<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/" + "customjsp" + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'BooksMain.jsp' starting page</title>

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
		<s:action name="init"></s:action>
		<s:if test="#request.bookCommonInit">
			<table width="800" align="center">
				<tr>
					图书
					<p align="right">
						<a href="BooksMain.jsp">更多</a>
					</p>
				</tr>
				<tr>
					<s:iterator value="#request.bookCommonInit" id="bookCommonInit"
						status="count">
						<td width="200" height="120"
							style="width: 200px; word-break: break-all" align="center">
							<a href="#"> <img
									src="<%=basePath
								+ "ShowImage.image?type=1&entityId="%><s:property value="#bookCommonInit.bookId"/>"
									width="100" height="100" alt="照片"
									title="<s:property value="#bookCommonInit.bookName" />"
									onerror="javascript:this.src='../images/custom/NoPhoto.jpg'" />
							</a>
							<DIV
								STYLE="width: 200x; height: 20px; border: 1px; overflow: hidden; text-overflow: ellipsis">
								<s:property value="#bookCommonInit.bookName" />
							</DIV>
							<p style="color: red">
								￥
								<s:property value="#bookCommonInit.privilegePrice" />
							</p>
							<p>
								(市场价￥
								<s:property value="#bookCommonInit.publishedPrice" />
								)
							</p>
						</td>
						<s:if test="#count.modulus(6)==0">
							<s:if test="#count.last">
								</tr>
							</s:if>
						<s:else>
							<tr>
						</s:else>
						</s:if>


				</s:iterator>
			</table>
		</s:if>
	</body>
</html>
