<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网-首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<%@ include file="/include/header.jsp" %>
<div id="main" class="wrap">
	<%@ include file="/include/left.jsp" %>
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
