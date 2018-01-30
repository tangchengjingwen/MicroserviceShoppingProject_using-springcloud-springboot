<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<!-- 屏幕宽度 && 放大比例 && minimal-ui Safari 网页加载时隐藏地址栏与导航栏-->
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-
	scale=1,maximum-scale=1,user-scalable=0,minimal-ui">
<!-- safari私有meta标签，允许全屏模式浏览 -->
<meta content="yes" name="apple-mobile-web-app-capable" />
<!-- ios系统的私有标签，它指定在web app状态下，ios设备中顶端的状态条的颜色 -->
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<!-- 设备浏览网页时对数字不启用电话功能 -->
<meta content="telephone=no,email=no" name="format-detectPion" />
<title>Jiuchacha</title>
<link rel="stylesheet" href="css/common.css">
<!-- 自适应样式单 -->
<link rel="stylesheet" href="css/adaptive.css">
<!-- 加载前动画样式 -->
<link rel="stylesheet" href="css/loadiPng.css">
<link rel="stylesheet" href="css/index.css">
<!-- 移动端滑动&轮播框架 -->
<script src="js/ready.js"></script>
<script src="js/swipe.js"></script>
<script type="text/javascript">
	/* loading ready */
	document.ready(function() {
		document.getElementById("loading").style.display = "none";
	});
</script>
</head>
<body>
	<!-- loading -->
	<div id="loading" style="height: 100%;">
		<div class="spinner">
			<div class="spinner-container container1">
				<div class="circle1"></div>
				<div class="circle2"></div>
				<div class="circle3"></div>
				<div class="circle4"></div>
			</div>
			<div class="spinner-container container2">
				<div class="circle1"></div>
				<div class="circle2"></div>
				<div class="circle3"></div>
				<div class="circle4"></div>
			</div>
			<div class="spinner-container container3">
				<div class="circle1"></div>
				<div class="circle2"></div>
				<div class="circle3"></div>
				<div class="circle4"></div>
			</div>
		</div>
	</div>

	<!-- all content  -->
	<div class="wrapper" id="content">
		<!-- header start -->
		<div class="header">
			<!-- 绝对定位的logo -->
			<div class="logo">
				<a href="/" title="酒查查商城" class="home"> <span>酒查查商城</span>
				</a>
			</div>
			<!-- 占据高度DIV -->
			<div class="tit"></div>
			<!-- 绝对定位的右侧个人中心 && 购物车-->
			<div class="right">
				<ul>
					<li class="user"><a href="user.html" title="个人中心"> <span
							class="icon icon-gerenzhongxin"></span>
					</a></li>
					<li class="cart"><a href="cart.html" title="购物车"> <span
							class="icon icon-gouwuche"></span>
					</a></li>
				</ul>
			</div>
		</div>
		<!-- header end -->

		<!-- banner start -->
		<div id="slider" class="slider card card-nomb"
			style="visibility: visiable;">
			<div class="swipe-wrap">
				<div data-log="A0-http://s1.mi.com/m/product/hmnote2/index.html"
					data-index="0">
					<div data-href="http://s1.mi.com/m/product/hmnote2/index.html">
						<span class="imgurl"><img
							src="http://i3.mifile.cn/a4/T1uNAvBmZv1RXrhCrK.jpg"></span>
					</div>
				</div>

				<div
					data-log="A1-http://a.hd.mi.com/productv2/book/a/51/m/1/s/miwater"
					data-index="1">
					<div
						data-href="http://a.hd.mi.com/productv2/book/a/51/m/1/s/miwater">
						<span class="imgurl"><img
							src="http://i3.mifile.cn/a4/T1EiWvBXZv1RXrhCrK.jpg"></span>
					</div>
				</div>

				<div data-log="A0-http://s1.mi.com/m/product/hmnote2/index.html"
					data-index="2">
					<div data-href="http://s1.mi.com/m/product/hmnote2/index.html">
						<span class="imgurl"><img
							src="http://i3.mifile.cn/a4/T1uNAvBmZv1RXrhCrK.jpg"></span>
					</div>
				</div>

				<div
					data-log="A1-http://a.hd.mi.com/productv2/book/a/51/m/1/s/miwater"
					data-index="3">
					<div
						data-href="http://a.hd.mi.com/productv2/book/a/51/m/1/s/miwater">
						<span class="imgurl"><img
							src="http://i3.mifile.cn/a4/T1EiWvBXZv1RXrhCrK.jpg"></span>
					</div>
				</div>
			</div>

			<div class="swipe-nav" id="bottomNav">
				<span class="on">&nbsp;</span> <span class="">&nbsp;</span>
			</div>
		</div>
		<!-- banner end -->

		<!-- menu start -->
		<div class="nav-wrap nav-index">
			<div id="slider_nav" class="swipe" style="visibility: visiable;">
				<div class="swipe-wrap">

					<div data-index="0">
						<ul>
							<li><a href="category.html" data-log="B0-#/product/category"
								data-stat-id="2c1ee89f7411236e"><span
									class="icon icon-quanbushangpin"></span><span class="t"><span>全部商品</span></span></a></li>
							<li><a href="search.html" data-log="B1-#/search"
								data-stat-id="4be0bd1e89e75509"
								onclick="_msq.push(['trackEvent', 'c499efdd9c939a49-4be0bd1e89e75509', '#/search', 'pcpid']);"><span
									class="icon icon-sousuo"></span><span class="t"><span>搜索</span></span></a></li>
							<li><a href="http://m.xiaomi.cn/"
								data-log="B2-http://m.xiaomi.cn/"
								data-stat-id="edfd3e1d45a48ac3"
								onclick="_msq.push(['trackEvent', 'c499efdd9c939a49-edfd3e1d45a48ac3', 'http://m.xiaomi.cn/', 'pcpid']);"><span
									class="icon icon-shequ"></span><span class="t"><span>小米社区</span></span></a></li>
							<li><a href="download.html"
								data-log="B3-http://s1.mi.com/m/huodong/page/2013/0922/index.html"
								class="red" data-stat-id="78f6000f07292bd2"
								onclick="_msq.push(['trackEvent', 'c499efdd9c939a49-78f6000f07292bd2', 'http://s1.mi.com/m/huodong/page/2013/0922/index.html', 'pcpid']);"><span
									class="icon icon-kehuduan"></span><span class="t"><span>客户端</span></span></a></li>
						</ul>
					</div>

					<div data-index="1">
						<ul>
							<li><a href="#/heyue" data-log="B0-#/heyue"
								data-stat-id="b2173beffbc2a4b5"
								onclick="_msq.push(['trackEvent', 'c499efdd9c939a49-b2173beffbc2a4b5', '#/heyue', 'pcpid']);"><span
									class="icon icon-heyueji"></span><span class="t"><span>合约机</span></span></a></li>
							<li><a href="#/fcode" data-log="B1-#/fcode"
								data-stat-id="90f2ce1fecd81997"
								onclick="_msq.push(['trackEvent', 'c499efdd9c939a49-90f2ce1fecd81997', '#/fcode', 'pcpid']);"><span
									class="icon icon-fcode"></span><span class="t"><span>F码频道</span></span></a></li>
							<li><a href="#/recharge/productlist"
								data-log="B2-#/recharge/productlist"
								data-stat-id="a1bc230f9e518de9"
								onclick="_msq.push(['trackEvent', 'c499efdd9c939a49-a1bc230f9e518de9', '#/recharge/productlist', 'pcpid']);"><span
									class="icon icon-huafeichongzhi"></span><span class="t"><span>话费充值</span></span></a></li>
						</ul>
					</div>

				</div>
			</div>
		</div>
		<!-- list one start -->
		<div class="list">
			<#if mapItem?exists> <#list mapItem?keys as key>
			<div class="head">
				<span>${key}</span>
			</div>

			<div class="list-cell">



				<#list mapItem["${key}"] as u> <#if u_index %2!=1 >
				<div class="row">
					</#if>
					<div class="cell">
						<a
							data-log="itemDesc?id=${u.id}"
							href="itemDesc?id=${u.id}" data-stat-id="d4bfa347f5a83ea8"> <span class="imgurl"><img
								src="${u.image}"></span><span class="p"><span>${u.title}</span></span><span
							class="p"><span style="color: red">${u.price}元起</span> <del></del></span></a>
					</div>
					<#if u_index %2!=0 >
				</div>
				</#if> </#list> </#list> </#if>
			</div>
			<!-- list one end -->



			<!-- more start -->
			<div class="col1 more">
				<a href="/v2.html#/product/category" data-stat-id="916259ec7bf4348f"
					onclick="_msq.push(['trackEvent', 'c499efdd9c939a49-916259ec7bf4348f', '/v2.html#/product/category', 'pcpid']);">
					<span>查看更多配件&nbsp;&gt;</span>
				</a>
			</div>
			<!-- more end -->

			<!-- footer start -->
			<div class="footer">
				<div class="tip">
					<a href="http://www.mi.com/?mobile" class="goDesktop"
						data-stat-id="8d858a68b4b01291"
						onclick="_msq.push(['trackEvent', 'c499efdd9c939a49-8d858a68b4b01291', 'http://www.mi.com/', 'pcpid']);"><span>切换到电脑版</span></a>
				</div>
				<div class="links">
					<a
						href="http://p.www.xiaomi.com/m/huodong/page/2013/0922/index.html"
						data-stat-id="ab305527e5d218c8"
						onclick="_msq.push(['trackEvent', 'c499efdd9c939a49-ab305527e5d218c8', 'http://p.www.xiaomi.com/m/huodong/page/2013/0922/index.html', 'pcpid']);"><span
						class="linksBtn">立即下载</span>
						<p>
							<strong>小米商城客户端</strong><span>与米粉交朋友</span>
						</p></a>
				</div>
			</div>
			<!-- footer end -->

			<script type="text/javascript">
				var bottom = document.getElementById("bottomNav")
						.getElementsByTagName("span");
				// 轮播&滑动事件
				var slider = Swipe(document.getElementById('slider_nav'), {
					continuous : true, //无限循环的图片切换效果
					disableScroll : true, //阻止由于触摸而滚动屏幕
					stopPropagation : false, //停止滑动事件
				});

				var sliderBanner = Swipe(document.getElementById('slider'), {
					auto : 2500,
					continuous : true,
					disableScroll : false,
					stopPropagation : false,
					callback : function(index) {
						if (index % 2) {
							bottom[0].className = "";
							bottom[1].className = "on";
						} else {
							bottom[0].className = "on";
							bottom[1].className = "";
						}
					}, //回调函数，切换时触发
				});
			</script>
		</div>
</body>
</html>