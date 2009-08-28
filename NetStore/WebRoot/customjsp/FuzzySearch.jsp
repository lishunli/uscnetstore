<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 16px;
	font-weight: bold;
}
.STYLE2 {
	font-size: 18px;
	font-weight: bold;
}
.STYLE3 {font-size: 18px}
.STYLE5 {font-size: 12px}
-->
</style>
</head>

<body>
 <%@ include file="../Top.jsp"%>
<table width="80%"  border="1"  align="center" cellpadding="0" cellspacing="0" bordercolor="#DBDBDB">
  <tr>
    <th height="17" bgcolor="#88B95B" scope="col"><div align="left" class="STYLE3">您所搜的x共有x种</div></th>
  </tr>
  <tr>
    <td width="42%" height="23" bgcolor="#C9C9C9"><div align="left" class="STYLE1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;排序方式：
        <select name="select">
          <option value="0" selected="selected">按销量由多到少</option>
          <option value="1">按价格由高到低</option>
          <option value="2">按价格由低到高</option>
        </select>
        <span class="STYLE2">  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;第一页 上一页  下一页 最后一页 <span class="STYLE5">第3/10页</span></span></div></td>
  </tr>
  <tr>
    <td height="719" bgcolor="#F6F6F6">&nbsp;
    
   
   
   
   
    
 <s:if test="#request.bookCommon">
				<table border="0" width="95%" align="center" height="80%">
					<s:iterator value="#request.bookCommon" id="bookCommon">
						<tr>
							<td>
								书名：<s:property value="#bookCommon.bookName" />
							</td>
							<td>
								ISBN编号：<s:property value="#bookCommon.isbn" />
							</td>
							<td>
								 作者:<s:property value="#bookCommon.author"/>
							</td>
							<td>
								 出版社：<s:property value="#bookCommon.publisher" />
							</td>
							<td>
								定价：<s:property value="#bookCommon.publishedPrice" />
							</td>
							
							<td>
								特价：<s:property value="#bookCommon.salePrice" />
							</td>
							<td>
								折扣：<s:property value="#bookCommon.discount" />
							</td>
							 
						</tr>
					</s:iterator>

				</table>
			</s:if>
			
			
			

    
    
			<s:if test="#request.digitalCommon">
				<table border="0" width="95%" align="center" height="80%">
					<s:iterator value="#request.digitalCommon" id="digitalCommon">
						<tr>
							<td>
								数码名称：<s:property value="#digitalCommon.digitalName" />
							</td>
							<td>
								条形码：<s:property value="#digitalCommon.barcode" />
							</td>
							<td>
								厂家：<s:property value="#digitalCommon.manufacturer" />
							</td>
							<td>
								品牌：<s:property value="#digitalCommon.brand" />
							</td>
							<td>
								型号：<s:property value="#digitalCommon.modelNumber" />
							</td>
							<td>
								定价：<s:property value="#digitalCommon.publishedPrice" />
							</td>
							<td>
								折扣：<s:property value="#digitalCommon.discount" />
							</td>
                          <td>
								特价:<s:property value="#digitalCommon.salePrice" />
							</td>							

						</tr>
					</s:iterator>
				</table>
			</s:if>

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    </td>
  </tr>
</table>
<div align="center"></div>
</body>
</html>
