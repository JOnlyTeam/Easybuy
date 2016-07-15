f<%@ page contentType="text/html;charset=utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加商品</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<%@ include file="../include/manage-header.jsp" %>
<div id="main" class="wrap">
	<%@ include file="../include/manage-left.jsp" %>
	<div class="main">
		<h2>添加商品</h2>
		<div class="manage">
			<form action="manage-result.jsp">
				<table class="form">
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" class="text" name="productName" value="铁三角 Audio-Technica ATH-EQ300M-SV 银色 挂耳式耳机" /></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="parentId">
								<option value="1">电器</option>
								<option value="3">├ 电器</option>
								<option value="3">└ 电器</option>
								<option value="2">衣服</option>
								<option value="3">├ 电器</option>
								<option value="3">└ 电器</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" class="text" name="photo" /></td>
					</tr>
					<tr>
						<td class="field">商品价格：</td>
						<td><input type="text" class="text tiny" name="productPrice" /> 元</td>
					</tr>
					<tr>
						<td class="field">品牌：</td>
						<td><input type="text" class="text" name="productName" /></td>
					</tr>
					<tr>
						<td class="field">库存：</td>
						<td><input type="text" class="text tiny" name="productName" /></td>
					</tr>
					<tr>
						<td class="field">条码号：</td>
						<td><input type="text" class="text" name="productName" /></td>
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
