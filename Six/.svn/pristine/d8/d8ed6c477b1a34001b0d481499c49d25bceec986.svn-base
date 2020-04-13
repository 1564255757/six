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
<link href="<%=basePath %>css/index/Registration.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath %>js/index/jquery-3.4.1.min.js"></script>
<script src="<%=basePath %>js/index/Registration.js"></script>
</head>

<body>
<jsp:include page="../head.jsp" />

<div id="body3">
			<div id="body3_body0">
				<div id="body3_title"><img src="<%=basePath %>images/index/2Registration_title.jpg" width="999" height="26" /></div>
				<div id="body3_text">
					<div id="body3_text_product_issue">
						<form method="post" enctype="multipart/form-data" id="form">
							<ul>
								<li><span class="14boldblack" style="float:left;">登录账户：<input name="corporate_username" type="text" id="un" style="width:350px; height:25px;" value="asd123"
										 maxlength="10" placeholder="5-10位,数字字母组合" />
										<font color="red"></font>
									</span>
								</li>
								<li><span class="14boldblack" style="float:left;">登录密码：<input name="corporate_password" type="password" id="pwd1" style="width:350px; height:25px;" value="111111"
										 maxlength="16" placeholder="6-16位,合法特殊符号~!@%$." />
										<font color="red"></font>
									</span>
								</li>
								<li><span style="float:left;" id="pwdSpan">密码强度:<div>弱</div>
										<div>中</div>
										<div>强</div>
									</span></li>
								<li><span class="14boldblack" style="float:left;">确认密码：<input name="corporate_password1" type="password" id="pwd2" style="width:350px; height:25px;" value="111111"
										 maxlength="16" placeholder="确认密码" />
										<font color="red"></font>
									</span></li>
								<li><span class="14boldblack" style="float:left;">企业名称：<input name="corporate_name" type="text" id="companyName" style="width:350px; height:25px;" value="啊"
										 placeholder="企业注册名字" />
										<font color="red"></font>
									</span>
								</li>
								<li><span class="14boldblack" style="float:left;">企业法人：<input name="corporate_legal_person" type="text" id="peopleName" style="width:350px; height:25px;" value="啊"
										 placeholder="企业注册法人" />
										<font color="red"></font>
									</span>
								</li>
								<li><span class="14boldblack" style="float:left;">
										经营范围：<select id="scope" name="corporate_scope">
											<option value="default">-------------------请选择企业的经营范围--------------------</option>
											<!-- <option value="a">电子商务</option>
											<option value="b">食品贩卖</option>
											<option value="c">外卖</option>
											<option value="d">快递服务</option> -->
										</select>
										<font color="red"></font>
									</span></li>
                                 <li><span class="14boldblack" style="float:left;">
										基地市级:
										<select id="exportCity" name="city_id">
											<option value="default">---请选择出口基地市级---</option>
											<!-- <option value="大连">大连</option>
											<option value="锦州">锦州</option>
											<option value="丹东">丹东</option>
											<option value="沈阳">沈阳</option> -->
										</select>
										出口基地：
										<select id="exportBase" name="corporate_base">
											<option value="default">---请选择企业的出口基地---</option>
										</select>
										<font color="red"></font>
									</span></li>
								<li><span class="14boldblack" style="float:left;">成立时间：<input name="corporate_time" id="time" type="date" style="width:350px; height:25px;" />
										<font color="red"></font>
									</span>
								</li>
								<li><span class="14boldblack" style="float:left;">企业地址：<input name="corporate_address" type="text" id="address" style="width:350px; height:25px;" value="啊"
										 placeholder="企业注册地址" />
										<font color="red"></font>
									</span>
								</li>
								<li><span class="14boldblack" id="phoneSpan" style="float:left;">企业电话：<input name="areaNumber" type="text" id="areaNumber"
										 style="width:50px; height:25px;" placeholder="区号" value="011"/>-<input type="text" id="phone" name="number" style="width:150px; height:25px;" value="87862844"
										 placeholder="联系电话" />
										<font color="red"></font>
									</span>
								</li>
								<li><span class="14boldblack" style="float:left;">企业简介：</span>
									<span style="float:left;"><textarea id="profile" name="corporate_textarea" cols="" rows="10" style="width:350px; height:auto;" 
										 placeholder="企业的详细介绍"></textarea>
										<font color="red"></font></span></li>
								<li>
									<span class="14boldblack" style="float:left;margin-top:10px">企业logo：</span>
									<span style="float:left; margin-left:10px; margin-top:12px;"><img src="<%=basePath %>images/index/upload.svg" id="show" height="100"
										 width="100"><input style="display:none;" type="file" id="file" name="file" accept="image/png,image/jpeg,image/gif,image/jpg" />
									</span>
									<input type="button" id="upload" value="点击上传图片" style="margin:55px 25px;height:45px;width:150px; background:#666666;color: white;border-radius: 10px;font-size:15px;"/>
								</li>
								<li style="padding:0px 100px;"><span style="float:left; margin-top:-25px; margin-left:10px;"><a href="javascript:void(0)"><img
											 id="ok" src="<%=basePath %>images/index/ok.jpg" border="0" /></a></span><span style="float:left; margin-top: -25px;margin-left:10px;"><a
										 href="javascript:void(0)"><input type="reset" style="display:none;"/> <img id="reset" src="<%=basePath %>images/index/reset.jpg" border="0" /></a></span></li>
							</ul>

						</form>
					</div>

				</div>
			</div>
		</div>

<jsp:include page="../footer.jsp" />
</body>
</html>
