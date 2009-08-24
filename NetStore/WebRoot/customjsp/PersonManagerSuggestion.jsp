<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.usc.daos.Custom" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE8 {font-size: 18px}
.STYLE9 {
	font-size: 24px;
	font-weight: bold;
}
.STYLE10 {font-size: 24px}
.STYLE12 {font-size: 14px}
-->
</style>
</head>

<body>
<%@ include file="PersonManagerTop.jsp" %>
<table width="75%" height="422" border="2" align="center">
  <tr>
    <th width="157" height="10" bgcolor="#EEEEEE" scope="row"><div align="left">
        用户名:
        <% Custom custom1 = (Custom)session.getAttribute("Custom");
    out.print(custom.getCustomName());%>

        </div>      <div align="left" class="STYLE12">
        <div align="left">          身 份：
        <%
        if(custom1.getActiveFlag()==0)
        out.print("普通注册用户");
        else out.print("VIP用户");
         %>
        </div>
      </div>    <div align="left" class="STYLE12">
      <div align="left">        积分数：
      <%
        out.print(custom1.getBenefits());
         %>
      </div>
    </div>      
    <div align="left">U币余额：
      <%
        out.print(custom1.getUcurrency());
         %>
    </div></th>
    <td rowspan="8"><%@ include file="UHistory.jsp" %></td>
  
    
    
    
    
  
  <tr bgcolor="#EEEEEE">
    <th height="28" bgcolor="#8AD286" scope="row"><div align="left">
      <p class="STYLE10">我的订单历史&nbsp;
        </p>
    <p>
      </div></th>
  </tr>
  <tr bgcolor="#EEEEEE">
    <th height="71" bgcolor="#8AD286" scope="row"><p align="left"><span class="STYLE10"><strong>修改个人信息</strong></span><hr color="#AACCFF"/>
      <div align="left"><br />
        <span class="STYLE8"><strong>修改密码</strong> <br />
        <strong>修改Email地址</strong> <br />
        <strong>查看收货地址薄</strong></span>
        <p>    
      </div></th>
  </tr>  <tr bgcolor="#EEEEEE">
    <th height="64" bgcolor="#8AD286" scope="row"><p align="left"><span class="STYLE10"><strong>U</strong><strong>币管理</strong></span><hr color="#AACCFF"/>
      <div align="left"><br />
        <span class="STYLE8"><strong>U</strong><strong>币历史</strong> <br />
        <strong>转让U币</strong><strong> </strong></span>
        <p>    
      </div></th>
  </tr>
  <tr bgcolor="#EEEEEE">
    <th height="43" bgcolor="#8AD286" scope="row"><p align="left">
      <div align="left"><span class="STYLE9">积分管理 </span></div>
      <span class="STYLE9"><hr color="#AACCFF"/></span>
      <div align="left"><br />
        <span class="STYLE8"><strong>积分历史</strong> <br />
              <strong>积分换U币</strong> </span></div>
    <p></th>
  </tr>
  <tr bgcolor="#EEEEEE">
    <th height="24" bgcolor="#8AD286" scope="row"><p align="left" class="STYLE10"><strong>暂存架</strong></p></th>
  </tr>
  <tr bgcolor="#EEEEEE">
    <th height="24" bgcolor="#8AD286" scope="row"><p align="left"><span class="STYLE10"><strong>评论</strong></span><br />
    </p></th>
  </tr>
  <tr bgcolor="#EEEEEE">
    <th height="28" bgcolor="#8AD286" scope="row"><div align="left"><span class="STYLE10"><strong>建议</strong></span></div></th>
  </tr>
</table>
</body>
</html>
