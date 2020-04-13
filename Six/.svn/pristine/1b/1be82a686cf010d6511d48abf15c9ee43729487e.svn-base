$(function(){
	loadCities();
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
		 var regu = "^[ ]+$";
	     var re = new RegExp(regu);
		var profile=$(this).val();
		if(profile==""||re.test(baseName)){
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
});

function submitBase(){
	$.ajax({ 
		type:"post",
		data:$("#baseForm").serialize(),
		url: "manager/base/addBase.do",
		dataType:"json",	
		success:function(msg){
			if(msg==1){
				alert("添加成功");
				location.href="jsp/manager/base/ExportBase.jsp";
			}else{
				alert("添加失败，请检查信息");
			}
		}
	});
}
function checkName(){
	var obj=$("#baseName");
	var flag="";
	$.ajax({ 
		type:"post",
		data:{base_name:obj.val()},
		url: "manager/base/checkAddBaseName.do",
		dataType:"json",
		async:false,
		success:function(msg){
			if(msg==0){
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
function loadCities(){
	$.ajax({ 
		type:"post",
		url: "manager/base/selAllCity.do",
		dataType:"json",	
		success:function(msg){
			var str="";
			for(var i in msg){
				str+="<option value='"+msg[i].city_id+"'>"+msg[i].city_name+"</option>";
			}
			$("#city").append(str);
		}
	});
}