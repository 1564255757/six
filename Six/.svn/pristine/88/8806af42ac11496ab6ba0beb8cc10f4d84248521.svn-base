$(function(){
	$("#name").val(getParam('name'));
	load();
				$("#ok").click(function(){
					var flag=true;
					$("input[type='text']").each(function(){
						if($(this).val()==""){
							flag=false;
							alert("填写信息不能为空！");
							return false;
						}
					})
					if(flag){
						checkProtection();
					}
				})
})
function checkProtection(){
	 $.ajax({
			url:"index/qa/checkProtection.do",
			type:"post",
			data:$("form").serialize(),
			dataType:"text",
			async:false,
			success:function(msg){
				if(msg!="no"){
					alert("密码为:"+msg);
				}else{
					alert("密保答案有误！");
				}
			}
		})
}
function load(){
	 $.ajax({
			url:"index/qa/selectProtection.do",
			type:"post",
			data:{name:getParam('name')},
			dataType:"json",
			async:false,
			success:function(msg){
				console.log(msg);
				$("#q1").val(msg[0].id);
				$("#q2").val(msg[1].id);
				$("#q1").next().html(msg[0].question_name);
				$("#q2").next().html(msg[1].question_name);	
			}
		})
}
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
