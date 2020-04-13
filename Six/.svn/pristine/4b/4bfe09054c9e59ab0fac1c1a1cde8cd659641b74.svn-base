$(document).ready(function() {
	load(1);
	
})



function load(page){
	$.ajax({
		url : "index/notice/selectAll.do",
		type : "post",
		data : {page:page},
		dataType : "json",
		success :function(msg){
			selectmore(msg,page);
		}
	})
	
}

function selectmore(bb,page){
	var notices= bb.list;
	var str="<ul>";
	for(var i =0;i<notices.length;i++){
	  str+="<li><span id='body3_text_policy_con'><a href='jsp/index/notices/NoticesInfo.jsp?notice_id="+notices[i].notice_id+"'>"+notices[i].notice_title+"</a></span><span id='body3_text_policy_date'>"+notices[i].notice_time_toString+"</span></li>";
	}
	str+="</ul>";
	var total=parseInt(bb.total);
	var up=parseInt(page)-1;
	var down=parseInt(page)+1;
	var last="";
	var next="";
	if(up==0){
		last="<a href='javascript:void(0)'>上一页</a>";
	}else{
		last="<a href='javascript:void(0)' onclick='load("+up+")' >上一页</a>";
	}
	if(down>total){
		next="<a href='javascript:void(0)'>下一页</a>";
	}else{
		next="<a href='javascript:void(0)' onclick='load("+down+")' >下一页</a>";
	}
	var index="<a href='javascript:void(0)' onclick='load(1)'>首页</a>";
	var lastest="<a href='javascript:void(0)' onclick='load("+total+")'>尾页</a>";
	var number="<select name='select' onchange='load(this.value)'>";
	for(var i=1;i<=total;i++){
		if(i==page){
			number+="<option value='"+i+"' selected='selected'>"+i+"</option>";
		}else{
			number+="<option value='"+i+"'>"+i+"</option>";
		}	
	}
    number+="</select>页 ";
    
	$("#body3_text_policy").html(str);
	$("#body3_text_policy_page").html(index+last+page+next+lastest+number);
}
/**
* 从URL里解析出传过来的值
* 
* @param paramName
* @return
*/
function getParam(paramName) {
	paramValue = "";
	isFound = false;
	if (this.location.search.indexOf("?") == 0
			&& this.location.search.indexOf("=") > 1) {
		arrSource = unescape(this.location.search).substring(1,
				this.location.search.length).split("&");
		i = 0;
		while (i < arrSource.length && !isFound) {
			if (arrSource[i].indexOf("=") > 0) {
				if (arrSource[i].split("=")[0].toLowerCase() == paramName
						.toLowerCase()) {
					paramValue = arrSource[i].split("=")[1];
					isFound = true;
				}
			}
			i++;
		}
	}
	return paramValue;
}