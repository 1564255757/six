$(function(){
		loadInfo();
		var companyNameF=false;
		var peopleNameF=false;
		var addressF=false;
		var profileF=false;
		var timeF=false;
		var scopeF=false;
		var phoneF=false;
		$("#upload").click(function(){
			$("input[type='file']").trigger("click");
		});
		$("#companyName").blur(function(){
			var regex=/^[\u4e00-\u9fa5]{0,}$/;
			var companyName=$(this).val();
			if(companyName==""){
				companyNameF=false;
				$(this).next().html("不能为空!!!")
				return;
			}else if(!regex.test(companyName)){
				$(this).next().html("填写中文名字!!!");
				companyNameF=false;
				return;
			}else{
				companyNameF=checkCompanyName();
			}
		});
		$("#peopleName").blur(function(){
			var regex=/^[\u4e00-\u9fa5]{0,}$/;
			var peopleName=$(this).val();
			if(peopleName==""){
				peopleNameF=false;
				$(this).next().html("不能为空!!!")
				return;
			}else if(!regex.test(peopleName)){
				$(this).next().html("填写中文名字!!!");
				peopleNameF=false;
				return;
			}else{
				$(this).next().html("");
				peopleNameF=true;
			}
		});
		$("#scope").change(function(){
			var scope=$(this).val();
			if(scope=='default'){
				$(this).next().html("选择经营范围！");
				scopeF=false;
			}else{
				$(this).next().html("");
				scopeF=true;
			}		
		});
		$("#time").blur(function(){
			var time=$(this).val();
			if(time==''){
				$(this).next().html("选择成立时间！");
				timeF=false;
			}else{
				$(this).next().html("");
				timeF=true;
			}		
		});
		$("#address").blur(function(){
			var address=$(this).val();
			if(address==''){
				$(this).next().html("不能为空！");
				addressF=false;
			}else{
				$(this).next().html("");
				addressF=true;
			}		
		});
		$("#phone").blur(function(){
			var regex=/^0\d{2,3}-\d{7,8}$/;
			var phone=$(this).val();
			var areaNumber=$("#areaNumber").val();
			var tel=areaNumber+"-"+phone;
			if(tel==''){
				$(this).next().html("不能为空！");
				phoneF=false;
			}else if(!regex.test(tel)){
				$(this).next().html("输入正确格式的电话！")
				phoneF=false;
			}else{
				$(this).next().html("");
				phoneF=true;
			}		
		});	
		$("#areaNumber").blur(function(){
			$("#phone").trigger("blur");
		});
		$("#profile").blur(function(){
			var profile=$(this).val();
			if(profile==''){
				$(this).next().html("不能为空！");
				profileF=false;
			}else{
				$(this).next().html("");
				profileF=true;
			}		
		});
		$("#file").change(function(){
			var file=this.files[0];
			var url = null ;
			var imageType = /image\//;
			//是否是图片
			if(!imageType.test(file.type)) {
				alert("请选择图片！");	
				return;
			}
			if (window.createObjectURL!=undefined) { // basic
				url = window.createObjectURL(file) ;
			} else if (window.URL!=undefined) { // mozilla(firefox)
				url = window.URL.createObjectURL(file) ;
			} else if (window.webkitURL!=undefined) { // webkit or chrome
				url = window.webkitURL.createObjectURL(file) ;
			}
			
			$("#show").attr("src",url); 
			updLogo();
		});
		$("#ok").click(function(){
			$("#companyName").blur();
			$("#peopleName").blur();
			$("#scope").change();
			$("#time").blur();
			$("#address").blur();
			$("#phone").blur();
			$("#areaNumber").blur();
			$("#profile").blur();
			if(companyNameF&&peopleNameF&&scopeF&&addressF&&profileF&&timeF){
				updCompany();
			}
		});
});
function updLogo(){
	var file=$("#file")[0].files[0];
	console.log(file);
	var data=new FormData();
	data.append("file",file);
	data.append("corporate_id",$("#corporate_id").val());
	$.ajax({ 
		type:"post",
		url: "index/corporate/updCorporateLogo.do",
		data:data,
		dataType:"json",
		processData: false,  
	    contentType: false,
		success:function(flag){
			if(flag==1){
				alert("修改成功！");
			}else{
				alert("遇到了不可抗拒因素....");
			}
		}
	});
}
function updCompany(){
	var flag=false;
	$.ajax({ 
		type:"post",
		url: "index/corporate/updCorporate.do",
		data:$("#companyForm").serialize(),
		dataType:"json",
		async:false,
		success:function(flag){
			if(flag==1){
				alert("修改成功！");
			}else{
				alert("遇到了不可抗拒因素....");
			}
		}
	});
	return flag;
}
function checkCompanyName(){
	var flag=false;
	$.ajax({ 
		type:"post",
		url: "index/corporate/checkCorporateName.do",
		data:{"id":$("#corporate_id").val(),"name":$("#companyName").val()},
		dataType:"json",
		async:false,
		success:function(msg){
			if(msg==1){
				$("#companyName").next().html("");
				flag=true;
			}else{
				$("#companyName").next().html("名字已被使用！");
			}
		}
	});
	return flag;
}
function loadInfo(){
	$.ajax({ 
		type:"post",
		url: "index/corporate/selCorporateInfo.do",
		dataType:"json",
		success:function(c){
			var obj=c.com;
			var scope=c.scope;
			var tel=obj.corporate_phone;	
			$("#corporate_id").val(obj.corporate_id);
			$("#base").val(obj.base_name);
			$("#companyName").val(obj.corporate_name);
			$("#peopleName").val(obj.corporate_legal_person);
			$("#time").val(obj.corporate_time_toString);
			$("#address").val(obj.corporate_address);
			$("#areaNumber").val(tel.substring(0,tel.indexOf("-")));
			$("#phone").val(tel.substring(tel.indexOf("-")+1,tel.length));
			$("#profile").val(obj.corporate_textarea);
			$("#show").attr('src',obj.corporate_logo_path+"/"+obj.corporate_logo_name);
			var str="";
			for(var i in scope){
				if(scope[i].scope_id==obj.corporate_scope){
					str+="<option selected='selected' value='"+scope[i].scope_id+"'>"+scope[i].scope_name+"</option>";
				}else{
					str+="<option value='"+scope[i].scope_id+"'>"+scope[i].scope_name+"</option>";
				}		
			}
			$("#scope").append(str);
		}
	});
}