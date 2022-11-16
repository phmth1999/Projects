<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Xác nhận</title>
</head>
<body>
	<div class="container">
		<div class="row justify-center">
			<form id="form-confirm" action="" method="post">
				<h2>Xác nhận</h2>
				<div class="group-input">
					<label for="code">Mã xác nhận *:</label> 
					<input id="code" name="code" type="text" placeholder="Nhập mã xác nhận" maxlength="6">
				</div>
				<div class="btn">
					<button type="submit">Xác nhận</button>
				</div>
				<div class="link">
					<a href='<c:url value="/dang-nhap" />'>Đăng nhập</a>
					<p>|</p>
					<a href='<c:url value="/quen-mat-khau" />'>Gửi lại</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>