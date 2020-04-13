function login(result){
	var i=eval(result);
	if(i>0){
		location.href="jsp/index/Index.jsp";
	}else{
		alert("账号或密码错误！");
	}
}
$(function(){
		var unFlag=false;
		var pwdFlag=false;
		$("#un").blur(function(){
			var un=$(this).val();
			if(un==''){
				$(this).next().html("用户名不能为空!");
				unFlag=false;
			}else{
				$(this).next().html("");
				unFlag=true;
			}
		});
		$("#pwd").blur(function(){
			var pwd=$(this).val();
			if(pwd==''){
				$(this).next().html("密码不能为空!");
				pwdFlag=false;
			}else{
				$(this).next().html("");
				pwdFlag=true;
			}
		});
		$("#ok").click(function(){
			$("#un").trigger("blur");
			$("#pwd").trigger("blur");
			if(unFlag&&pwdFlag){
				var un=$("#un").val();
				var pwd=$("#pwd").val();
				$.ajax({
					url:"index/corporate/cor.do",
					type:"post",
					data:{corporate_username:un,corporate_password:pwd},
					dataType:"json",
					success:login
				})
			}
		});
	});
