<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.geek.bean.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品详情</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<%@ include file="/include/header.jsp" %>
<%@ include file="/include/position.jsp" %>
<div id="main" class="wrap">
	<%@ include file="/include/left.jsp" %>
	<div id="product" class="main">
		<h1>${product.epName}</h1>
		<div class="infos">
			<div class="thumb"><img src="${product.epFileName}" height="300" width="300"/></div>
			<div class="buy">
				<p>商城价：<span class="price">${product.epPrice}</span></p>
				<p>库　存：${product.epStock}</p>
				<div class="button"><input type="button" name="button" value="" onclick="goBuy('${product.epId}')" /><a href="#">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				${product.epDescription}
			</div>
		</div>
		<%
			EasybuyProduct product = (EasybuyProduct)session.getAttribute("product");
			Cookie[] cookies = request.getCookies();
			List<Cookie> cookieList = new ArrayList<Cookie>();
			Cookie tempCookie = null;
			if(cookies!=null && cookies.length>0){
				for(Cookie c:cookies){
					String cookieName = c.getName();
					if(cookieName.startsWith("LastLook_")){
						cookieList.add(c);
					}
					
					if(c.getValue().equals(product.getEpId())){
						tempCookie = c;
					}
				}
			}
			if(cookieList.size() >= 5 && tempCookie == null){
				tempCookie = cookieList.get(0);
			}
			if(tempCookie != null){
				tempCookie.setMaxAge(0);
				response.addCookie(tempCookie);
			}
			int id = product.getEpId();
			Cookie cookie = new Cookie("LastLook_"+id, id+"");
			response.addCookie(cookie);
		%>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
