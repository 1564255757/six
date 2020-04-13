$(function(){
	loadBase(1);
	$("#body3_text_policy").on("click","#del",function(){
		var id=$(this).prev().val();
		if(del(id)){
			alert("删除成功！");
			location.href="jsp/manager/base/ExportBase.jsp";
		}else{
			alert("删除失败！");
		}
	});
})

function loadBase(page){
		$.ajax({ 
			type:"post",
			url: "manager/base/selAllBase.do",
			data:{page:page},
			dataType:"json",
			success:function(base){
				parseBase(base,page)
			}
		});
}


function parseBase(base,page){
	page=parseInt(page);
	var str="";
	var list=base.list;
	var str="<ul>";
    for(var i in list){
		str+="<li>"+
		"<span id='body3_text_policy_con'><a href='jsp/manager/base/ModifyExport.jsp?id="+list[i].base_id+"'>"+list[i].base_name+"</a></span>"+
		"<span style='float:left; width:90px;'><a href='jsp/manager/base/ModifyExport.jsp?id="+list[i].base_id+"'><img src='images/manager/edit.jpg' border='0' /></a></span>"+
		"<span style='float:left; width:90px'><input type='hidden' value='"+list[i].base_id+"'><a id='del' href='javascript:void(0)'><img src='images/manager/del.jpg' border='0' /></a></span>"+
		"</li>";			 
	 }
	str+="</ul>";
	$("#body3_text_policy").html(str);
	var totalPage=parseInt(base.size);
	var last="";
	var next="";
	var index="<a href='javascript:void(0)' onclick='loadBase(1)'>首页</a>";
	var end="<a href='javascript:void(0)' onclick='loadBase("+totalPage+")'>尾页</a>";
	var select="<select name='select' onchange='loadBase(this.value)'>";
	if(page-1>0){
		last="<a href='javascript:void(0)' onclick='loadBase("+(page-1)+")'>上一页</a>";
	}else{
		last="<a href='javascript:void(0)'>上一页</a>";
	}
	if(page+1>totalPage){
		next="<a href='javascript:void(0)'>下一页</a>";
	}else{
		next="<a href='javascript:void(0)' onclick='loadBase("+(page+1)+")'>下一页</a>";
	}
	for(var i=1;i<=totalPage; i++){
		if(i==page){
			select+="<option selected value='"+i+"'>"+i+"</option>";
		}else{
			select+="<option value='"+i+"'>"+i+"</option>";
		}
	 }
	select+="</select>页到";
	$("#body3_text_policy_page").html(index+last+page+next+end+select);	        	   

}

function del(id){
	var flag=false;
	$.ajax({ 
		type:"post",
		url: "manager/base/delBase.do",
		data:{id:id},
		async:false,
		dataType:"json",
		success:function(msg){
			if(msg==1){
				flag=true;
			}
		}
	});
	return flag;
}