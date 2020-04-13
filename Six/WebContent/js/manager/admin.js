function admin(result){
	var i=eval(result);
	if(i>0){
		location.href="jsp/manager/Welcome.jsp";
	}else{
		alert("账户或密码错误！");
	}
	}
$(function(){
$(".up").click(function(){
    	var name=$("#name").val();
		var pass=$("#pass").val();
		if(name==""){
			alert("用户名不能为空！");
			return;
		}
		if(pass==""){
			alert("密码不能为空！");
			return;
		}
		var name=$("#name").val();
		var pass=$("#pass").val();
		$.ajax({
			url:"manager/admin/adm.do",
			type:"post",
			data:{admin_name:name,admin_password:pass},
			dataType:"json",
			success:admin
		})
		
		
	});
	
});
