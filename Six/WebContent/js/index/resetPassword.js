$(function(){	
				var oFlag=false;
				var nFlag=false;
				$("#o_pwd").blur(function(){
					var value=$(this).val();
					if(value==""){
						$(this).next().html("不能为空！");
						oFlag=false;
					}else{
						$(this).next().html("");
						oFlag=true;
					}
				});
				$("#n_pwd1").blur(function(){
					var value=$(this).val();
					if(value==""){
						$(this).next().html("不能为空！");
						nFlag=false;
					}else{
						$(this).next().html("");
						nFlag=true;
					}
				});
				$("#n_pwd2").blur(function(){
					var pwd2=$(this).val();
					var pwd1=$("#n_pwd1").val();
					if(pwd2==""){
						$(this).next().html("不能为空！");
						nFlag=false;
					}else if(pwd2!=pwd1){
						$(this).next().html("密码不一致！");
						nFlag=false;
					}else{
						$(this).next().html("");
						nFlag=true;
					}
				});
				$("#ok").click(function(){
					$("#o_pwd").blur();
					$("#n_pwd1").blur();
					$("#n_pwd2").blur();
					if(nFlag&&oFlag){					
						resetPass();
					}
				});
})
function resetPass(){
	$.ajax({ 
		type:"post",
		url: "index/corporate/updCorporatePassword.do",
		data:$("form").serialize(),
		dataType:"json",
		async:false,
		success:function(flag){
			if(flag==1){
				alert("修改成功！会话失效，请重新登录！");
				top.location.href="jsp/index/company/Login.jsp";
			}else{
				$("#o_pwd").next().html("原密码错误！");
			}
		}
	});
}