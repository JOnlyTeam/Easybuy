<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>购物车</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<%@ include file="/include/header.jsp" %>
<%@ include file="/include/position.jsp" %>
<div class="wrap">
	<div id="shopping">
		<form action="productAccount.action">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<c:forEach var="pro" items="${shoppingCart}">
				  <tr id="product_id_${pro.key}">
					<td class="thumb"><img src="${pro.value.epsFileName}" height="50px" widht="50px"/><a href="productView.action?productId=${pro.key}">${pro.value.epsName}</a></td>
					<td class="price" id="price_id_${pro.key}">
						<span>${pro.value.epsTotalPrice}</span>
						<input type="hidden" value="${pro.value.epsPrice}" />
					</td>
					<td class="number">
						<dl>
							<dt><input id="number_id_${pro.key}" type="text" name="number" value="${pro.value.epsBuyNum}" /></dt>
							<dd onclick="reloadPrice(${pro.key},true);">修改</dd>
						</dl>
					</td>
					<td class="delete"><a href="delProFromCart.action?productId=${pro.key}">删除</a></td>
				  </tr>
				</c:forEach>
			</table>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
	<script type="text/javascript">
		document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
	</script>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
