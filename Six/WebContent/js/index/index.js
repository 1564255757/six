$(document).ready(function() {
	
	$.ajax({
		url : "index/notice/select.do",
		type : "post",
		data : "",
		dataType : "json",
		success : show
	})
})
function show(result){
	console.log(result);
	var notices = eval(result);
	var str= "<ul>";
	for(var i =0;i<result.length;i++){
		str+="<li>";
			str+="<div id='bodyup1text_li_img'><img src='images/index/square.jpg' /></div>";
			if(notices[i].notice_title.length>6){
				str+="<div id='bodyup1text_li_text'><a href='jsp/index/notices/NoticesInfo.jsp?notice_id="+notices[i].notice_id+"'>"+notices[i].notice_title.substring(0,6)+"...</a></div>";
			}else{
				str+="<div id='bodyup1text_li_text'><a href='jsp/index/notices/NoticesInfo.jsp?notice_id="+notices[i].notice_id+"'>"+notices[i].notice_title+"</a></div>";
			}
			//str+="<div id='bodyup1text_li_text'><a href='jsp/index/notices/NoticesInfo.jsp?notice_id="+notices[i].notice_id+"'>"+notices[i].notice_title+"</a></div>";
			str+="<div id='bodyup1text_li_data'>"+notices[i].notice_time_toString+"</div>";
		str+="</li>";	
	}
	str+="</ul>";
	$("#bodyup1text").append(str);
}

