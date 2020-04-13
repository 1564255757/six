$(function(){
	
	loadScope();
	loadCities();
	loadCompany(1);
	$(".choose_city").on('click','#cc',function(){
		var choose_city_name=$(this).html();	
		var choose_city_id=$(this).attr("value");	
		$("#result_city").html(choose_city_name);
		$("#city_id").html(choose_city_id);
		loadCompany(1);
	});
	$(".choose_scope").on('click','#ss',function(){
		var choose_scope_name=$(this).html();	
		var choose_scope_id=$(this).attr("value");
		$("#result_scope").html(choose_scope_name);
		$("#scope_id").html(choose_scope_id);
		loadCompany(1);
	});
	$("#body3_text_suoyin a").click(function(){
		$(this).html("");
		var id=$(this).attr("id");
		if(id=="result_city"){
			$("#city_id").html("");
		}else{
			$("#scope_id").html("");
		}	
		loadCompany(1);
	});
	$("#clickOrder").click(function(){
		var className=$("#clickOrder i").attr("class");
		var newClass="";
		switch (className){
			case "clickOrder":
			newClass="clickUp"
			break;
			case "clickUp":
			newClass="clickDown"
			break;
			case "clickDown":
			newClass="clickUp"
			break;
		}
		$("#clickOrder i").attr("class",newClass);
		loadCompany(1);
	});
	$("#defaultOrder").click(function(){
		$("#clickOrder i").attr("class","clickOrder");
		loadCompany(1);
	});
	$("#cityMore").click(function(){
		$(".hide_city_div").toggle();
	});
	$("#scopeMore").click(function(){
		$(".hide_scope_div").toggle();
	});
});

function loadCompany(page){
	var data = new FormData();
	var className=$("#clickOrder i").attr("class");
	var city=$("#city_id").html();
	var scope=$("#scope_id").html();
	var click="";
	switch (className){
		case "clickUp":
		click=1
		break;
		case "clickDown":
		click=2
		break;
		
		default:
		click=0
		break;	
	}
	if(city!=""){
		data.append("city",city);
	}
	if(scope!=""){
		data.append("scope",scope);
	}
	data.append("click",click);
	data.append("page",page);
	$.ajax({ 
		type:"post",
		data:data,
		url: "index/corporate/allCorporate.do",
		dataType:"json",
		cache: false,  
        processData: false,  
        contentType: false,
		success:function(result){
			parseCompany(result,page);
		}
	});
	
}
function loadScope(){
	$.ajax({ 
		type:"post",
		url: "index/scope/allScope.do",
		dataType:"json",
		success:parseScope
	});
}
function loadCities(){
	$.ajax({ 
		type:"post",
		url: "index/cities/allCities.do",
		dataType:"json",
		success:parseCities
	});
}
function parseCompany(com,page){
	page=parseInt(page);
	var str="";
	var list=com.list;
	for(var i in list){
		str+="<li>" +
		 "<span style='border:1px #666666 solid; float:left;'>" +
		 "<a href='javascript:void(0)'><img width='218' height='150' src='"+list[i].corporate_logo_path+"/"+list[i].corporate_logo_name+"' border='0' /></a>" +
		 "</span>" +
		 "<span class='14boldblacklinks' style='float:left; text-align:center; width:220px; height:50px; line-height:50px;'>" +
		 "<a href='jsp/index/company/CompanyInfo.jsp?id="+list[i].corporate_id+"'>"+list[i].corporate_name+"</a>" +
		 "</span></li>";		 
	}
	$("#allCompany").html(str);
	var total=parseInt(com.total);
	var totalPage=0;
	if(total%12==0){
		totalPage=parseInt(total/12);
	}else{
		totalPage=parseInt(total/12)+1;
	}
	var last="";
	var next="";
	var index="<a href='javascript:void(0)' onclick='loadCompany(1)'>首页</a>";
	var end="<a href='javascript:void(0)' onclick='loadCompany("+totalPage+")'>尾页</a>";
	var select="<select name='select' onchange='loadCompany(this.value)'>";
	if(page-1>0){
		last="<a href='javascript:void(0)' onclick='loadCompany("+(page-1)+")'>上一页</a>";
	}else{
		last="<a href='javascript:void(0)'>上一页</a>";
	}
	if(page+1>totalPage){
		next="<a href='javascript:void(0)'>下一页</a>";
	}else{
		next="<a href='javascript:void(0)' onclick='loadCompany("+(page+1)+")'>下一页</a>";
	}
	for(var i=1;i<=totalPage; i++){
		if(i==page){
			select+="<option selected value='"+i+"'>"+i+"</option>";
		}else{
			select+="<option value='"+i+"'>"+i+"</option>";
		}
	 }
	select+="</select>页";
	$("#body3_text_policy_page").html(index+last+page+next+select);	        	   

}
function parseScope(scope){
	  var show="";
	  var hide="";
	  for(var i in scope){	   	  
		if(i>8){
			  hide+="<li id='ss' value='"+scope[i].scope_id+"'><a href='javascript:void(0)'>"+scope[i].scope_name+"</a></li>";
		  }else{
			  show+="<li id='ss' value='"+scope[i].scope_id+"'><a href='javascript:void(0)'>"+scope[i].scope_name+"</a></li>";
		  }
	}   
$("#show_scope").append(show);
$("#hide_scope").append(hide);
}
function parseCities(cities){
	  var show="";
	  var hide="";
	  for(var i in cities){
		  if(i>8){
			 hide+="<li id='cc' value='"+cities[i].city_id+"'><a href='javascript:void(0)'>"+cities[i].city_name+"</a></li>";
		  }else{
			 show+="<li id='cc' value='"+cities[i].city_id+"'><a href='javascript:void(0)'>"+cities[i].city_name+"</a></li>";
		  }
	  }   
$("#show_city").append(show);
$("#hide_city").append(hide);
}