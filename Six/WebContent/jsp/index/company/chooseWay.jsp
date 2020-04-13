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
<link href="css/index/chooseWay.css" rel="stylesheet" type="text/css" />
<script src="js/index/jquery-3.4.1.min.js"></script>
<script src="js/index/chooseWay.js"></script>
</head>

<body>
<jsp:include page="../head.jsp" />

<div id="body3">
<div id="body3_body0" style="height:400px;">
	<div style="margin-top:100px;" >
				<table align="center" border="0" cellspacing="10" >
					<tbody id="account">
						<tr>
							<td>输入要找回密码的账户</td>
							<td><input type="text" id="username" value=""/></td>
						</tr>
					</tbody>
					<tbody id="way" style="display: none;">
						<tr>
							<td><a href="javascript:void(0)"><input id="btn" type="button" value="密保找回"/></a></td>
						</tr>
						<tr>
							<td><a href="javascript:void(0)"><input type="button" value="申诉"/></a></td>
						</tr>
					</tbody>
				</table>
			
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
