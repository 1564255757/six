function login_out(){
	$.ajax({
		url:"index/corporate/login_out.do",
		type:"post",
		dataType:"json",
		success:function(){
			window.location.reload();
		}
	})
}
window.onload=function(){
	get_time();
}
setInterval("get_time()",1000);
function get_time() 
{ 
var date=new Date(); 
var year="",month="",day="",week="",hour="",minute="",second=""; 
year=date.getFullYear(); 
month=add_zero(date.getMonth()+1); 
day=add_zero(date.getDate()); 
week=date.getDay(); 
switch (date.getDay()) { 
case 0:val="星期天";break 
case 1:val="星期一";break 
case 2:val="星期二";break 
case 3:val="星期三";break 
case 4:val="星期四";break 
case 5:val="星期五";break 
case 6:val="星期六";break 
} 
hour=add_zero(date.getHours()); 
minute=add_zero(date.getMinutes()); 
second=add_zero(date.getSeconds()); 
document.getElementById("top1000_number").innerText="欢迎访问辽宁省出口基地信息平台  "+year+"年"+month+"月"+day+"日"+val+"  "+hour+":"+minute+":"+second; 
}  
function add_zero(temp) 
{ 
	if(temp<10) return "0"+temp; 
	else return temp; 
} 