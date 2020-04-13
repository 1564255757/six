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
<link href="css/manager/admin.css" rel="stylesheet" type="text/css" />
<script src="js/manager/jquery-3.4.1.min.js"></script>
<script src="js/manager/admin.js"></script>
</head>
<body>
<div class="all">
			<img src="images/manager/earth.png"/>
			<form action="" method="get">
			<table align="center">
				<th>管理员登陆</th>
				<tr>
					<td><i class="userIcon"></i> <input type="text" id="name" /> </td>
				</tr>
				<tr>
					<td><i class="keyIcon"></i> <input type="password" id="pass"/> </td>
				</tr>
				<tr>
					<td><input type="button" class="up" id="up" value="登录"/> </td>
				</tr>
			</table>
			</form>
			
</div>
</body>
</html>
