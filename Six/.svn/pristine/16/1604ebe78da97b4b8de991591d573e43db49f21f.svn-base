$(function(){
	selProtection();
})
function selProtection(){
	$.ajax({ 
		type:"post",
		url: "index/qa/selProtection.do",
		dataType:"json",
		success:function(msg){
			var str1="";
			var str2="";
			var qa=msg.qa;
			var q=msg.list;
			if(qa.length==0){
				$("#jump").show();
			}else{
				
			
			for(var i in q){
				if(qa[0].question_id==q[i].id){
					str1+="<option selected='selected' value='"+q[i].id+"'>"+q[i].question_name+"</option>";
				}
				str1+="<option value='"+q[i].id+"'>"+q[i].question_name+"</option>";
			}
			for(var i in q){
				if(qa[1].question_id==q[i].id){
					str2+="<option selected='selected' value='"+q[i].id+"'>"+q[i].question_name+"</option>";
				}
				str2+="<option value='"+q[i].id+"'>"+q[i].question_name+"</option>";
			}
			$("#qId1").val(qa[0].id);
			$("#p1").append(str1);
			$("#answer1").val(qa[0].question_answer);
			$("#qId2").val(qa[1].id);
			$("#p2").append(str2);		
			$("#answer2").val(qa[1].question_answer);	
			$("form").show();
			}
		}
	});
}

function go(){
	if($("#p1").val()==$("#p2").val()){
		alert("请不要选择相同的密保！")
		return;
	}
	
	$.ajax({ 
		type:"post",
		url: "index/qa/resetProtection.do",
		data:$("form").serialize(),
		dataType:"json",
		success:function(flag){
			if(flag==1){
				alert("修改成功！");
				location.href="jsp/index/company/resetProtection.jsp";
			}else{
				alert("遇到了不可抗拒因素....");
			}
		}
	});
}