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
<script src="js/index/resetProtection.js"></script>
</head>
<body>
		<div style="margin-top:100px;" >
			<div id="jump" style="text-align: center;display:none;">
				您还没有密保，<a  href="jsp/index/company/addProtection.jsp">点击设置</a>
			</div>
			<form style="display:none;">
			<input type="hidden" id="qId1" name="qa[0].id"/>
			<input type="hidden" id="qId2" name="qa[1].id"/>
				<table align="center" border="0" cellspacing="10" >
					
					<tr>
						<td>密保1：</td>
						<td>
							<select id="p1" name="qa[0].question_id">
							</select>
						</td>
						
					</tr>
					<tr>
						<td>答案：</td>
						<td>
							<input type="text" name="qa[0].question_answer" id="answer1" value="" />
						</td>	
					</tr>
					<tr>
						<td>密保2：</td>
						<td>
							<select id="p2" name="qa[1].question_id">
							</select>
						</td>
						
					</tr>
					<tr>
						<td>答案：</td>
						<td>
							<input type="text" name="qa[1].question_answer" id="answer2" value="" />
						</td>	
					</tr>
					<tr>
						<td colspan="2" style="text-align: right;">
							<input  type="button" id="ok" onclick="go()" value="修改"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
</body>
</html>
