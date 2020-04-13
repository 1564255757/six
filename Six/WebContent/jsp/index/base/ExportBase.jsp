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
<link href="css/index/Export Base.css" rel="stylesheet" type="text/css" />
<script src="js/index/jquery-3.4.1.min.js"></script>
<script src="js/index/ExportBase.js"></script>
</head>

<body>
<jsp:include page="../head.jsp" />

<div id="body3">
  <div id="body3_body">
    <div id="body3_title"><img src="images/index/3Export Base_title.jpg" /></div>
	<div id="body3_text">
	</div>
	 <div id="body3_text_title2"><span class="heibold18">基地骨干企业</span></div>
	 <div id="body3_text_text2">
		
	 </div>
	</div>
  </div>

<jsp:include page="../footer.jsp" />
</body>
</html>
