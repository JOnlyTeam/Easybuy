<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>

<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help">
		<a href="#" class="shopping">购物车</a>
		<c:if test="${logedin==null}">
			<a href="login.jsp">登录</a>
			<a href="register.jsp">注册</a>
		</c:if>	
		<a href="guestbook.jsp">留言</a>
	</div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="#">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach var="cat" items="${category}">
					<c:if test="${cat.epcParentId == 0}">
						<dt>${cat.epcName}</dt>
					</c:if>
					<c:forEach var= "scat" items="${category}">
						<c:if test="${scat.epcParentId==cat.epcId}">
							<dd><a href="productByPage.action?pageNum=1&perpageNumber=2">${scat.epcName}</a></dd>
						</c:if>
					</c:forEach>	
				</c:forEach>
				
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<c:forEach var="product" items="${LastLook}">
					<dt><img src="${product.epFileName}" width="50" height="50"/></dt>
					<dd><a href="productView.action?productId=${product.epId}">${product.epName}</a></dd>
				</c:forEach>
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="price-off">
			<h2>今日特价</h2>
			<ul class="product clearfix">
				<c:forEach var="pro" items="${salePrices}"> 
					<li>
						<dl>
							
							<dt><a href="productView.action?productId=${pro.epId}" target="_blank"><img src="${pro.epFileName}"></a></dt>
							<dd class="title"><a href="productView.action?productId=${pro.epId}" target="_blank">${pro.epName}</a></dd>
							<dd class="price">${pro.epPrice}</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="side">
			<div class="news-list">
				<h4>最新公告</h4>
				<ul>
				<c:forEach var="anno" items="${annoList}" >
          			<li><a href="annoView.action?annoId=${anno.eanId}" target="_blank">${anno.eanTitle}</a></li>
          		</c:forEach>
				</ul>
			</div>
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul>
				<c:forEach var="news" items="${newsList}">
          			<li><a href="newsView.action?newsId=${news.enId}" target="_blank">${news.enTitle}</a></li>
          		</c:forEach>
          		</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
		<div class="hot">
			<h2>热卖推荐</h2>
			<ul class="product clearfix">
				<c:forEach var="hot" items="${hotSales}" > 
					<li>
						<dl>
							
							<dt><a href="productView.action?productId=${hot.epId}" target="_blank"><img src="${hot.epFileName}"></a></dt>
							<dd class="title"><a href="productView.action?productId=${hot.epId}" target="_blank">${hot.epName}</a></dd>
							<dd class="price">${hot.epPrice}</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
