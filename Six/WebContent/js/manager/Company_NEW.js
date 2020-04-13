$(document).ready(function() {
	var location = (window.location + '').split('/');
	var basePath = location[0] + '//' + location[2] + '/' + location[3];

	$.ajax({
		url:basePath+"/manager/corporate/sh.do",
		type:"post",
		data:"",
		dataType:"json",
		success:company_New
		
	})
})
function company_New(result){
	var company=eval(result);
	var str="<ul>";
	for(var i=0;i<company.length;i++){
	   str+="<li>";
	   str+="<span id='body3_text_policy_con'><a href='jsp/manager/company/Company_SH.jsp?id="+company[i].corporate_id+"'>"+company[i].corporate_name+"</a></span>";
	   str+="<span id='body3_text_policy_date'>"+company[i].corporate_apply_time_toString+"</span>";
	str+="</li>";
	}
  str+="</ul>";
 $("#body3_text_policy").append(str);
}
