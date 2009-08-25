<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'EmailChange.jsp' starting page</title>
    
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
   <!--右栏开始-->
              <div class="main_right">
        	  
	            <div id="div_Input" class="account_message">
		            <div class="modify_email">
			              <ul>
			              <li>　我的E-mail地址：<span id="lab_oldEmail">zhtw1986@163.com</span>
                              <em><span id="oldEmailValidMsg"></span></em>
                          </li>
                          <li>　　我的登录密码：<input name="txt_pass" type="password" id="txt_pass" class="textbox2" />
                              <span id="passValidMsg"></span>
                          </li>
                          <li>我的新E-mail地址：<input name="txt_newEmail" type="text" id="txt_newEmail" class="textbox2" />
                            <span  id="newEmailValidMsg"></span>
                          </li>
                          </ul>
			             <input class="button_ok add_ok" onclick ="btnClientChgEmail_Click()" name="" type="button" value="确 认" />
			             <input onclick="__doPostBack('btn_ok','')" name="btn_ok" type="button" id="btn_ok" style="display: none" />
                                <span id="lblMsg" style="color:Red;"></span>
		            </div>
	            </div>
            
                
              </div>
              <!--右栏结束-->
  </body>
</html>
