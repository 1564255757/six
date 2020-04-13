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
<link href="css/index/Index.css" rel="stylesheet" type="text/css" />
<script src="js/index/jquery-3.4.1.min.js"></script>
<script src="js/index/index.js"></script>
</head>

<body>
<jsp:include page="head.jsp" />

<div id="body1">
			<div id="bodyup">
				<div id="bodyup1">
					<div id="bodyup1title"><a href="jsp/index/notices/NoticesList.jsp"><img src="images/index/more.jpg" width="23" height="5" border="0" /></a></div>
					<div id="bodyup1text">
					
					</div>
				</div>
				<div id="bodyup2">
					<div id="bodyup2title"><a href="#"><img src="images/index/more.jpg" width="23" height="5" border="0" /></a></div>
					<div id="bodyup2text">
						<ul>
							<li>
								<div id="bodyup2text_li_img"><img src="images/index/square.jpg" /></div>
								<div id="bodyup2text_li_text"><a href="#" class="STYLE8">沈阳校区建设</a></div>

							</li>
							<li>
								<div id="bodyup2text_li_img"><img src="images/index/square.jpg" /></div>
								<div id="bodyup2text_li_text"><a href="#" class="STYLE8">关于原产于美国、加拿大和巴西的...</a></div>

							</li>
							<li>
								<div id="bodyup2text_li_img"><img src="images/index/square.jpg" /></div>
								<div id="bodyup2text_li_text"><a href="#" class="STYLE8">关于附加限制性条件批准微软收购...</a></div>

							</li>
							<li>
								<div id="bodyup2text_li_img"><img src="images/index/square.jpg" /></div>
								<div id="bodyup2text_li_text"><a href="#" class="STYLE8">加强安全生产监督检查...</a></div>

							</li>
							<li>
								<div id="bodyup2text_li_img"><img src="images/index/square.jpg" /></div>
								<div id="bodyup2text_li_text"><a href="#" class="STYLE8">强化运输装备监管...</a></div>

							</li>
							<li>
								<div id="bodyup2text_li_img"><img src="images/index/square.jpg" /></div>
								<div id="bodyup2text_li_text"><a href="#" class="STYLE8">加强从业人员管理...</a></div>

							</li>
						</ul>

					</div>
				</div>
				<div id="bodyup3">
					<div id="bodyup3title"><a href="#"><img src="images/index/more.jpg" width="23" height="5" border="0" /></a></div>
					<div id="bodyup3text">
						
					</div>
				</div>
			</div>
			<div id="bodydown">
				<div id="bodydownleft">
					<div id="bodydownleft1">
						<div id="bodydownleft1_title"></div>
						<div id="bodydownleft1_text"><a href="#"><img src="images/index/map_pic.jpg" border="0" /></a></div>
					</div>
					<div id="bodydownleft2">
						<div id="bodydownleft2_title"></div>
						<div id="bodydownleft2_text"><a href="#"><img src="images/index/costom_pic.jpg" border="0" /></a></div>
					</div>
				</div>
				<div id="bodydownright">
					<div id="bodydownright1">
						<div id="bodydownright1_title"><a href="#"><img src="images/index/more.jpg" width="23" height="5" border="0" /></a></div>
						<div id="bodydownright1_text">
							<div id="bodydownright1_text_ad"><a href="#"><img src="images/index/ggw_pic.jpg" border="0" /></a></div>

							<div id="bodydownright1_text_list">
								<div class="STYLE10" id="bodydownright1_text_list_city">城市/行业</div>
								<div id="bodydownright1_text_list_cityccc">
									<ul>
										<li><a href="#" class="STYLE8">沈阳</a></li>
										<li><a href="#">大连</a></li>
										<li><a href="#">鞍山</a></li>
										<li><a href="#">辽阳</a></li>
										<li><a href="#">营口</a></li>
										<li><a href="#">绥中</a></li>
										<li><a href="#">葫芦岛</a></li>
										<li><a href="#">丹东</a></li>
										<li><a href="#">铁岭</a></li>
									</ul>
								</div>
							</div>
							<div id="bodydownright1_text_link">
								<ul>
									<li><a href="#"><img src="images/index/link01.jpg" border="0" /></a></li>
									<li><a href="#"><img src="images/index/link02.jpg" border="0" /></a></li>
									<li><a href="#"><img src="images/index/link03.jpg" border="0" /></a></li>
									<li><a href="#"><img src="images/index/link04.jpg" border="0" /></a></li>
									<li><a href="#"><img src="images/index/link05.jpg" border="0" /></a></li>
									<li><a href="#"><img src="images/index/link01.jpg" border="0" /></a></li>
									<li><a href="#"><img src="images/index/link02.jpg" border="0" /></a></li>
									<li><a href="#"><img src="images/index/link03.jpg" border="0" /></a></li>
									<li><a href="#"><img src="images/index/link04.jpg" border="0" /></a></li>
									<li><a href="#"><img src="images/index/link05.jpg" border="0" /></a></li>
								</ul>
							</div>
						</div>
					</div>
					<div id="bodydownright2">
						<div id="bodydownright2_title"><a href="#"><img src="images/index/more.jpg" width="23" height="5" border="0" /></a></div>
						<div id="bodydownright2_text">
							<div id="bodydownright2_text_line1">
								<div class="STYLE6" id="bodydownright2_text_line1_title">手机</div>
								<div id="bodydownright2_text_line1_list">
									<ul>
										<li><a href="#" class="STYLE8">苹果</a></li>
										<li><a href="#" class="STYLE8">三星</a></li>
										<li><a href="#" class="STYLE8">LG</a></li>
										<li><a href="#" class="STYLE8">酷派</a></li>
										<li><a href="#" class="STYLE8">索尼</a></li>
										<li><a href="#" class="STYLE8">小米</a></li>
										<li><a href="#" class="STYLE8">华为</a></li>
									</ul>
								</div>
							</div>
							<div id="bodydownright2_text_line2">
								<div class="STYLE6" id="bodydownright2_text_line2_title">大家电</div>
								<div id="bodydownright2_text_line2_list">
									<ul>
										<li class="STYLE8"><a href="#" class="STYLE8">平版电脑</a></li>
										<li><a href="#" class="STYLE8">冰箱</a></li>
										<li><a href="#" class="STYLE8">空调</a></li>
										<li><a href="#" class="STYLE8">洗衣机</a></li>
										<li><a href="#" class="STYLE8">净化器</a></li>
										<li><a href="#" class="STYLE8">空调</a></li>
										<li><a href="#" class="STYLE8">油烟机</a></li>
									</ul>
								</div>
							</div>
							<div id="bodydownright2_text_line3">
								<div class="STYLE6" id="bodydownright2_text_line3_title">个护电器</div>
								<div id="bodydownright2_text_line3_list">
									<ul>
										<li><a href="#" class="STYLE8">夏季清仓</a></li>
										<li><a href="#" class="STYLE8">剃须刀</a></li>
										<li><a href="#" class="STYLE8">洁面仪</a></li>
										<li><a href="#" class="STYLE8">电动牙刷</a></li>
										<li><a href="#" class="STYLE8">吹风机</a></li>
										<li><a href="#" class="STYLE8">足浴盆</a></li>
										<li><a href="#" class="STYLE8">护理机</a></li>
									</ul>
								</div>
							</div>
							<div id="bodydownright2_text_line4">
								<div class="STYLE6" id="bodydownright2_text_line4_title">配件</div>
								<div id="bodydownright2_text_line4_list">
									<ul>
										<li><a href="#" class="STYLE8">移动电源</a></li>
										<li><a href="#" class="STYLE8">便携音箱</a></li>
										<li><a href="#" class="STYLE8">路由器</a></li>
										<li><a href="#" class="STYLE8">U盘</a></li>
										<li><a href="#" class="STYLE8">打火机</a></li>
										<li><a href="#" class="STYLE8">数据线</a></li>
										<li><a href="#" class="STYLE8">智能机</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
<jsp:include page="footer.jsp" />
</body>
</html>
