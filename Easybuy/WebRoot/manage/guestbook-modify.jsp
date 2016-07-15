<%@ page contentType="text/html;charset=utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>留言修改</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<%@ include file="../include/manage-header.jsp" %>
<div id="main" class="wrap">
	<%@ include file="../include/manage-left.jsp" %>
	<div class="main">
		<h2>回复留言</h2>
		<div class="manage">
			<form action="manage-result.jsp">
				<table class="form">
					<tr>
						<td class="field">留言ID：</td>
						<td><input type="text" class="text" name="orderId" value="100000" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">留言姓名：</td>
						<td><input type="text" class="text" name="name" value="张三" /></td>
					</tr>
					<tr>
						<td class="field">留言内容：</td>
						<td>高老庄的货发了没？</td>
					</tr>
					<tr>
						<td class="field">回复内容：</td>
						<td><textarea name="replyContent"></textarea></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
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
