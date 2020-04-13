$(document).ready(function(){
	var location =(window.location + '').split('/');
	var basePath=location[0]+'//' +location[2]+'/'+ location[3];
	var page=$("#page").val();
	selectCompany(page);
	randomPage();
	
	$("#selectpage").change(function(){
		var page=$("#selectpage").val();
		if(page=='请选择'){
			alert("请重新选择");
		}else{
		selectCompany(page);
		}
		
	});
	
});

function selectCompany(page){
	var location =(window.location + '').split('/');
	var basePath=location[0]+'//' +location[2]+'/'+ location[3];

	//后台出口基地查询	
	
	$.ajax({
		
		url : basePath+"/manager/corporate/Manager_Select_Base.do",
		type:"post",
		data:{"page":page},
		async:false,
		dataType:"json",
		error:function(rs){
			alert("查询失败");
		},
		success:Manager_Select_Base
	})
	
}

//后台出口基地select
function Manager_Select_Base(rs){
	
	var corporate=rs.list;
	var currpage=rs.currpage;
	var stateNum=0;
	var countPage=rs.countPage;
	document.getElementById("page").value=currpage;
	document.getElementById("cpage").value=countPage;
//	var str=" <ul>";
//	 for(var i=0;i<notice.length;i++){
//	    str+="<li>";
//	    str+="<span id='body3_text_policy_con'><a href='3Notices.jsp?nid="+notice[i].nid+"'>"+notice[i].title+"</a></span>";
//		str+="<span id='body3_text_policy_date'>"+notice[i].ndateToString+"</span>";
//		str+="<span style='float:left; width:90px;'><a href='4Notices.jsp'><img src=";
//		str+="'"+basePath+"/images/manager/edit.jpg' border='0' /></a></span>";
//		str+="<span style='float:left; width:90px'><a href='2Notices.jsp' onclick=del('"+notice[i].nid+"')>";
//		str+="<img src='"+basePath+"/images/manager/del.jpg' border='0'>"+"</a></span>";
//	    			str+="</li>";
//	 }
//	    			str+="</ul>";

	var corporate_id=JSON.stringify(corporate);
	var str="<ul>";
	for(var i=0;i<corporate.length;i++){
		str+="<li>";
		str+="<span id='body3_text_policy_con'><a href='jsp/manager/company/ModifyCompany.jsp?corporate_id="+corporate[i].corporate_id+"'>"+corporate[i].corporate_name+"</a></span>";
		str+="<span id='body3_text_policy_date'>"+corporate[i].corporate_time_toString+"</span>";
		str+="<span style='float:left; width:90px;'><a href='jsp/manager/company/ModifyCompany.jsp?corporate_id="+corporate[i].corporate_id+"'><img src='images/manager/edit.jpg' border='0'/></a></span>";
		str+="<span style='float:left; width:90px;'><a href='jsp/manager/company/Company.jsp' onclick='del(\""+corporate[i].corporate_id+"\")'><img src='images/manager/del.jpg' border='0' /></a></span>";
		str+="</li>";
		}
	str+="</ul>";
		$("#body3_text_policy").html(str);
		state();
}

function state(){
	var location =(window.location + '').split('/');
	var basePath=location[0]+'//' +location[2]+'/'+ location[3];
	//后台出口基地查询未审核企业，范围数量
	$.ajax({
		
		url : basePath+"/manager/corporate/selectByCorporatenoAmount.do",
		type:"post",
		data:"",
		async:false,
		dataType:"json",
		error:function(rs){
			alert("失败");
		},
		success:function(rs){
			var location =(window.location + '').split('/');
			var basePath=location[0]+'//' +location[2]+'/'+ location[3];
			var s=eval(rs);
			stateNum=s.length;
			document.getElementById("state").value=rs;
		}
	});
}

function randomPage(){
	
	var countPage=document.getElementById("cpage").value;
	var str="";
	for(var i=1;i<=countPage;i++){
		str+="<option value='"+i+"'>"+i+"</option>";
	}
	$("#selectpage").append(str);
	
}

function randomPage1(page){
	
	document.getElementById("selectpage").value=page;
}

function lastPage(){
	var cpage=document.getElementById("cpage").value;
	var page=document.getElementById("page").value=cpage;
	selectCompany(page);
	randomPage1(page);
}

function firstPage(){
	var page=document.getElementById("page").value=1;
	selectCompany(page);
	randomPage1(page);
}

function upPage(){
	var page=parseInt($("#page").val())-1;
	if(page<=0){
		alert("这是第一页");
		return;
	}
	selectCompany(page);
	randomPage1(page);
	
}

function nextPage(){
	var page=parseInt($("#page").val())+1;
	var cpage=$("#cpage").val();
	if(page>cpage){
		alert("最后一页");
		return;
	}else{
		selectCompany(page);
		randomPage1(page);
	}
	
}

//后台出口基地删除
function del(corporate_id){
	var location =(window.location + '').split('/');
	var basePath=location[0]+'//' +location[2]+'/'+ location[3];
	if(confirm("确定删除吗？")){
		//后台删除	
		//var corporate_id=getParam("corporate_id");
			$.ajax({
			url : basePath+"/manager/corporate/Manager_Delete_Base.do",
			type:"post",
			data:{"corporate_id":corporate_id},
			async:false,
			dataType:"json",
			success:Manager_Delete_Base
		})
	}
	
}


//后台出口基地删除
function Manager_Delete_Base(rs){
//var i=eval(rs);
//if(i>0){
//alert("删除成功");
//}else{
//	alert("删除失败");
//}
}
//
////后台出口基地编辑前select
//function upa(corporate_id){
//	var location =(window.location + '').split('/');
//	var basePath=location[0]+'//' +location[2]+'/'+ location[3];
//		//后台编辑前select	
//			$.ajax({
//			url : basePath+"/manager/corporate/manager_SelectTarget_Company.do",
//			type:"post",
//			data:{"corporate_id":corporate_id},
//			async:false,
//			dataType:"json",
//			success:manager_SelectTarget_Company
//		})
//	
//}


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


