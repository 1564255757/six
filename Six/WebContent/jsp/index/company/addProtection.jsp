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
<script src="js/index/addProtection.js"></script>
</head>
<body>
		<div style="margin-top:100px;" >
			<form>
				<table align="center" border="0" cellspacing="10" >
					<tbody id="t1">
					<tr>
						<td>密保1：</td>
						<td>
							<select id="q1" name="qa[0].question_id">
								<option value="default">----选择一个密保问题----</option>
							</select>
							<font color="red"></font>
						</td>
					</tr>
					<tr>
						<td>答案：</td>
						<td>
							<input type="text" id="a1" name="qa[0].question_answer" value="" /><font color="red"></font>
						</td>	
					</tr>
					<tr>
						<td colspan="2" style="text-align: right;">
							<input  type="button" id="nextStep" value="下一步"/>
						</td>
					</tr>
					</tbody>
					<tbody id="t2" style="display: none;">
						<tr>
							<td>密保2：</td>
							<td>
								<select id="q2" name="qa[1].question_id">						
								</select>
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td>答案：</td>
							<td>
								<input type="text" id="a2" name="qa[1].question_answer" value="" /><font color="red"></font>
							</td>	
						</tr>
						<tr>
							<td colspan="2" style="text-align: right;">
								<input  type="button" id="ok" value="提交"/>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
</body>
</html>
