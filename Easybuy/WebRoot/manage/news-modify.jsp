<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改新闻</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<%@ include file="../include/manage-header.jsp" %>
<div id="main" class="wrap">
	<%@ include file="../include/manage-left.jsp" %>
	<div class="main">
		<h2>修改新闻</h2>
		<div class="manage">
			<form action="updateNews.action">
				<table class="form">
					<tr hidden="hidden">
						<td><input type="text" class="text" name="news.enId" value="${fillNews.enId}" /></td>
					</tr>
					<tr>
						<td class="field">新闻标题：</td>
						<td><input type="text" class="text" name="news.enTitle" value="${fillNews.enTitle}" /></td>
					</tr>
					<tr>
						<td class="field">新闻内容：</td>
						<td><textarea name="news.enContent" value="${fillNews.enContent}"></textarea></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="修改" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
