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
<link href="css/index/NoticesList.css" rel="stylesheet" type="text/css" />
<script src="js/index/jquery-3.4.1.min.js"></script>
<script src="js/index/NoticesList.js"></script>
</head>
<body>
<jsp:include page="../head.jsp" />
<div id="body3">
  <div id="body3_body0">
    <div id="body3_title"><img src="images/index/3Notices_title.jpg" width="999" height="26" /></div>
	<div id="body3_text">
	 <div id="body3_text_policy">
	 
	 </div>
	 <div id="body3_text_policy_page"><!-- 首页 上一页 1 下一页 尾页  到第
	       <select name="select">
	         <option>1</option>
	         <option>2</option>
	         <option>3</option>
	         <option>4</option>
	         <option>5</option>
           </select>

      页  --></div>
	</div>
  </div>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
