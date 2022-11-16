<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quên mật khẩu</title>
</head>
<body>
	<div class="container">
		<div class="row justify-center">
			<form id="form-forgotpassword" action="" method="post">
				<h2>Quên mật khẩu</h2>
				<div class="group-input">
					<label for="email">Email *:</label> 
					<input id="email" name="email" type="text" placeholder="Nhập email" maxlength="50">
				</div>
				<div class="btn">
					<button type="submit">Gửi</button>
				</div>
				<div class="link">
					<a href='<c:url value="/dang-nhap" />'>Đăng nhập</a>
					<p>|</p>
					<a href='<c:url value="/dang-ki" />'>Đăng kí</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>