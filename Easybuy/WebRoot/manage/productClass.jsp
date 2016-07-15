<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>分类管理</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<%@ include file="../include/manage-header.jsp" %>
<div id="main" class="wrap">
	<%@ include file="../include/manage-left.jsp" %>
	<div class="main">
		<h2>分类管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>分类名称</th>
					<th>操作</th>
				</tr>
				<c:forEach var="cat" items="${proClass}">
					<c:if test="${cat.epcParentId==0}">
						<tr>
						<td class="first w4 c">${cat.epcId}</td>
						<td>${cat.epcName}</td>
						<td class="w1 c"><a href="productClass-modify.jsp">修改</a> <a href="deleteProductClass.action?classId=${cat.epcId}">删除</a></td>
						</tr>
					</c:if>
					<c:forEach var="icat" items="${proClass}">
						<c:if test="${icat.epcParentId==cat.epcId}">
						<tr>
						<td class="first w4 c">${icat.epcId}</td>
						<td class="childClass">${icat.epcName}</td>
						<td class="w1 c"><a href="productClass-modify.jsp">修改</a> <a href="deleteProductClass.action?classId=${icat.epcId}">删除</a></td>
						</tr>
						</c:if>
					</c:forEach>
				</c:forEach>
				
			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
