<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>图书录入</title>
	</head>
	<body>
		<s:form action="bookEntry" method="post" theme="simple" enctype="multipart/form-data">
			<s:action name="pType" id="pType"/>

			ISBN:<s:textfield name="book.isbn"></s:textfield> <br>
			图书名：<s:textfield name="book.bookName"></s:textfield><br>
			定价：<s:textfield name="book.publishedPrice"></s:textfield><br>
			作者：<s:textfield name="book.author"></s:textfield><br>
			出版社：<s:textfield name="book.publisher"></s:textfield><br>
			版次：<s:textfield name="book.version"></s:textfield><br>
			分类：
			<s:select list="#pType.pType" headerKey="0"
				listKey="productTypeId" listValue="productTypeName" name="PTypeID"
				></s:select>
<br>
			出版时间：<s:textfield name="book.publishingTime"></s:textfield><br>
			目录：<s:textarea name="book.catalog"></s:textarea><br>
			内容简介：<s:textarea name="book.briefIntroduction"></s:textarea><br>
			图片：<s:file name="upload"></s:file><br>
			<s:submit value="录入"></s:submit>
			<s:reset value="重置"></s:reset>
		</s:form>

	</body>
</html>