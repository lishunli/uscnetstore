<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>发布商品</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/publishe.js"></script>
	</head>

	<body>

		<s:form name="backSerach" method="post" theme="simple">
		产品分类
		<s:select list="{'图书','数码'}" id="type" name="type" value="type"></s:select>
		产品名称
		<s:textfield name="productsName"></s:textfield>
			<s:submit value="搜搜"></s:submit>
			<s:if test="#request.bookSerach">
				<table border="1" width="80%" align="center">
					<tr>
						<td>
							图书名称
						</td>
						<td>
							作者
						</td>
						<td>
							出版社
						</td>
						<td>
							定价
						</td>
						<td>
							折扣
						</td>
						<td>
							操作
						</td>
					</tr>
					<s:iterator value="#request.bookSerach" id="book">
						<tr>
							<td>
								<s:property value="#book.bookName" />
							</td>
							<td>
								<s:property value="#book.author" />
							</td>
							<td>
								<s:property value="#book.publisher" />
							</td>
							<td>
								<s:property value="#book.publishedPrice" />
							</td>

							<td>
								<s:textfield id="discount" name="discount"></s:textfield>
							</td>

							<td>
<input type="button" onclick="publishe(<s:property value='#book.bookId'/>)" value="发布"/>
<%--								<s:a href="publishe.action?type=publishe()">发布</s:a>--%>
							</td>

						</tr>
					</s:iterator>
				</table>
			</s:if>


			<s:if test="#request.digitalSerach">
				<table border="1" width="80%" align="center">
					<tr>
						<td>
							名
						</td>
					</tr>
					<s:iterator value="#request.digitalSerach" id="digital">
						<tr>
							<td>
								<s:property value="#digital.digitalName" />
							</td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
		</s:form>
	</body>
</html>
