//function typeChange() {
//	var type = document.getElementById("type");
//	if(type.value ==  "图书")
//	{
//		$("#digital").css("visibility","hidden");
//		$("#book").css("visibility","visible");
//	}
//	else if(type.value == "数码")
//	{
//		$("#digital").css("visibility","visible");
//		$("#book").css("visibility","hidden");
//	}
//	
//}

//function backSerach() {
//	alert("hello");
//	window.self.location = "backSerach.action"	
//}

function  publishe(bookId) {
//	alert("hello"+document.getElementById("discount").value);
//	alert(bookName);
//	 document.getElementById("discount").value  = 
	var discount = prompt("请输入折扣 (1-100)","100");  
	var re = /^[1-9]\d*\d$/;   //判断字符串是否为数字/^[0-9]+.?[0-9]*$/     //判断正整数 /^[1-9]+[0-9]*]*$/  
	if(null == discount || discount < 1 || discount!=parseInt(discount) || discount>100 )
	{
		alert("折扣没有输入或者输入错误，请输入1-100 之间的正整数");
	}
	else
	{
		window.self.location = "publishe.action?bookId="+bookId+"&type=1&discount="+discount;	
	}
}
