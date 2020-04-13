$(document).ready(function(){
	var base_id = getParam("base_id");
	//console.log(base_id);
		$.ajax({
			url:"index/base/select.do",
			type:"post",
			data:{base_id:base_id},
			dataType:"json",
			success:showBase
		})
		$.ajax({
			url:"index/corporate/selectGG.do",
			type:"post",
			data:{base_id:base_id},
			dataType:"json",
			success:showCorporate
		})
})

function showCorporate(result){
	var corporate = eval(result);
	//console.log(result);
	var str = "<ul>";
	for(var i=0;i<corporate.length;i++){
	 str+="<li><a href='jsp/index/company/CompanyInfo.jsp?id="+corporate[i].corporate_id+"'><div id='body3_text_text2_li_img'><img src='"+corporate[i].corporate_logo_path+"/"+corporate[i].corporate_logo_name+"' /></div><div  id='body3_text_text2_li_text'><span class='14boldblack'>"+corporate[i].corporate_name+"</span></div></a></li>";
	 
	}
	 str+="</ul>";
	 $("#body3_text_text2").append(str);
}


function showBase (result){
	//console.log(result);
	var base = eval(result);
	var str = "<div id='body3_text_title1'><span class='heibold18'>"+base.base_name+"</span></div>";
	str+="<div id='body3_text_text1'><span class='heibold14'>"+base.base_profile+"</span></div>";
    $("#body3_text").append(str);
}
/**
 * 从URL里解析出传过来的值
 * 
 * @param paramName
 * @return
 */
function getParam(base_id) {
	paramValue = "";
	isFound = false;
	if (this.location.search.indexOf("?") == 0
			&& this.location.search.indexOf("=") > 1) {
		arrSource = unescape(this.location.search).substring(1,
				this.location.search.length).split("&");
		i = 0;
		while (i < arrSource.length && !isFound) {
			if (arrSource[i].indexOf("=") > 0) {
				if (arrSource[i].split("=")[0].toLowerCase() == base_id
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
