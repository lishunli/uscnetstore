<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>高级搜索.图书</title>
  </head>  
  <body>
   <%@ include file="../Top.jsp"%>
    <form name='AdvancedSsarch.action' id='form_send0' method='GET' action='http://search.book.dangdang.com/search.aspx' onsubmit='return advsearchbook(0);'>
    <div class="hsearch_body_cont">
    	<div class="hsearch_body_cont_text">书　名：</div>
    	<input type="text" name="key1"  />
    </div><div class="clear"></div>
    <div class="hsearch_body_cont">
      <div class="hsearch_body_cont_text">著译者：</div>
      <input type="text" name="key2"  />
    </div><div class="clear"></div>
    <div class="hsearch_body_cont">
      <div class="hsearch_body_cont_text">出版社：</div>
      <input type="text" name="key3"  />
    </div><div class="clear"></div>
    <div class="hsearch_body_cont">
      <div class="hsearch_body_cont_text">ISBN：</div>
      <input type="text" name="key"/>
    </div><div class="clear"></div>
    <div class="hsearch_body_cont">
 
    <div class="clear"></div>
    <div class="hsearch_body_cont">
      <div class="hsearch_body_cont_text">网站价格：</div>
      <input type="text" name="minprice" class="hsearch_body_cont_input2" />
      至 
      <input type="text" name="maxprice" class="hsearch_body_cont_input2" />
    </div>
    <div class="clear"></div>
    <div class="hsearch_body_cont">
      <div class="hsearch_body_cont_text">出版时间：</div>
      <input type="text" name="sy"  class="hsearch_body_cont_input2" /> 年 
      <input type="text" name="sm"  class="hsearch_body_cont_input3" /> 月 
      <input type="text" name="sd"  class="hsearch_body_cont_input3" /> 日 - 
      <input type="text" name="ey"  class="hsearch_body_cont_input2" /> 年 
      <input type="text" name="em"  class="hsearch_body_cont_input3" /> 月 
      <input type="text" name="ed"  class="hsearch_body_cont_input3" /> 日 
    </div>
    <div class="clear"></div>
    <div class="hsearch_body_cont">
      <div class="hsearch_body_cont_text">上架时间：</div>
      <select name="laststock" class="hsearch_body_cont_input">
                        <option selected value='lall'>所有时间范围</option>
                        <option value='l3'>近3天</option>
                        <option value='l10'>近10天</option>
                        <option value='l30'>近30天</option>
                        <option value='m30'>大于30天</option>
      </select>
    </div>
    <div id="__book_search" class="hsearch_body_cont1">
    <input type="button" value="搜 索"  onclick="checkSearchSubmit(0);return false;" class="hsearch_body_button" />
      <input name="input2"  type="reset" value="重新填写" class="hsearch_body_button"/>
    </div>
    <input type="hidden" name="catalog"  value="01.00.00.00"/>
    <input type="hidden" name="key4" />
	<input type="hidden" name="begin_date" value=""/>	
	<input type="hidden" name="end_date" value=""/>	
    </form>
  </body>
</html>
