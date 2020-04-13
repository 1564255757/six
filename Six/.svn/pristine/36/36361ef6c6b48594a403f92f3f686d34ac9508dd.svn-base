$(document).ready(function() {
	
/*	$.ajax({
		url : "manager/notice/selectAll.do",
		type : "post",
		data : "",
		dataType : "json",
		success : M_selectAll
	})*/
	load(1);
})
function load(page){
	$.ajax({
		url : "manager/notice/selectAll.do",
		type : "post",
		data : {page:page},
		dataType : "json",
		success :function(msg){
			selectmore(msg,page);
		}
	})
}
function selectmore(bb,page){
	console.log(bb);
	var notices= bb.list;
	var str="<ul>";
	for(var i =0;i<notices.length;i++){
	  str+="<li><span id='body3_text_policy_con'><a href='jsp/manager/notices/ModifyNotices.jsp?notice_id="+notices[i].notice_id+"'>"+notices[i].notice_title+"</a></span><span id='body3_text_policy_date'>"+notices[i].notice_time_toString+"</span>";
		str+="<span style='float:left; width:90px;'><a href='jsp/manager/notices/ModifyNotices.jsp?notice_id="+notices[i].notice_id+"'><img src='images/manager/edit.jpg' border='0' /></a></span>";
		str+="<span  style='float:left; width:90px'><a href='javascript:void(0)' onclick=\"deletea('"+notices[i].notice_id+"')\"><img src='images/manager/del.jpg' border='0' /></a></span>";
	
	str+="</li>";}
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
/*function M_selectAll(result,page){
	console.log(result);
	var notices = eval(result);
	var str="<ul>";
	for(var i =0;i<result.length;i++){
	str+="<li>";
	str+="<span id='body3_text_policy_con'><a href='jsp/manager/notices/ModifyNotices.jsp?notice_id="+notices[i].notice_id+"'>"+notices[i].notice_title+"</a></span>";
	str+="<span id='body3_text_policy_date'>"+notices[i].notice_time_toString+"</span>";

	str+="</li>";
	}
	str+="</ul>";
	$("#body3_text_policy").append(str);
	

}*/
function deletea(notice_id){
	var tream = confirm("确定要删除吗？");
	if(tream){
		$.ajax({
			url : "manager/notice/delete.do",
			type : "post",
			data : {notice_id:notice_id},
			dataType : "json",
			success : function deletes(result){
				var key = eval(result);
				if(key==0){
					alert("删除失败");
				}else{
					alert("删除成功");
					location.href="jsp/manager/notices/Notices.jsp";
				}
			}
		})
	}
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
