<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trang chủ</title>
</head>
<body>
	<div class="container">
		<h1>Shop sản phẩm</h1>
		<div class="products">
			<c:forEach var="item" items="${listProductDto }">
				<div class="product">
					<div class="img">
						<img src='<c:url value="template/web/images/${item.img }" />' alt=""> 
						<span>Mua ngay</span>
					</div>
					<p>${item.name }</p>
					<p>Giá: <fmt:formatNumber pattern="#,##0 vnđ" value="${item.price }" /></p>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>