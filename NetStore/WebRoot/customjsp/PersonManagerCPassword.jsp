<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改密码</title>
  </head>
  
  <body bgcolor="#EEEEEE">
         <!--右栏开始-->
         <form name="form1" method="post" action="passwordchange.action" id="form1">
          <div id="div_Input" class="main_right">
	        <div class="account_message">
	            <h3>修改密码</h3>
	            <div class="modify_email reduce_modify_w">
		             <ul>
		              <li>原有密码：&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;  <input name="txt_oldPass" type="password" id="txt_oldPass" class="textbox2" /><span id="txtOldPassValidMsg"></span></li>
		              <li>您想要的新密码：&nbsp; <input name="txt_newPass" type="password" id="txt_newPass" class="textbox2" /><span id="txtNewPassValidMsg"></span><span class="c_gray"> 密码可由大小写英文字母、数字组成，长度6－12位。</span></li>
		              <li>请再次输入新密码：<input name="txt_PassRepeat" type="password" id="txt_PassRepeat" class="textbox2" /><span id="txtPassRepeatValidMsg"></span></li>
		             </ul>
		             <input class="button_ok add_ok" name="" type="button" value="确 认" onclick="btnClientChgPass_Click()" />
		             <input onclick="__doPostBack('btn_ok','')" name="btn_ok" type="button" id="btn_ok" style="display:none" />
                        <em><span id="lblMsg" style="color:Red;"></span></em>
	            </div>
	            <input type="hidden" name="Hid_Email" id="Hid_Email" value="zhtw1986@163.com" />
            </div>
          </div>
          <!--右栏结束-->
          <!--右栏开始修改成功-->
	      
	      <!--右栏结束-->
            <div class="empty_box"></div>
      
        </form>
  </body>
</html>
