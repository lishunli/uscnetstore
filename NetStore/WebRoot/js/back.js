var XMLHttpReq,no;                                                             //创建XMLHttpRequest对象
onload = setUp;  
function createXMLHttpRequest()
  {
  	if(window.XMLHttpRequest)
  	{                               
  		//Mozilla浏览器
        XMLHttpReq = new XMLHttpRequest();
    }else if(window.ActiveXObject)
    {                           
    	//IE浏览器
        try
        {
            XMLHttpReq = new ActiveXObject( "Msxm12.XMLHTTP" );
        }catch(e)
        {
            try
            {
               XMLHttpReq = new ActiveXObject( "Microsoft.XMLHTTP" );
            }catch(e)
            {}
         }
      }
  }  
//发送Ajax请求
  function sendAjaxRequest(url)
  {
     createXMLHttpRequest();                         //创建XMLHttpRequest对象
     XMLHttpReq.open("post",url,false);
     XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
     XMLHttpReq.send(null);
  }
//回调函数processResponse
  function processResponse()
  {
      if(XMLHttpReq.readyState == 4)
      {
      	 if(XMLHttpReq.status == 200)
      	 {
      		 
            var types = XMLHttpReq.responseXML.getElementsByTagName("Type");
            
            var fType = document.getElementById("fType");
            var sType = document.getElementById("sType");
            var tType = document.getElementById("tType");
            var frType = document.getElementById("frType");
            
//            var city = document.getElementById("city");
//            var town =document.getElementById("town");
            if(fType.value == "")
            {
            	sType.options.length = 0;
            	tType.options.length = 0;
                addOption(fType,types);
            }
            else if(no == 1 && fType.value == 0)
            {
            	sType.options.length = 0;
            	tType.options.length = 0;
            	frType.options.length = 0;
            }
            else if((no == 1 && fType.value != 0) || sType.value == "")
            {
            	sType.options.length = 0;
            	tType.options.length = 0;
            	frType.options.length = 0;
            	addOption(sType,types);
            }
            else if(no == 2 && sType.value == 0)
            {
            	tType.options.length = 0;
            	frType.options.length = 0;
            }
            else if((no == 2 && sType.value != 0) || tType.value == "")
            {
            	tType.options.length = 0;
            	frType.options.length = 0;
            	addOption(tType,types);
            }
            else if(no == 3 && tType.value == 0)
            {
            	frType.options.length = 0;
            }
            else if((no == 3 && tType.value != 0) || frType.value == "")
            {
            	frType.options.length = 0;
            	addOption(frType,types);
            }
         }else
         {    
         	  //响应未交互成功时，页面中的代码
              // "正在加载数据......"
         }
     }else
     {                                                  
     	//响应未加载成功时，页面中的代码
        // "正在验证用户名......"
     }
  }
  
  function addOption(selectObject,types)
  {
 	 for( var i = 0; i < types.length; i=i+1 ) 
 	 {
	     var typeI = types[i];
	     var typeID = typeI.getElementsByTagName( "TypeID" ).item(0).firstChild.nodeValue;
	     var typeName = typeI.getElementsByTagName( "TypeName" ).item(0).firstChild.nodeValue;
	     if(i == 0)
	     {
	    	 selectObject.add(new Option("请选择",0));
		     selectObject.add(new Option(typeName,typeID));
	     }else
	     {
	    	 selectObject.add(new Option(typeName,typeID));
	     }	      
	 }
  }
  
function getFType(num) {
	no = num;
	var fType = document.getElementById("fType").value;
	var url = "getAllType?FTypeID="+fType;
	sendAjaxRequest(url);
}
function getSType(num) 
{
	no = num;
	var sType = document.getElementById("sType").value;
	var url = "getAllType?FTypeID="+sType;
	sendAjaxRequest(url);
}

function gettType(num) 
{
	no = num;
	var tType = document.getElementById("tType").value;
	var url = "getAllType?FTypeID="+tType;
	sendAjaxRequest(url);
}

function setUp()
{
	getFType(1);
}  




