<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<%@ include file="../include/manage-header.jsp" %>
<div id="main" class="wrap">
	<%@ include file="../include/manage-left.jsp" %>
	<div class="main">
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td class="first w4 c">${user.euUserId}</td>
						<td class="w1 c">${user.euUserName}</td>
						<td class="w2 c">${user.euSex}</td>
						<td>${user.euEmail}</td>
						<td class="w4 c">${user.euMobile}</td>
						<td class="w1 c"><a href="makeUserFill.action?id=${user.euUserId}">修改</a> <a href="javascript:Delete(${user.euUserId});">删除</a></td>
						</tr>
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
