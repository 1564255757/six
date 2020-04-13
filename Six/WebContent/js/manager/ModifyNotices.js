/**
 * Created by 疯小涛 on 2019/8/4.
 */
$(document).ready(function(){

	var Contet_Number='1000';
    var Flag_Notices_Title=false;
    var Flag_Notice_Content=false;

    var notice_id=getParam("notice_id");
	$.ajax({
		url : "manager/notice/selectid.do",
		type : "post",
		data : {notice_id:notice_id},
		dataType : "json",
		success : M_selectid
	})
	$("#4Notices_Form").click(function(){
		$("#Notice_Title").blur();
		$('#Notice_Content').blur();
        if(Flag_Notices_Title&&Flag_Notice_Content){
    		var notice_title = $("#Notice_Title").val();
    		var notice_context = $("#Notice_Content").val();
    			$.ajax({
    			url : "manager/notice/update.do",
    			type : "post",
    			data : {notice_id:notice_id,notice_title:notice_title,notice_context:notice_context},
    			dataType : "json",
    			success : update
    			})
        }
        
    })
    $("#Notice_Title").blur(function(){
        var Notice_Title=$(this).val();
        var regu = "^[ ]+$";
	     var re = new RegExp(regu);
        if(Notice_Title==""||re.test(Notice_Title)){
            Flag_Notices_Title=false;
            $(this).next().html("公告标题不能为空!!!");
            Flag_Notices_Title=false;

        }else if(Notice_Title.length>50){
            $(this).next().html("公告内容过长！！");

            Flag_Notices_Title=false;
    }else{
            $(this).next().html("");
            Flag_Notices_Title=true;
        }
    });

	$('#Notice_Content').blur(function(){
       var Notice_Content=$(this).val();
	   if(Notice_Content==""){
            Flag_Notice_Content=false;
            $(this).next().html("公告内容不能为空!!!");
        }else if($(this).val().length>1000){
			Flag_Notice_Content=false;
			$(this).next().html("公告内容过长!!!");
		}else{
			Flag_Notice_Content=true;
			$(this).next().html("");
		}
    });
    $('#Notice_Content').keyup(function(){
        var Notice_Content=$(this).val();
        var Notice_Content_Number=Notice_Content.length;
            n=Contet_Number-Notice_Content_Number;
            $(this).next().html("内容可输入"+n+"字");


    });
})
		
function update(result){
	alert("修改成功");
	location.href="jsp/manager/notices/Notices.jsp";
}
function M_selectid(result){
	var notices = eval(result);
    $("#Notice_Title").val(notices.notice_title);
    $("#Notice_Content").val(notices.notice_context);
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
