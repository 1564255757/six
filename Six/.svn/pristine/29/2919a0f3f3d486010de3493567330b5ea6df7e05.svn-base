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
<script src="js/index/jquery-3.4.1.min.js"></script>
<script src="js/index/byProtection.js"></script>
</head>

<body>
<jsp:include page="../head.jsp" />

<div id="body3">
	<div id="body3_body0" style="height:400px;">
		<div style="margin-top:100px;" >
			<form>
				<input type="hidden" id="name"  name="name">
				<table align="center" border="0" cellspacing="10" >
					<tr>
						<td>密保1：</td>
						<td>
							<input type="hidden" id="q1" name="qa[0].id"> <span></span>
						</td>				
					</tr>
					<tr>
						<td>答案：</td>
						<td>
							<input type="text" name="qa[0].question_answer" value="" />
						</td>	
					</tr>
					<tr>
						<td>密保2：</td>
						<td>
							<input type="hidden" id="q2" name="qa[1].id"/><span></span>
						</td>		
					</tr>
					<tr>
						<td>答案：</td>
						<td>
							<input type="text" name="qa[1].question_answer" value="" />
						</td>	
					</tr>
					<tr>
						<td colspan="2" style="text-align: right;">
							<input  type="button" id="ok" value="提交"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
