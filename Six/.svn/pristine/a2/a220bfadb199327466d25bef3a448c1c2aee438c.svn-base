
function checkUsername(){
	var username=$("#username").val();
	var i=false;
	 $.ajax({
			url:"index/qa/select.do",
			type:"post",
			data:{user_id:username},
			dataType:"json",
			async:false,
			success:function(msg){
				if(msg>0){
					i=true;
				}else{
					alert("该用户不存在！");
					i=false;
				}
			}
		})
		return i;
}
function checkProtection(){
	var username=$("#username").val();
	var i=false;
	 $.ajax({
			url:"index/qa/select1.do",
			type:"post",
			data:{name:username},
			dataType:"json",
			async:false,
			success:function(msg){
				if(msg>0){
					i=true;
				}else{
					alert("不存在密保！");
					i=false;
				}
			}
		})
		return i;
}
$(function(){
				$("#username").blur(function(){
					if($(this).val()==""){
						alert("请输入要找回密码的账户！");
						return;
					}else{
						if(checkUsername()){
							$("#way").show();
							$("#account").hide();
						}
					}			
				});
				$("#btn").click(function(){
					
						if(checkProtection()){
							location.href="jsp/index/company/byProtection.jsp?name="+$("#username").val();
						}else{
							$("#way").hide();
							$("#account").show();
						}
			
				});
			})