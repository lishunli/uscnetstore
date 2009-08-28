<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
    List list = new ArrayList();
    list.add("Max");
    list.add("Scott");
    list.add("Jeffry");
    list.add("Joe");
    list.add("Kelvin");
    request.setAttribute("names", list);
%>
<html>
    <head>
        <title>Iterator</title>
    </head>
    <body>
        <h3>Names: </h3>
        <!-- 
            1、此处的空property元素用于获得当前iterator的值 
            2、status被设成stuts，在iterator的里面就可以通过#stuts取得IteratorStatus的对象。IteratorStatus类包含当前序号信息，如是否第一个或最后一个，是否为奇数序号。这些信息在我们做格式化的时候，显得非常有用。
        -->
        <ol>
            <s:iterator value="#request.names" status="stuts">                
                <s:if test="#stuts.odd == true">
                    <li>White <s:property /></li>
                </s:if>
                <s:else>
                    <li style="background-color:gray"><s:property /></li>
                </s:else>
            </s:iterator>
        </ol>
    </body>
</html>