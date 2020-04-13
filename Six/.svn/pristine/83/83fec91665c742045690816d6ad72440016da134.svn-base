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
<link href="css/index/Company.css" rel="stylesheet" type="text/css" />
<script src="js/index/jquery-3.4.1.min.js"></script>
<script src="js/index/Company.js"></script>
</head>

<body>
<jsp:include page="../head.jsp" />

<div id="body3">
  <div id="body3_body_long">
    <div id="body3_title"><img src="images/index/3Company_RE_title.jpg" width="999" height="26" /></div>
	<div id="body3_text">
	  <div id="body3_text_suoyin">
		 
		  所有类目&gt;<a href="javascript:void(0)" id="result_city"></a>&ensp;&ensp;<a href="javascript:void(0)" id="result_scope"></a>
		  <d
		  iv style="display:none"><span id="city_id"></span>&ensp;&ensp;<span id="scope_id"></span></div>
	  </div>
	  <div id="body3_text_suoyin_list" >
	  <span style="float:left; width:75px; line-height:26px; text-align:right">城市：</span>
	   <span style="float:left;">
		<ul id="show_city" class="choose_city">
			
		</ul>
	   </span>
	   <span style="float:left; width:65px; line-height:26px; text-align:right; padding-right:5px;"><a href="javascript:void(0)" id="cityMore">+更多</a></span>
	  </div>
	  <div id="body3_text_suoyin_list" class="hide_city_div" style="display:none">
	  
	   <span style="float:left;">
		<ul id="hide_city" class="choose_city">

		</ul>
	   </span>
	  </div>
	  <div id="body3_text_suoyin_list"  >
	  <span style="float:left; width:75px; line-height:26px; text-align:right">经营范围：</span>
	   <span style="float:left;">
	   <ul id="show_scope" class="choose_scope">

	   </ul>
	   </span>
	   <span style="float:left; width:65px; line-height:26px; text-align:right; padding-right:5px;"><a href="javascript:void(0)" id="scopeMore">+更多</a></span>
	  </div>
       <div id="body3_text_suoyin_list" class="hide_scope_div" style="display:none">
	   <span style="float:left; width:75px; line-height:26px; text-align:right"></span>
	   <span style="float:left;">
	   <ul id="hide_scope" class="choose_scope">

	   </ul>
	   </span>
	   </div>
     <div id="body3_text_suoyin_list_line"></div>
	 <div id="body3_text_suoyin_list_product">
    	<div class="sort"> 
        	<a id="defaultOrder" href="javascript:void(0)"><span>默认</span></a>&nbsp;&nbsp;<a href="javascript:void(0)" id="clickOrder"><span>热度<i class="clickOrder"></i></span></a>
        </div>
		 <ul id="allCompany">
		  
		 </ul>
	 </div>
	  <div id="body3_text_policy_page"><!-- 首页 上一页 1 下一页 尾页  到第
	       <select name="select">
	         <option>1</option>
	         <option>2</option>
	         <option>3</option>
	         <option>4</option>
	         <option>5</option>
           </select>

      页 --> </div>
	</div>
  </div>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
