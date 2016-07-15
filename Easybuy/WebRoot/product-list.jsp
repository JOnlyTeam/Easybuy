<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>商品列表</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<%@ include file="/include/header.jsp" %>
<%@ include file="/include/position.jsp" %>
<div id="main" class="wrap">
	<%@ include file="/include/left.jsp" %>
	<div class="main">
		<div class="product-list">
			<h2>全部商品</h2>
			<div class="pager">
				<ul class="clearfix">
					<c:if test="${page.currentPage>1}">
						<li><a href="productByPage.action?pageNum=${page.currentPage-1}&perpageNumber=4">上一页</a></li>
					</c:if>
					<li class="current"><a href="productByPage.action?pageNum=1&perpageNumber=4">1</a></li>
					<li><a href="productByPage.action?pageNum=2&perpageNumber=4">2</a></li>
					<li><a href="productByPage.action?pageNum=3&perpageNumber=4">3</a></li>
					<li><a href="productByPage.action?pageNum=4&perpageNumber=4">4</a></li>
					<li><a href="productByPage.action?pageNum=5&perpageNumber=4">5</a></li>
					<c:if test="${page.currentPage<page.totalPage}">
						<li><a href="productByPage.action?pageNum=${page.currentPage+1}&perpageNumber=4">下一页</a></li>
					</c:if>
				</ul>
			</div>
			<div class="clear"></div>
			<ul class="product clearfix">
			  <c:forEach var="product" items="${productForPage}">
				<li>
					<dl>
						<dt><a href="productView.action?productId=${product.epId}" target="_blank"><img src="${product.epFileName}"/></a></dt>
						<dd class="title"><a href="productView.action?productId=${product.epId}" target="_blank">${product.epName}</a></dd>
						<dd class="price">${product.epPrice}</dd>
					</dl>
				</li>
			  </c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<c:if test="${page.currentPage>1}">
						<li><a href="productByPage.action?pageNum=${page.currentPage-1}&perpageNumber=4">上一页</a></li>
					</c:if>
					<li class="current"><a href="productByPage.action?pageNum=1&perpageNumber=4">1</a></li>
					<li><a href="productByPage.action?pageNum=2&perpageNumber=4">2</a></li>
					<li><a href="productByPage.action?pageNum=3&perpageNumber=4">3</a></li>
					<li><a href="productByPage.action?pageNum=4&perpageNumber=4">4</a></li>
					<li><a href="productByPage.action?pageNum=5&perpageNumber=4">5</a></li>
					<c:if test="${page.currentPage<page.totalPage}">
						<li><a href="productByPage.action?pageNum=${page.currentPage+1}&perpageNumber=4">下一页</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
