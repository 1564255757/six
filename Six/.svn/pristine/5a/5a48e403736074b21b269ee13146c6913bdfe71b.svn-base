$(document).ready(function(){
		var unFlag=false;
		var pwdF=false;
		var spwdF=false;
		var companyNameF=false;
		var peopleNameF=false;
		var scopeF=false;
		var addressF=false;
		var profileF=false;
		var imgF=false;
		var timeF=false;
		var exportBaseF=false;
		
		var location =(window.location + '').split('/');
		var basePath=location[0]+'//' +location[2]+'/'+ location[3];
		//经营范围select
		$.ajax({
			
			url : basePath+"/index/corporate/Select_Scope.do",
			type:"post",
			data:"",
			async:false,
			dataType:"json",
			success:Select_Scope
		})
		//出口基地select
		$.ajax({
			
			url : basePath+"/index/base/Select_Base.do",
			type:"post",
			data:"",
			async:false,
			dataType:"json",
			success:Select_Base
		})
		
		
		$("#upload").click(function(){
			$("input[type='file']").trigger("click");
		});
		$("#un").blur(function(){
			var regex=/^(?![0-9]+$)(?![a-zA-Z]+$)[A-Za-z][A-Za-z0-9]{5,10}$/;
			var un=$(this).val();
			var ff=false;
			$.ajax({
				
				url : basePath+"/index/corporate/corporate_Username_Repeat.do",
				type:"post",
				data:{"corporate_username" :un},
				async:false,
				dataType:"json",
				success:function(rs){
					if(rs<=0){
						ff=true;
					}else{
						ff=false;
					}
				}
			})
			
			if(un==""){
				$(this).next().html("账号不能为空!");
				unFlag=false;
				return;
			}else if(!regex.test(un)){

				$(this).next().html("账号无效,仅限英文开头,数字字母的组合5-10位!");
				unFlag=false;
				return;			
			}else if(!ff){
				$(this).next().html("用户名称重复");
				unFlag=false;
			}else {
					$(this).next().html("");
					unFlag=true;
			}
		});
		$("#pwd1").keyup(function(){
				$("#pwdSpan div").css("background","#CCC");
				var strong=0;	
				var pwd=$(this).val();	
				if(/\d/.test(pwd)){strong++};
				if(/[a-zA-Z]/.test(pwd)){strong++};
				if(/[~!@%$.]/.test(pwd)){strong++};
				for(var i=0;i<strong;i++){
					$("#pwdSpan div").eq(i).css("background","#9F0");
				}
				
		})	
		$("#pwd1").blur(function(){
			var regex=/^[A-Za-z0-9~!@%$.]{6,15}$/;
			var pwd=$(this).val();
			if(pwd==""){
				$(this).next().html("密码不能为空!");
				pwdF=false;
				return;
			}else if(!regex.test(pwd)){
				$(this).next().html("密码无效,含有非法字符或密码位数小于6位!");
				pwdF=false;
				return;
			}else{
				$(this).next().html("");
				pwdF=true;
			}
		});
		$("#pwd2").blur(function(){
			var pwd1=$("#pwd1").val();
			var pwd2=$(this).val();
			if(pwd2==""){
				$(this).next().html("确认密码不能为空!");
				spwdF=false;
			}else if(pwd1!=pwd2){
				$(this).next().html("两次输入的密码不一致!");
				spwdF=false;
			}else{
				$(this).next().html("");
				spwdF=true;
			}
		});
		$("#companyName").blur(function(){
			var regex=/^[\u4e00-\u9fa5]{0,}$/;
			var companyName=$(this).val();
			var ff=false;
			$.ajax({
				
				url : basePath+"/index/corporate/corporate_Name_Repeat.do",
				type:"post",
				data:{"corporate_name" :companyName},
				async:false,
				dataType:"json",
				success:function(rs){
					if(rs<=0){
						ff=true;
					}else{
						ff=false;
					}
				}
			})
			if(companyName==""){
				companyNameF=false;
				$(this).next().html("公司名不能为空!!!")
				return;
			}else if(!regex.test(companyName)){
				$(this).next().html("请填写中文名字!!!");
				companyNameF=false;
				return;
			}else if(!ff){
				$(this).next().html("企业名称重复");
				companyNameF=false;
			}else{
				$(this).next().html("");
				companyNameF=true;
			}
		});
		$("#peopleName").blur(function(){
			var regex=/^[\u4e00-\u9fa5]{0,}$/;
			var peopleName=$(this).val();
			if(peopleName==""){
				peopleNameF=false;
				$(this).next().html("法人名不能为空!!!")
				return;
			}else if(!regex.test(peopleName)){
				$(this).next().html("请填写中文名字!!!");
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
				$(this).next().html("请选择经营范围！");
				scopeF=false;
			}else{
				$(this).next().html("");
				scopeF=true;
			}		
		});
		$("#exportBase").change(function(){
			var exportBase=$(this).val();
			if(exportBase=='default'){
				$(this).next().html("请选择出口基地！");
				exportBaseF=false;
			}else{
				$(this).next().html("");
				exportBaseF=true;
			}		
		});
		$("#time").blur(function(){
			var time=$(this).val();
			if(time==''){
				$(this).next().html("请选择成立时间！");
				timeF=false;
			}else{
				$(this).next().html("");
				timeF=true;
			}		
		});
		$("#address").blur(function(){
			var address=$(this).val();
			if(address==''){
				$(this).next().html("地址不能为空！");
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
				$(this).next().html("电话不能为空！");
				phoneF=false;
			}else if(!regex.test(tel)){
				$(this).next().html("请输入正确格式的电话！")
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
				$(this).next().html("公司简介不能为空！");
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
		});
		$("#ok").click(function(){
			var file=$("#file").val();
			if(file!=""){			
				imgF=true;
			}else{
				alert("请添加公司logo");
				imgF=false;
			}
			$("#un").blur();
			$("#pwd1").blur();
			$("#pwd2").blur();
			$("#companyName").blur();
			$("#peopleName").blur();
			$("#scope").change();
			$("#exportBase").change();
			$("#time").blur();
			$("#address").blur();
			$("#phone").blur();
			$("#areaNumber").blur();
			$("#profile").blur();
			//alert(unFlag+"-"+pwdF+"-"+spwdF+"-"+companyNameF+"-"+peopleNameF+"-"+scopeF+"-"+addressF+"-"+profileF+"-"+imgF+"-"+timeF+"-"+exportBaseF);
			if(unFlag&&pwdF&&spwdF&&companyNameF&&peopleNameF&&scopeF&&addressF&&profileF&&imgF&&timeF&&exportBaseF){
				var number=$("#phone").val();
				var areaNumber=$("#areaNumber").val();
				var corporate_phone=(areaNumber+"-"+number);
				var formData=new FormData();
//				alert($("#un").val());
//				alert($("#scope").val());
//				alert($("#pwd1").val());
//				alert($("#peopleName").val());
//				alert($("#time").val());
//				alert($("#exportBase").val());
//				alert($("#address").val());
//				alert($("#profile").val());
//				alert($("#companyName").val());
//				alert(corporate_phone);
//				alert(corporate_logo_name);
//				alert(corporate_logo_path);
				
				var file=$("#file")[0].files[0];
				corporate_logo_path="upload/images";
				console.log(file);
				formData.append("file",file);
				formData.append("corporate_username",$("#un").val());
				formData.append("corporate_password",$("#pwd1").val());
				formData.append("corporate_name",$("#companyName").val());
				formData.append("corporate_legal_person",$("#peopleName").val());
				formData.append("corporate_time",$("#time").val());
				formData.append("corporate_scope",$("#scope").val());
				formData.append("corporate_base",$("#exportBase").val());
				formData.append("corporate_address",$("#address").val());
				formData.append("corporate_textarea",$("#profile").val());
//				formData.append("corporate_logo_name",corporate_logo_name);
//				formData.append("corporate_logo_path",corporate_logo_path);
				formData.append("corporate_phone",corporate_phone);
				$.ajax({
					
					url :"manager/corporate/manager_Insert_Company.do",
					type:"post",
					cache:false,    //上传文件不需要缓存
					processData:false,   //需设置为false，因为data值是FormData对象，不需对数据进行处理
					contentType:false,    //需设置为false，因为是FormData对象，且已经声明了属性
					data:formData,
					dataType:"json",
					error:function(reuqest){
						alert("添加错误");
					},
					success:index_registration
				})
				
			}
		});
		
		$("#reset").click(function(){
			$("input[type='reset']").click();
		});
	});

//后台企业添加
function index_registration(result){
	if(result>0){
		alert("添加成功");
		location.href="jsp/manager/company/company.jsp";
	}else{
		alert("添加失败");
	}
}

//后台添加经营范围select
function Select_Scope(result){
	var scope=eval(result);
	var str="";
	for(var i=0;i<scope.length;i++){
	 str+="<option value='"+scope[i].scope_id+"'>"+scope[i].scope_name+"</option>";
	}
	$("#scope").append(str);
}

//后台添加出口基地select
function Select_Base(result){
	var base=eval(result);
	var str="";
	for(var i=0;i<base.length;i++){
	 str+="<option value='"+base[i].base_id+"'>"+base[i].base_name+"</option>";
	}
	$("#exportBase").append(str);
}