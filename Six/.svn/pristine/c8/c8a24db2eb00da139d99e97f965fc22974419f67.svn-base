<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/index/style.css" rel="stylesheet" type="text/css" />
<link href="css/index/head.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/index/head.js"></script>
<title>Insert title here</title>
</head>
<body>
<div id="top">
 <div id="top1000">
  <div id="top1000_number" class="top14bold"></div>
  <div id="top1000_login" class=" bottom1links14bold"><a href="jsp/index/company/Registration.jsp">注册</a> | <a href="jsp/index/company/Login.jsp">登录</a></div>
 </div>
 <div class="welcome">
 	<c:if test="${corporate!=null}">
 		<a href="jsp/index/company/personal.jsp"><h2>欢迎<strong>${corporate.corporate_username}</strong></h2></a>
 		<a href="javascript:void(0)" onclick="login_out()"><h2>注销</h2></a>
 	</c:if>
 </div>
</div>
<div id="logo">
	<div id="logo1000">
	  <div id="logo1"><a href="#"><img src="images/index/logo.jpg" alt="辽宁省出口基地信息平台" border="0" /></a></div>
	  <div id="logo2"></div>
	</div>
</div>
<div id="nav">
 <div id="nav1000">
   <div id="nav1000_01"><a href="jsp/index/Index.jsp">首页</a></div>
   <div id="nav1000_02"><a href="jsp/index/base/Base_map.jsp">出口基地</a></div>
   <div id="nav1000_03"><a href="jsp/index/company/Company.jsp">基地企业</a></div>
   <div id="nav1000_04"><a href="#">基地产品</a></div>
   <div id="nav1000_05"><a href="#">政策法规</a></div>
   <div id="nav1000_06"><a href="#">资讯动态</a></div>
   <div id="nav1000_07"><a href="#">市场开拓</a></div>
 </div>
</div>


</body>
</html>