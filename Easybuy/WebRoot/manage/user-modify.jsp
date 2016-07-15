<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改用户</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<%@ include file="../include/manage-header.jsp" %>
<div id="main" class="wrap">
	<%@ include file="../include/manage-left.jsp" %>
	<div class="main">
		<h2>修改用户</h2>
		<div class="manage">
			<form action="motifyUser.action">
				<table class="form">
					<tr>
						<td class="field">用户名：</td>
						<td><input type="text" class="text" name="user.euUserName" value="${fillUser.euUserName}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="text" class="text" name="user.euPassword" value="${fillUser.euPassword}" /></td>
					</tr>
					<tr>
						<c:if test="${fillUser.euSex=='男'}">
							<td class="field">性别：</td>
							<td><input type="radio" name="user.euSex" value=1 checked="checked" />男 <input type="radio" name="user.euSex" value="2" />女</td>
						</c:if>
						<c:if test="${fillUser.euSex=='女'}">
							<td class="field">性别：</td>
							<td><input type="radio" name="user.euSex" value=1  />男 <input type="radio" name="user.euSex" value="2"  checked="checked" />女</td>
						</c:if>
						
					</tr>
					<tr>
						<td class="field">生日：</td>
						<td><input type="text" class="text" name="user.euBirthday"  value="${fillUser.euBirthday}" /></td>
						<td>格式:94/04/05</td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="user.euMobile" value="{fillUser.euMobile}" /></td>
					</tr>
					<tr>
						<td class="field">身份证号：</td>
						<td><input type="text" class="text" name="user.euIdentityCode"  value="${fillUser.euIdentityCode}"/></td>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input type="text" class="text" name="user.euEmail" value="${fillUser.euEmail}"/></td>
					</tr>
					<tr>
						<td class="field">送货地址：</td>
						<td><input type="text" class="text" name="user.euAddress" value="${fillUser.euAddress}" /></td>
					</tr>
					<tr>
						<c:if test="${fillUser.euStatus==1}">
							<td class="field">用户权限：</td>
							<td><input type="radio" name="user.euStatus" value="1" checked="checked"/>普通会员 <input type="radio" name="user.euStatus" value="2" />管理员</td>
						</c:if>
						<c:if test="${fillUser.euStatus==2}">
							<td class="field">用户权限：</td>
							<td><input type="radio" name="user.euStatus" value="1" />普通会员 <input type="radio" name="user.euStatus" value="2" checked="checked"/>管理员</td>
						</c:if>
						
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
