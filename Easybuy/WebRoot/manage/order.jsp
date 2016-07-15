<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单管理</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<%@ include file="../include/manage-header.jsp" %>
<div id="main" class="wrap">
	<%@ include file="../include/manage-left.jsp" %>
	<div class="main">
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">
				<form method="get" action="queryOrder.action">
					订单号：<input type="text" class="text" name="orderId" /> 订货人：<input type="text" class="text" name="userName" /> <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
				</form>
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>发货地址</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach var="order" items="${orderForPage}">
					<tr>
					<td class="first w4 c">${order.eoId}</td>
					<td class="w1 c">${order.eoUserName}</td>
					<td>${order.eoUserAddress}</td>
					<td class="w1 c">下单成功</td>
					<td class="w1 c"><a href="order-modify.jsp">修改</a> <a href="deleteOrder.action?orderId=${order.eoId}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="pager">
				<ul class="clearfix">
					<c:if test="${page.currentPage>1}">
						<li><a href="loadOrderList.action?pageNum=${page.currentPage-1}&perpageNumber=5">上一页</a></li>
					</c:if>
					<li class="current"><a href="loadOrderList.action?pageNum=1&perpageNumber=5">1</a></li>
					<li><a href="loadOrderList.action?pageNum=2&perpageNumber=5">2</a></li>
					<li><a href="loadOrderList.action?pageNum=3&perpageNumber=5">3</a></li>
					<li><a href="loadOrderList.action?pageNum=4&perpageNumber=5">4</a></li>
					<li><a href="loadOrderList.action?pageNum=5&perpageNumber=5">5</a></li>
					<c:if test="${page.currentPage<page.totalPage}">
						<li><a href="loadOrderList.action?pageNum=${page.currentPage+1}&perpageNumber=5">下一页</a></li>
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
