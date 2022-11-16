<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cập nhật mật khẩu</title>
</head>
<body>
	<div class="container">
		<div class="row justify-center">
			<form id="form-updatepassword" action="" method="post">
				<h2>Cập nhật mật khẩu</h2>
				<div class="group-input">
					<label for="password">Mật khẩu mới *:</label> 
					<input id="password" name="password" type="text" placeholder="Nhập mật khẩu mới" maxlength="8">
				</div>
				<div class="btn">
					<button type="submit">Cập nhật</button>
				</div>
				<div class="link">
					<a href='<c:url value="/dang-nhap" />'>Đăng nhập</a>
					<p>|</p>
					<a href='<c:url value="/quen-mat-khau" />'>Quên mật khẩu</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>