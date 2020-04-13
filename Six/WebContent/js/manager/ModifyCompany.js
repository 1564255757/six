$(function(){
	
	//后台出口基地编辑前select
	var location =(window.location + '').split('/');
	var basePath=location[0]+'//' +location[2]+'/'+ location[3];
	var corporate_id=getParam("corporate_id");
	$.ajax({
		
		url : basePath+"/manager/corporate/manager_SelectTarget_Company.do",
		type:"post",
		data:{corporate_id:corporate_id},
		async:false,
		dataType:"json",
		success:manager_SelectTarget_Company
	})
	
	//后台出口基地编辑前select用户名
		$.ajax({
		
		url : basePath+"/manager/corporate/manager_Update_Select_Username.do",
		type:"post",
		data:{corporate_id:corporate_id},
		async:false,
		dataType:"json",
		success:manager_Update_Select_Username
	})
	//后台编辑经营范围select
		$.ajax({
			
			url : basePath+"/index/corporate/Select_Scope.do",
			type:"post",
			data:"",
			async:false,
			dataType:"json",
			success:Select_Scope
		})
		
		//后台编辑出口基地select
		$.ajax({
			
			url : basePath+"/index/base/Select_Base.do",
			type:"post",
			data:"",
			async:false,
			dataType:"json",
			success:Select_Base
		})
	$("#companyAccount").click(function(){
		$("#light").show();
		$("#fade").show();
	});
	$(".closeModify").click(function(){
		$("#light").hide();
		$("#fade").hide();
	});
	$("#submitAccount").click(function(){
		var location =(window.location + '').split('/');
		var basePath=location[0]+'//' +location[2]+'/'+ location[3];
		var un=$("#username").val();
		var pass=$("#password").val();
		var ff=false;
		var gg=false;
		$.ajax({
			
			url : basePath+"/manager/corporate/Company_Username_Repeat.do",
			type:"post",
			data:{"corporate_username":un,"corporate_id":corporate_id},
			async:false,
			dataType:"json",
			success:function(rs){
				if(rs==1){
					ff=true;
				}else if(rs==2){
					ff=true;
				}else if(rs==3){
					ff=false;
				}
			}
		})
		if(un==""){
			alert("账户名不能为空！");
			return;
		}
		if(!ff){
			alert("企业用户名冲突");
			return;
		}
		if(pass==""){
			alert("密码不能为空！");
			return;
		}
		
		//后台用户名密码修改
		
		$.ajax({
			
			url : basePath+"/manager/corporate/manager_Update_Company_Username_password.do",
			type:"post",
			data:{"corporate_username":un,"corporate_password":pass,"corporate_id":corporate_id},
			async:false,
			dataType:"json",
			error:function(reuqest){
				alert("修改用户名密码错误");
			},
			success:function(reuqest){
				alert("修改用户名密码成功");
			}
		
		})
		$("#light").hide();
		$("#fade").hide();
	});
	var now = loadTime();
	var companyNameF = false;
	var peopleNameF = false;
	var scopeF = false;
	var addressF = false;
	var profileF = false;
	var timeF = false;
	var exportBaseF = false;
	$("#upload").click(function() {
		$("input[type='file']").trigger("click");
	});
	$("#companyName").blur(function() {
		var location =(window.location + '').split('/');
		var basePath=location[0]+'//' +location[2]+'/'+ location[3];
		var regex = /^[\u4e00-\u9fa5]{0,}$/;
		var companyName = $(this).val();
		var ff=false;
		$.ajax({
			
			url : basePath+"/manager/corporate/Manager_Update_Company_Name_Repeat.do",
			type:"post",
			data:{"companyName":companyName,"corporate_id":corporate_id},
			async:false,
			dataType:"json",
			success:function(rs){
				if(rs==1){
					ff=true;
				}else if(rs==2){
					ff=true;
				}else if(rs==3){
					ff=false;
				}
			}
		})
		var regu = "^[ ]+$";
	    var re = new RegExp(regu);
		if (companyName == ""||re.test(companyName)) {
			companyNameF = false;
			$(this).next().html("公司名不能为空!!!")
			return;
		} else if (!regex.test(companyName)) {
			$(this).next().html("请填写中文名字!!!");
			companyNameF = false;
			return;
		}else if(!ff){
			$(this).next().html("企业名称冲突");
			companyNameF = false;
			return;
		}else {
			$(this).next().html("");
			companyNameF = true;
		}
	});
	$("#peopleName").blur(function() {
		var regex = /^[\u4e00-\u9fa5]{0,}$/;
		var peopleName = $(this).val();
		if (peopleName == "") {
			peopleNameF = false;
			$(this).next().html("法人名不能为空!!!")
			return;
		} else if (!regex.test(peopleName)) {
			$(this).next().html("请填写中文名字!!!");
			peopleNameF = false;
			return;
		} else {
			$(this).next().html("");
			peopleNameF = true;
		}
	});
	$("#scope").change(function() {
		var scope = $(this).val();
		if (scope == 'default') {
			$(this).next().html("请选择经营范围！");
			scopeF = false;
		} else {
			$(this).next().html("");
			scopeF = true;
		}
	});
	$("#time").blur(function() {
		var time = $(this).val();
		if (time > now || time == "") {
			$(this).next().html("成立时间还没到!");
			timeF = false;
		} else {
			$(this).next().html("");
			timeF = true;
		}
	});
	$("#address").blur(function() {
		var address = $(this).val();
		if (address == '') {
			$(this).next().html("地址不能为空！");
			addressF = false;
		} else {
			$(this).next().html("");
			addressF = true;
		}
	});
	$("#phone").blur(function() {
		var regex = /^0\d{2,3}-\d{7,8}$/;
		var phone = $(this).val();
		if (phone == '') {
			$(this).next().html("电话不能为空！");
			phoneF = false;
		} else if (!regex.test(phone)) {
			$(this).next().html("请输入正确格式的电话！")
			phoneF = false;
		} else {
			$(this).next().html("");
			phoneF = true;
		}
	});
	$("#exportBase").change(function() {
		var exportBase = $(this).val();
		if (exportBase == 'default'||exportBase=='null') {
			$(this).next().html("出口基地选择无效！");
			exportBaseF = false;
		} else {
			$(this).next().html("");
			exportBaseF = true;
		}
	});
	$("#profile").blur(function() {
		var profile = $(this).val();
		if (profile == '') {
			$(this).next().html("公司简介不能为空！");
			profileF = false;
		} else {
			$(this).next().html("");
			profileF = true;
		}
	});
	$("#file").change(function() {
		var file = this.files[0];
		var url = null;
		var imageType = /image\//;
		//是否是图片
		if (!imageType.test(file.type)) {
			alert("请选择图片！");
			return;
		}
		if (window.createObjectURL != undefined) { // basic
			url = window.createObjectURL(file);
		} else if (window.URL != undefined) { // mozilla(firefox)
			url = window.URL.createObjectURL(file);
		} else if (window.webkitURL != undefined) { // webkit or chrome
			url = window.webkitURL.createObjectURL(file);
		}

		$("#show").attr("src", url);
		//修改图片
		var formData=new FormData();
		var file=$("#file")[0].files[0];
		formData.append("corporate_id",corporate_id);
		formData.append("file",file);
		
		$.ajax({
			
			url :"manager/corporate/Company_Update_company_Logo.do",
			type:"post",
			cache:false,    //上传文件不需要缓存
			processData:false,   //需设置为false，因为data值是FormData对象，不需对数据进行处理
			contentType:false,    //需设置为false，因为是FormData对象，且已经声明了属性
			data:formData,
			dataType:"json",
			error:function(reuqest){
				alert("修改错误");
			},
			success:function(reuqest){
				alert("修改成功");
			}
		})
		
		
	});
	$("#ok").click(function() {
		$("#companyName").blur();
		$("#peopleName").blur();
		$("#scope").change();
		$("#time").blur();
		$("#address").blur();
		$("#phone").blur();
		$("#areaNumber").blur();
		$("#profile").blur();
		$("#exportBase").change();
		//alert(companyNameF+"-"+peopleNameF+"-"+scopeF+"-"+addressF+"-"+profileF+"-"+timeF+"-"+exportBaseF);
		if (companyNameF && peopleNameF && scopeF && addressF && profileF  && timeF && exportBaseF) {
			var number=$("#phone").val();
			//var areaNumber=$("#areaNumber").val();
			var corporate_phone=number;
			var formData=new FormData();
			formData.append("corporate_id",corporate_id);
			formData.append("corporate_name",$("#companyName").val());
			formData.append("corporate_legal_person",$("#peopleName").val());
			formData.append("corporate_time",$("#time").val());
			formData.append("corporate_scope",$("#scope").val());
			formData.append("corporate_base",$("#exportBase").val());
			formData.append("corporate_address",$("#address").val());
			formData.append("corporate_textarea",$("#profile").val());
//			formData.append("corporate_logo_name",corporate_logo_name);
//			formData.append("corporate_logo_path",corporate_logo_path);
			formData.append("corporate_phone",corporate_phone);
			$.ajax({
				
				url :"manager/corporate/manager_Update_Company.do",
				type:"post",
				cache:false,    //上传文件不需要缓存
				processData:false,   //需设置为false，因为data值是FormData对象，不需对数据进行处理
				contentType:false,    //需设置为false，因为是FormData对象，且已经声明了属性
				data:formData,
				dataType:"json",
				error:function(reuqest){
					alert("修改错误");
				},
				success:function(reuqest){
					alert("修改成功");
				}
			})
		
		}else{
			alert("修改失败，请重新修改");
		}
	});
});



//后台出口基地编辑前select
function manager_SelectTarget_Company(rs){
	var corporate=eval(rs);
//	var logo="";
//	var file=$("#file").files[0];
//	var imageType = /image\//;
//	//是否是图片
//	if (!imageType.test(file.type)) {
//		logo="block_pic_350.jpgif";
//	}else{
//		logo=corporate.corporate_logo_name;
//	}
		var str="";
		var str1="";
		//拼接目标基地企业logo
		str1+="<img id='show' width='348' height='348' src='upload/images/"+corporate.corporate_logo_name+"' />";
			str1+="<input type='button' id='upload' value='修改企业logo' style='margin:20px 80px;height:45px;width:150px; background:#666666;color: white;border-radius: 10px;font-size:15px;' />";
			str1+="<input style='display:none;' type='file' id='file' name='file' accept='image/png,image/jpeg,image/gif,image/jpg' />";
		
			//拼接目标基地企业
			str+="<form  method='get' id='update_select_form' enctype='multipart/form-data'>";
		str="<table>";
		str+="<tr>";
			str+="<td>企业名称：</td>";
			str+="<td><input type='text' id='companyName' value="+corporate.corporate_name+" />";
				str+="<font color='red'></font>";
			str+="</td>";
		str+="</tr>";
		str+="<tr>";
			str+="<td>企业法人：</td>";
			str+="<td><input type='text' id='peopleName' value="+corporate.corporate_legal_person+" />";
				str+="<font color='red'></font>";
			str+="</td>";
		str+="</tr>";
		str+="<tr>";
			str+="<td>企业电话：</td>";
			str+="<td><input type='text' id='phone' value="+corporate.corporate_phone+" />";
				str+="<font color='red'></font>";
			str+="</td>";
		str+="</tr>";
		str+="<tr>"
			str+="<td>企业的经营范围：</td>";
			str+="<td><select id='scope'>";
					str+="<option value="+corporate.corporate_scope+">"+corporate.scope_name+"</option>";
				str+="</select>";
				str+="<font color='red'></font>";
			str+="</td>";
		str+="</tr>";
		str+="<tr>";
			str+="<td>出口基地：</td>";
			str+="<td>";
				str+="<select id='exportBase'>";
					if(corporate.corporate_base==null){
						str+="<option value='null'>请选择基地</option>";
					}else{
						str+="<option value='"+corporate.corporate_base+"'>"+corporate.base_name+"</option>";
					}		
				str+="</select>";
				str+="<font color='red'></font>";
			str+="</td>";
		str+="</tr>";
		str+="<tr>";
			str+="<td>企业成立时间：</td>";
			str+="<td><input type='date' id='time' value="+corporate.corporate_time_toString+" />";
				str+="<font color='red'></font>";
			str+="</td>";
		str+="</tr>";
		str+="<tr>";
			str+="<td>企业地址：</td>";
			str+="<td><input type='text' id='address' value="+corporate.corporate_address+" />";
				str+="<font color='red'></font>";
			str+="</td>";
		str+="</tr>";
		str+="<tr>";
			str+="<td>企业简介：</td>";
			str+="<td><textarea name='field' id='profile' style='width:400px;height:200px;' cols='' rows='5'>"+corporate.corporate_textarea+"</textarea>";
				str+="<font color='red'></font>";
			str+="</td>";
		str+="</tr>";
		str+="<tr>";
			str+="<td colspan='2'><input type='button' id='ok' value='提交' /></td>";
		str+="</tr>";
	str+="</table>";
	str+="</form>";
	
	
	$("#body3_text_content_pic").append(str1);
	$("#body3_text_content_text").append(str);
}

function manager_Update_Select_Username(rs){
	var corporate=eval(rs);
	
	//拼接目标基地企业用户名
	var str2="";
	str2+="<tr>";
	str2+="<th colspan='2'>大连童车出口公司账户修改</th>";
	str2+="</tr>";
	str2+="<tr>";
	str2+="<td>账户:</td>";
	str2+="<td><input type='text' id='username' value='"+corporate.corporate_username+"' /></td>";
	str2+="</tr>";
	str2+="<tr>";
	str2+="<td>密码:</td>";
	str2+="<td><input type='text' id='password' value='' /></td>";
	str2+="</tr>";
	str2+="<tr>";
	str2+="<td colspan='2' class='handle'>";
	str2+="<a href='javascript:void(0)' id='submitAccount'><img src='images/manager/submit.png' /></a>";
	str2+="<a href='javascript:void(0)' class='closeModify'><img src='images/manager/cancel.PNG' /></a>";
	str2+="</td>";
	str2+="</tr>";
	$("#modifyAccount1").append(str2);
}

function loadTime() {
	var date_now = new Date();
	var year = date_now.getFullYear();
	var month = date_now.getMonth() + 1 < 10 ? "0" + (date_now.getMonth() + 1) : (date_now.getMonth() + 1);
	var date = date_now.getDate() < 10 ? "0" + date_now.getDate() : date_now.getDate();
	return year + "-" + month + "-" + date;
}
//后台编辑经营范围select
function Select_Scope(result){
	var scope=eval(result);
	var str="";
	for(var i=0;i<scope.length;i++){
	 str+="<option value='"+scope[i].scope_id+"'>"+scope[i].scope_name+"</option>";
	}
	$("#scope").append(str);
}

//后台编辑出口基地select
function Select_Base(result){
	var base=eval(result);
	var str="";
	for(var i=0;i<base.length;i++){
	 str+="<option value='"+base[i].base_id+"'>"+base[i].base_name+"</option>";
	}
	$("#exportBase").append(str);
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