////产品发布
//function  publishe(entityID,type) {
//	var discount = prompt("请输入折扣 (1-100)","100");  
//	var re = /^[1-9]\d*\d$/;   //判断字符串是否为数字/^[0-9]+.?[0-9]*$/     //判断正整数 /^[1-9]+[0-9]*]*$/  
//	if(null == discount || discount < 1 || discount!=parseInt(discount) || discount>100 )
//	{
//		alert("折扣没有输入或者输入错误，请输入1-100 之间的正整数");
//	}
//	else
//	{
//		window.self.location = "publishe.action?entityID="+entityID+"&type="+type+"&discount="+discount;	
//	}
//}


//修改折扣
function mergeDiscount(entityID,type) {
	var discount = prompt("请输入修改的折扣 (1-100)", "100");
	var re = /^[1-9]\d*\d$/; // 判断字符串是否为数字/^[0-9]+.?[0-9]*$/ //判断正整数
								// /^[1-9]+[0-9]*]*$/
	if (null == discount) {
	} else if (discount < 1 || discount != parseInt(discount) || discount > 100) {
		alert("折扣输入错误，请输入1-100 之间的正整数");
	} else {
		window.self.location = "updateDiscount.action?entityID=" + entityID
				+ "&type=" + type + "&discount=" + discount;
	}
}

//撤销发布


//设为促销