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
<link href="css/index/my_info.css" rel="stylesheet" type="text/css" />
<script src="js/index/jquery-3.4.1.min.js"></script>
<script src="js/index/my_info.js"></script>
</head>
<body>
		<div style="" class="company_info">
			<div class="company_info_left">
				<img src="" id="show" alt="图片丢失" height="200" width="200" />
				<input style="display:none;" type="file" id="file" name="file" accept="image/png,image/jpeg,image/gif,image/jpg" /><br/>
				<input type="button" id="upload" value="修改企业logo" style="margin:10px 20px;height:45px;width:150px; background:#666666;color: white;border-radius: 10px;font-size:15px;" />
			</div>
			<div class="company_info_right">
				<form  id="companyForm" >
				<input type="hidden" name="corporate_id" id="corporate_id"/>
					<table>
						<tr>
							<td>企业所属基地:</td>
							<td><input style="border: 0px;font-size: 15px;" id="base" value="大连童车出口基地" readonly type="text"/></font></td>
						</tr>
						<tr>
							<td>企业名称:</td>
							<td><input name="corporate_name" type="text" id="companyName" /><font color="red"></font></td>
						</tr>
						<tr>
							<td>企业法人:</td>
							<td><input name="corporate_legal_person" type="text" id="peopleName" /><font color="red"></font></td>
						</tr>
						<tr>
							<td>经营范围:</td>
							<td>
								<select id="scope" name="corporate_scope">
									<option value="default">-------------------请选择企业的经营范围--------------------</option>
									<!-- <option value="a">电子商务</option>
									<option value="b">食品贩卖</option>
									<option value="c">外卖</option>
									<option value="d">快递服务</option> -->
								</select>
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td>成立时间:</td>
							<td><input name="corporate_time" type="date" id="time" /><font color="red"></font></td>
						</tr>
						<tr>
							<td>企业地址:</td>
							<td><input name="corporate_address" type="text" id="address" /><font color="red"></font></td>
						</tr>
						<tr>
							<td>企业电话:</td>
							<td>
								<input name="corporate_area" type="text" id="areaNumber" style="width:50px;" />
								-
								<input name="corporate_number" type="text" id="phone" style="width:150px;" />
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td>企业简介:</td>
							<td>
								<textarea id="profile" name="corporate_textarea" cols="" rows="10" style="width:350px; height:250px;"></textarea>
								<font color="red"></font>
							</td>
						</tr>
						<tr>
							<td colspan="2" style="text-align:right;">
								<input type="button" value="提交" id="ok"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
