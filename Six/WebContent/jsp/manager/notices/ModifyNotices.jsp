<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>2级企业注册</title>
<link href="css/manager/style.css" rel="stylesheet" type="text/css" />
<link href="css/manager/ModifyNotices.css" rel="stylesheet" type="text/css" />
<script src="js/manager/jquery-3.4.1.min.js"></script>
<script src="js/manager/ModifyNotices.js"></script>
</head>
<body>
<div id="body3">
    <div id="body3_body0">
        <div id="body3_title2"><a href="#"></a></div>
        <div id="body3_text">
            <div id="body3_text_product_issue">
                <form action="" method="get" >
                <ul>

                    <li><span class="14boldblack" style="float:left;">公告标题：</span>
                        <span style="float:left;" ><input name="Notice_Title" id="Notice_Title" type="text" value="" style="width:350px; height:25px;"placeholder="请填写公告标题"/><font color="red" size="3px"></font></span></li>
                    <li>
                        <span class="14boldblack" style="float:left;margin-top:10px">公告内容：</span>
                        <span style="float:left;"><textarea name="Notice_Content"  id="Notice_Content" type="text" value="" cols="52" rows="10"  rols="10" placeholder="请填写公告内容,字数为5000字"></textarea><font color="red" size="3px"></font></span>

                    </li>
                    <li style="padding:0px 100px;"><span style="float:left; margin:10px;"><a href="javascript:void(0)" id="4Notices_Form"><img src="images/manager/ok.jpg" border="0" />
                    </a></span><span style="float:left;  margin:10px;"><a href="#"><img src="images/manager/reset.jpg" border="0" /></a></span></li>
                </ul>
                    </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>
