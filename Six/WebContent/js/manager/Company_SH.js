$(document).ready(function() {
	//接收客户端请求的CID
	var corporate_id=getParam("id");
	$.ajax({
		url : "manager/corporate/xx.do",
		type : "post",
		data : {corporate_id:corporate_id},
		dataType : "json",
		success :showCorporate
	})
})

function pass(state){
	var corporate_id=getParam("id");
	$.ajax({
		url :"manager/corporate/new.do",
		type : "post",
		data : {corporate_id:corporate_id,state:state},
		dataType : "json",
		success :function(msg){
			if(msg==1){
				alert("操作成功！");
				location.href='jsp/manager/company/Company_NEW.jsp';
			}
			
		}
	})
}

function showCorporate(result) {
	var corporate=eval(result);
	var str="<ul>";
		str+="<div id='body3_text_content_pic'><img width='300' height='300' src='upload/images/"+corporate.corporate_logo_name+"'/></div>";
		str+="<div id='body3_text_content_text'>";
	   str+="<li>企业名称："+corporate.corporate_name+"</li>";
	   str+="<li>企业法人："+corporate.corporate_legal_person+"</li>";
	   str+="<li>企业电话："+corporate.corporate_phone+"</li>";
	   str+="<li>企业经营范围："+corporate.scope_name+"</li>";
	   str+="<li>企业出口基地："+corporate.base_name+"</li>";
	   str+="<li>企业成立时间："+corporate.corporate_time_toString+"</li>";
	   str+="<li>企业法人简介：</li>";
	   str+="<li><textarea name='field' readonly='readonly' cols='' rows='5' id='field'>"+corporate.corporate_textarea+"</textarea></li>";
	   
	   str+="<li class='bottom_img'><a href='javascript:void(0)'><img src='images/manager/pass.png' onclick='pass(1)'/></a>&ensp;<img  onclick='pass(2)' style='margin-left:100px;' src='images/manager/no_pass.png' /></li>";
       str+="</div>"	
  str+="</ul>";
 $("#body3_text_content").append(str);

	

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
