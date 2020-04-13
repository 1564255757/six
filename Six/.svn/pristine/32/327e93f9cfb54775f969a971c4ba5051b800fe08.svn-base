
$(function(){
	var base_id=getParam("id");
	$("#base_id").val(base_id);
	$.ajax({ 
		type:"post",
		url: "manager/base/selBaseInfo.do",
		data:{"id":base_id},
		dataType:"json",
		success:parseBaseInfo
	});
	$("#checkAll").click(function(){
		if(this.checked){
			$("input[name='in_company']").prop("checked",true);			
		}else{
			$("input[name='in_company']").prop("checked",false);
		}	
	});
	$("#add").click(function(){
		$("#light").show();
		$("#fade").show();
	});
	$(".closeModify").click(function(){
		$("#light").hide();
		$("#fade").hide();
	});
	$("#del").click(function(){
		var checked=$("input[name='in_company']:checked");
		if(checked.length==0){
			alert("您未选中任何企业");
			return;
		}
		if(confirm("确认删除所选旗下公司吗？")){
			var id=[];
			var str="";
			var val="";
			$("input[name='in_company']:checked").each(function(){	
				val=$(this).val();
				id.push(val);
				str+="<li>"+
						"<input type='checkbox' name='ex_company' value="+val+"><a href='javascript:void(0)'>"+$(this).next().html()+"</a>"+
					 "</li>"
					
			});	
			var flag=delSon(id);
			if(flag){
				$("input[name='in_company']:checked").each(function(){
					$(this).parent().parent().remove();	
				});
				$(".white_content_company ul").append(str);
				alert("删除成功！");
			}else{
				alert("删除失败");
			}
		}	
	});
	$("#submitAdd").click(function(){
		var checked=$("input[name='ex_company']:checked");
		var id=[];
		if(checked.length==0){
			alert("您未选中任何企业");
			return;
		}
		if(confirm("确认添加所选公司吗?")){
			var str="";
			var val="";
			checked.each(function(){
				val=$(this).val();
				id.push(val);
				str+="<tr>"+
					"<td colspan='2'><input type='checkbox' value="+val+" name='in_company'/> <a href='javascript:void(0)' class='factory'>"+$(this).next().html()+"</a></td>"+
				    "</tr>"
						
			});
			var flag=addSon(id);
			if(flag){
				$("input[name='ex_company']:checked").each(function(){
					$(this).parent().remove();
				});
				$(".base_factory tbody").append(str);
				alert("添加成功！");
				$(".closeModify").click();
			}else{
				alert("添加失败");
			}		
		}
	
	});
	var baseNameF=false;
	var cityF=false;
	var profileF=false;
	$("#baseName").blur(function(){
		var baseName=$(this).val();
		 var regu = "^[ ]+$";
	     var re = new RegExp(regu);
		if(baseName==""||re.test(baseName)){
			$(this).next().html("不能为空！");
			baseNameF=false;
		}else if(baseName.length>30){
			$(this).next().html("内容过长！");
			baseNameF=false;
		}else{
			baseNameF=checkName();
		}
	});
	$("#city").change(function(){
		var city=$(this).val();
		if(city=="default"){
			$(this).next().html("请选择一项！");
			cityF=false;
		}else{
			$(this).next().html("");
			cityF=true;
		}
	});
	$("#profile").blur(function(){
		var profile=$(this).val();
		if(profile==""){
			$(this).next().html("不能为空！");
			profileF=false;
		}else{
			$(this).next().html("");
			profileF=true;
		}
	});
	$("#ok").click(function(){
		$("#baseName").blur();
		$("#city").change();
		$("#profile").blur();
		if(baseNameF&&cityF&&profileF){
			submitBase();	
		}
	});
	$("#edit").click(function(){
		$("#down").toggle();
	});
});
function parseBaseInfo(base){
	var city=base.city;
	var son=base.son;
	var no=base.no;
	$("#baseName").val(base.baseInfo.base_name);
	$("#profile").html(base.baseInfo.base_profile);
	var str="";
	for(var i in son){
		str+="<tr>" +
			"<td ><input type='checkbox' value='"+son[i].corporate_id+"' name='in_company' class='cb'/> <a href='javascript:void(0)' class='factory'>"+son[i].corporate_name+"</a></td>" +
			"</tr>";
	}
	$("#son").append(str);
	str="";
	for(var i in no){
		str+="<li><input type='checkbox' name='ex_company' value='"+no[i].corporate_id+"'/> <a href='javascript:void(0)'>"+no[i].corporate_name+"</a></li>";
	}
		$("#no").append(str);
	
	str="";
	for(var i in city){
		if(city[i].city_id==base.baseInfo.base_city){
			str+="<option selected='selected' value='"+city[i].city_id+"'>"+city[i].city_name+"</option>";
		}else{
			str+="<option value='"+city[i].city_id+"'>"+city[i].city_name+"</option>";
		}
	}
	$("#city").append(str);
	
}
function addSon(id){
	var flag="";
	$.ajax({ 
		type:"post",
		data:{"id[]":id,"base_id":$("#base_id").val()},
		url: "manager/base/addBaseSon.do",
		dataType:"json",
		async:false,
		success:function(msg){
			if(msg==1){
				flag=true;
			}else{
				flag=false;
			}
		}
	});
	return flag;
}
function delSon(id){
	var flag="";
	$.ajax({ 
		type:"post",
		data:{"id[]":id},
		url: "manager/base/delBaseSon.do",
		dataType:"json",
		async:false,
		success:function(msg){
			if(msg==1){
				flag=true;
			}else{
				flag=false;
			}
		}
	});
	return flag;
}
function submitBase(){
	$.ajax({ 
		type:"post",
		data:$("#baseForm").serialize(),
		url: "manager/base/updBaseInfo.do",
		dataType:"json",	
		success:function(msg){
			if(msg==1){
				alert("修改成功");
				location.href="jsp/manager/base/ExportBase.jsp";
			}else{
				alert("修改失败，请检查信息");
			}
		}
	});
}
function checkName(){
	var obj=$("#baseName");
	var flag="";
	$.ajax({ 
		type:"post",
		data:{base_name:obj.val(),base_id:$("#base_id").val()},
		url: "manager/base/checkBaseName.do",
		dataType:"json",
		async:false,
		success:function(msg){
			if(msg==1){
				obj.next().html("");
				flag=true;
			}else{
				obj.next().html("名字重复");
				flag=false;
			}
		}
	});
	return flag;
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