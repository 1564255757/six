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
<link href="css/manager/ModifyExport.css" rel="stylesheet" type="text/css" />
<script src="js/manager/jquery-3.4.1.min.js"></script>
<script src="js/manager/ModifyExport.js"></script>
</head>
<body>
<div id="body3">
  <div id="body3_body0">
    <div id="body3_title"><a href='javascript:void(0)'></a></div>
	<div id="body3_text">
	 <div id="body3_text_product_issue">
		<form id="baseForm">
		<input type="hidden" value="" name="base_id" id="base_id"/>
	   <ul>
		  <li><span class="14boldblack" style="float:left;"><a href="javascript:void(0)" id="edit"><font size="2" style="font-weight: bold;">旗下公司编辑</font> </a></span>
	     <li><span class="14boldblack" style="float:left;">基地名称：</span>
          <span style="float:left;"><input name="base_name" id="baseName" type="text" value="ssssss" style="width:350px; height:25px;" /><font color="red"></font></span></li>
		 <li><span class="14boldblack" style="float:left;">所属市级：</span>
		  <span style="float:left;" >
			  <select style="height:30px;width:350px;" id="city" name="base_city">
			  		<option value="default">------------------------------请选择所属市--------------------------</option>
			  </select>
			  <font color="red"></font>
		  </span></li>
		 
	      
		 </span></li>
		 <li><span class="14boldblack" style="float:left;">基地简介：</span>
	      <span style="float:left;"><textarea cols="" id="profile" name="base_profile" rows="10" style="width:350px; height:auto;"></textarea><font color="red"></font></span></li>
		 <li style="padding:0px 100px;"><span style="float:left; margin:10px;"><a href="javascript:void(0)"><img id="ok" src="images/manager/ok.jpg" border="0" /></a></span><span style="float:left;  margin:10px;"><a href='javascript:void(0)'><img src="images/manager/reset.jpg" border="0" /></a></span></li>
	   </ul>
	   </form>
	 </div>
	  <div id="light" class="white_content">
		  <a href="javascript:void(0)" class="closeModify">
		  			<img style="float: right;width: 30px;height: 30px;"  src="images/manager/close.png" />
		  </a>
		  <center><font size="6">xxx旗下子公司添加</font></center>
		  <div class="white_content_company">
		  <ul id="no">
		  </ul>
		  </div>
		  <div class="white_content_footer">
		  <a href="javascript:void(0)"  id="submitAdd"><img src="images/manager/submit.png" /></a>&emsp;&emsp;&emsp; 
		  <a href="javascript:void(0)"  class="closeModify"><img src="images/manager/cancel.PNG" /></a>
		  </div>
	  </div>
	 
	  <div id="fade" class="black_overlay"></div> 
	 
	</div>
	<div id="down" style="border-top: 1px solid black;width:750px;height:300px;padding-left:250px;margin-top:500px;display: none;">
			  <span class="14boldblack" style="float:left;"><font size="3">旗下公司:</font></span>
			   <span style="float:left;" >	  
			  			  <table class="base_factory">
			  				  <thead>
			  					<tr>
			  						<td><input type="checkbox" id="checkAll"/><font size="3">全选</font></td>
			  						<td>					 
			  							<a href='javascript:void(0)' id="del"><img src="images/manager/delBaseFactory.png"/></a>
			  							<a href='javascript:void(0)' id="add"><img src="images/manager/add.png" ></a>
			  						</td>
			  					</tr>
			  				  </thead>
			  				  <tbody id="son">
			  				  
			  				  </tbody>
			  			  </table>
			  			  
			  </span>
	</div>
  </div>
</div>
</body>
</html>
