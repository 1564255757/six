$(document).ready(function() {
	var notice_id=getParam("notice_id");
	$.ajax({
		url : "index/notice/selectid.do",
		type : "post",
		data : {notice_id:notice_id},
		dataType : "json",
		success : selectid
	})
})
function selectid(aa){
	var notices=eval(aa);
	var str="<span class='heibold18'>"+notices.notice_title+"</span><br/>";
	str+="<span class='heibold14'>&nbsp;&nbsp;&nbsp;&nbsp;"+notices.notice_context+"</span>"
  $("#body3_text_title1").append(str);
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
