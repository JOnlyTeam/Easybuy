<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加分类</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<%@ include file="../include/manage-header.jsp" %>
<div id="main" class="wrap">
	<%@ include file="../include/manage-left.jsp" %>
	<div class="main">
		<h2>添加分类</h2>
		<div class="manage">
			<form action="updateProductClass.action">
				<table class="form">
					<tr>
						<td class="field">父分类：</td>
						<td>
							<select name="parentId">
								<option value="0" selected="selected">根栏目</option>
								<c:forEach var="temp" items="${proClass}">
									<c:if test="${temp.epcParentId==0}">
										<option value="${temp.epcId}">${temp.epcName}</option>
									</c:if>
								</c:forEach>	
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">分类名称：</td>
						<td><input type="text" class="text" name="className" value="" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="添加" /></label></td>
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
