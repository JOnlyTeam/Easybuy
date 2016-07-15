<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻详情</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<%@ include file="/include/header.jsp" %>
<%@ include file="/include/position.jsp" %>
<div id="main" class="wrap">
	<div class="left-side">
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
	<div id="news" class="right-main">
		<h1>${newsMessage.enTitle}</h1>
		<div class="content">
			${newsMessage.enTitle}
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
