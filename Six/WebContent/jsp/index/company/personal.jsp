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
<link href="css/index/personal.css" rel="stylesheet" type="text/css" />
</head>

<body>
<jsp:include page="../head.jsp" />

<div id="body3" style="height:600px;">
	<div id="bbb">
			<div id="left">
				<ul class="one_bar">
					<li>
						<a href="javascript:void(0)"><span>个人中心</span></a>
						<ul class="two_bar">
							<li><a href="jsp/index/company/my_info.jsp" target="switch">企业信息</a></li>
						</ul>
					</li>
					<li>
						<a href="javascript:void(0)"><span>账号安全</span></a>
						<ul class="two_bar">
							<li><a href="jsp/index/company/resetPassword.jsp" target="switch">密码修改</a> </li>
							<li><a href="jsp/index/company/resetProtection.jsp" target="switch">密保修改</a> </li>
						</ul>
					</li>
				</ul>
			</div>
			<div id="right">
				<iframe name="switch" src="" scrolling="no" frameborder="0"></iframe>
			</div>	
	</div>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
