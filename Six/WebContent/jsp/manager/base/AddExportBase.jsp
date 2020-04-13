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
<link href="css/manager/AddExportBase.css" rel="stylesheet" type="text/css" />
<link href="css/manager/style.css" rel="stylesheet" type="text/css" />
<script src="js/manager/jquery-3.4.1.min.js"></script>
<script src="js/manager/AddExportBase.js"></script>
</head>
<body>
<div id="body3">
  <div id="body3_body0">
    <div id="body3_title"><a href="#"></a></div>
	<div id="body3_text">
	 <div id="body3_text_product_issue">
		<form id="baseForm" >
	   <ul>
	     <li><span class="14boldblack" style="float:left;">基地名称：</span>
          <span style="float:left;"><input name="base_name" id="baseName" type="text" style="width:350px; height:25px;" /><font color="red"></font></span></li>
		 <li><span class="14boldblack" style="float:left;">所属市级：</span>
		  <span style="float:left;" >
			  <select style="height:30px;width:350px;" id="city" name="base_city">
			  		<option value="default">------------------------------请选择所属市--------------------------</option> 	
			  </select>
			  <font color="red"></font>
		  </span></li>
		 <li><span class="14boldblack" style="float:left;" >基地简介：</span>
	      <span style="float:left;"><textarea cols="" name="base_profile" id="profile" rows="10" style="width:350px; height:auto;"></textarea><font color="red"></font></span></li>
		 <li style="padding:0px 100px;"><span style="float:left; margin:10px;"><a href="javascript:void(0)"><img id="ok" src="images/manager/ok.jpg" border="0" /></a></span><span style="float:left;  margin:10px;"><a href="#"><img src="images/manager/reset.jpg" border="0" /></a></span></li>
	   </ul>
	   </form>
	 </div>
	 
	</div>
  </div>
</div>
</body>
</html>
