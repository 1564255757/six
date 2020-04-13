$(function(){
	$.ajax({ 
		type:"post",
		url: "index/corporate/corporateInfo.do",
		data:{"id":getParam("id")},
		dataType:"json",
		success:parseComany
	});
})
function parseComany(com){
	console.log(com);
	var str="";
	str+="<div id='body3_text_content_pic'><img width='350' height='350' src='"+com.corporate_logo_path+"/"+com.corporate_logo_name+"'/></div>" +
			"<div id='body3_text_content_text'>" +
			"<ul><li>企业名称："+com.corporate_name+"</li>" +
			"<li>企业地址："+com.corporate_address+"</li>" +
			"<li>企业法人："+com.corporate_legal_person+"</li>" +
			"<li>企业电话："+com.corporate_phone+"</li>" +
			"<li>企业的经营范围："+com.scope_name+"</li>";
	
			if(com.base_name==null){
				str+="<li>企业的出口基地：<font color='red'>暂无出口基地</font></li>";
			}else{
				str+="<li>企业的出口基地："+com.base_name+"</li>";
			}
			str+="<li>企业成立时间："+com.corporate_time_toString+"</li>" +
			"<li>企业简介：</li>" +
			"<li><textarea name='field' readonly='readonly' cols='' rows='5' id='field'>"+com.corporate_textarea+"</textarea></li></ul>" +
			"</div>";
	$("#clickAmount").html(com.corporate_click);
	$("#body3_text_content").append(str);
}
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