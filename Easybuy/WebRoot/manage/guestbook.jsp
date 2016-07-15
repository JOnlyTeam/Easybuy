<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>留言管理</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<%@ include file="../include/manage-header.jsp" %>
<div id="main" class="wrap">
	<%@ include file="../include/manage-left.jsp" %>
	<div class="main">
		<h2>留言管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>留言内容</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach var="com" items="${commentPage}">
					<tr>
					<td class="first w4 c">${com.ecId}</td>
					<td class="w1 c">${com.ecNickName}</td>
					<td>${com.ecContent}</td>
					<td class="w1 c">已回复</td>
					<td class="w1 c"><a href="guestbook-modify.jsp">回复</a> <a href="javascript:Delete(1);">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="pager">
				<ul class="clearfix">
					<c:if test="${pageInfo.currentPage>1}">
						<li><a href="commentListByPage.action?page=${pageInfo.currentPage-1}">上一页</a></li>
					</c:if>
					<li class="current"><a href="loadCommentList.action?page=1">1</a></li>
					<li><a href="loadCommentList.action?page=2">2</a></li>
					<li><a href="loadCommentList.action?page=3">3</a></li>
					<li><a href="loadCommentList.action?page=4">4</a></li>
					<li><a href="loadCommentList.action?page=5">5</a></li>
					<c:if test="${pageInfo.currentPage<pageInfo.totalPage}">
						<li><a href="loadCommentList.action?page=${pageInfo.currentPage+1}">下一页</a></li>
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
