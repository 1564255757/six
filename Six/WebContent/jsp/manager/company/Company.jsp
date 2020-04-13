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
<link href="<%=basePath %>css/manager/Company.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath %>js/manager/jquery-3.4.1.min.js"></script>
<script src="<%=basePath %>js/manager/Company.js"></script>
</head>
<body>
<jsp:include page="../head.jsp" />
<div id="body3">
  <div id="body3_body0">
    <div id="body3_title6"><a href="<%=basePath %>jsp/manager/company/AddCompany.jsp"><img src="<%=basePath %>images/manager/add_add.jpg" border="0" /></a></div>
	   <a href="<%=basePath %>jsp/manager/company/Company_NEW.jsp" style="font-size:14px;float:right;margin-right:100px;">
		  <div id="state_Company">
	<img style="display: inline-block;width: 30px; height: 30px;" src="<%=basePath %>images/manager/waitCheck.png"/>
		   待审核企业<font color="red"><input type="text" value="" id="state" style="width: 20px"></font>
		   </div> 
	   </a>
	<div id="body3_text">
	 <div id="body3_text_policy">
	 
	 </div>
	 	 <div id="body3_text_policy_page">
	 <input type="hidden" id="cpage" value=""/>
	 <a href="javascript:void(0)" onclick="firstPage()">首页</a>
	 <a href="javascript:void(0)" onclick="upPage()">上一页</a>
	 <input type="text" id="page" value="" style="width:15px" readonly="readonly"/>
	 <a href="javascript:void(0)" onclick="nextPage()">下一页</a>
	 <a href="javascript:void(0)" onclick="lastPage()">尾页</a>
	 到第  <select id="selectpage" name="selectpage">
	<option>请选择</option>
	 </select>
      页 </div>
	</div>
  </div>
</div>
</body>
</html>
