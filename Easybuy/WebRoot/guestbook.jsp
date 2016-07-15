<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>留言板</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<%@ include file="/include/header.jsp" %>
<%@ include file="/include/position.jsp" %>
<div id="main" class="wrap">
	<%@ include file="/include/left.jsp" %>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
				<c:forEach var="com" items="${commentPage}">
					<li>
						<dl>
						<dt>${com.ecContent}</dt>
						<dd class="author">${com.ecNickName} <span class="timer">${com.ecCreateTime}</span></dd>
						<dd>${com.ecReply}</dd>
						</dl>
					</li>
				</c:forEach>
					
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<c:if test="${pageInfo.currentPage>1}">
						<li><a href="commentListByPage.action?page=${pageInfo.currentPage-1}">上一页</a></li>
					</c:if>
					<li class="current"><a href="commentListByPage.action?page=1">1</a></li>
					<li><a href="commentListByPage.action?page=2">2</a></li>
					<li><a href="commentListByPage.action?page=3">3</a></li>
					<li><a href="commentListByPage.action?page=4">4</a></li>
					<li><a href="commentListByPage.action?page=5">5</a></li>
					<c:if test="${pageInfo.currentPage<pageInfo.totalPage}">
						<li><a href="commentListByPage.action?page=${pageInfo.currentPage+1}">下一页</a></li>
					</c:if>
				</ul>
			</div>
			<div id="reply-box">
				<form action="createComment.action">
					<table>
						<tr>
							<td class="field">昵称：</td>
							<td><input class="text" type="text" name="comment.ecNickName" /></td>
						</tr>
						<tr>
							<td class="field">留言标题：</td>
							<td><input class="text" type="text" name="guestTitle" /></td>
						</tr>
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="comment.ecContent"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
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
