$(function(){
	load();
				$("#nextStep").click(function(){
					$("#a1").next().html("");
					$("#q1").next().html("");
					var value=$("#q1").val();
					var answer=$("#a1").val();
					if(value=='default'){
						$("#q1").next().html("请选择密保问题！");
						return;
					}else if(answer==""){
						$("#a1").next().html("请填写密保答案！");
						return;
					}
					$("#q1 option").each(function(){
						if(!$(this).prop("selected")){
							$("#q2").append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option>");
							
						}			
					});
					$("#t1").hide();
					$("#t2").show();
				})
				$("#ok").click(function(){
					$("#a2").next().html("");
					$("#q2").next().html("");
					var value=$("#q2").val();
					var answer=$("#a2").val();
					if(value=='default'){
						$("#q2").next().html("请选择密保问题！");
						return false;
					}else if(answer==""){
						$("#a2").next().html("请填写密保答案！");
						return false;
					}else{
						$("#qq1").val($("#q1").val());
						$("#qq2").val($("#q2").val());
						go();
					}
					return true;
				});
})
function go(){
	$.ajax({ 
		type:"post",
		url: "index/qa/addProtection.do",
		data:$("form").serialize(),
		dataType:"json",
		success:function(flag){
			if(flag==1){
				alert("增加成功！");
				location.href="jsp/index/company/resetProtection.jsp";
			}else{
				alert("遇到了不可抗拒因素....");
			}
		}
	});
}
function load(){
	$.ajax({ 
		type:"post",
		url: "index/qa/selQuestion.do",
		dataType:"json",
		success:function(q){
			if(q==-1){
				alert("未登录");
				top.location.href="jsp/index/company/Login.jsp";
			}
			var str="";
			for(var i in q){
				str+="<option value='"+q[i].id+"'>"+q[i].question_name+"</option>";
			}
			$("#q1").append(str);
		}
	});
}